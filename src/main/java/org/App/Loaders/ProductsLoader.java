package org.App.Loaders;

import org.App.Basic.Products;
import org.App.Service.ProductsService;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;


@Component
public class ProductsLoader {
    private final ProductsService productService;

    public ProductsLoader(ProductsService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void loadCsvData() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] csvFiles = resolver.getResources("classpath:data/*.csv");

        for (Resource file : csvFiles) {
            String filename = Objects.requireNonNull(file.getFilename());
            String store = filename.split("_")[0];
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");

                if (tokens.length < 8) continue;

                try{
                    Products p = new Products();
                    p.setP_product_id(tokens[0]);
                    p.setP_product_name(tokens[1]);
                    p.setP_product_category(tokens[2]);
                    p.setP_brand(tokens[3]);
                    p.setP_package_quantity(Float.parseFloat(tokens[4]));
                    p.setP_package_unit(tokens[5]);
                    p.setP_price(Float.parseFloat(tokens[6]));
                    p.setP_currency(tokens[7]);

                    productService.addProduct(store, p);
                } catch (Exception e) {
                    System.err.println("Failed to parse line in " + filename + ": " + line);
                }
            }
            System.out.println("Loaded PRODUCTS from: " + filename);
        }
    }
}