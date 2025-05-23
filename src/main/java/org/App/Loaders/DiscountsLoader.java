package org.App.Loaders;

import jakarta.annotation.PostConstruct;
import org.App.Basic.Discounts;
import org.App.Service.DiscountsService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


@Component
public class DiscountsLoader {
    private final DiscountsService discountService;

    public DiscountsLoader(DiscountsService discountService) {
        this.discountService = discountService;
    }

    @PostConstruct
    public void loadDiscountCsvFiles() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] discountFiles = resolver.getResources("classpath:data/*.csv");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Resource file : discountFiles) {
            String filename = Objects.requireNonNull(file.getFilename());
            String store = filename.split("_")[0];

            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");
                if (tokens.length < 9) continue;

                try {
                    Discounts d = new Discounts();
                    d.setD_product_id(tokens[0]);
                    d.setD_product_name(tokens[1]);
                    d.setD_brand(tokens[2]);
                    d.setD_package_quantity(Float.parseFloat(tokens[3]));
                    d.setD_package_unit(tokens[4]);
                    d.setD_product_category(tokens[5]);
                    d.setD_from_date(LocalDate.parse(tokens[6], formatter));
                    d.setD_to_date(LocalDate.parse(tokens[7], formatter));
                    d.setD_percentage_of_discount(Integer.parseInt(tokens[8]));

                    discountService.addDiscount(store, d);
                } catch (Exception ignored) {}
            }
        }
    }
}