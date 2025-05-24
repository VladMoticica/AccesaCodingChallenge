package org.App.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Price Comparator - Market</title>
            </head>
            <body>
                <h1>Home Page (localhost:8080/home)</h1>
                <h2>The following addresses are available:</h2>
               \s
                <p><b>localhost:8080/products</b>  -  lists all products available</p>
                <p><b>localhost:8080/products/store/{storeName}</b>  -  lists all products from a certain store; storeName options: lidl/kaufland/profi/mega</p>
                <p><b>localhost:8080/products/categories</b>  -  lists all categories of products available</p>
                <p><b>localhost:8080/products/category/{categoryName}</b>  -  lists all products under a certain category; categoryName examples: carne/lactate/ouă/băuturi etc. (see above address for full list)</p>
                <p><b>localhost:8080/products/best</b>  -  lists best buy products by calculating 'value per unit' for each product</p>
               \s
                <p><b>localhost:8080/discounts</b>  -  lists all discounts available</p>
                <p><b>localhost:8080/discounts/deals</b>  -  lists the 15 biggest active discounts (as of the current date)</p>
                <p><b>localhost:8080/discounts/new</b>  -  lists the newest active discounts (as of the current date)</p>
                <p><b>localhost:8080/discounts/store/{storeName}</b>  -  lists all discounts from a certain store; storeName options: lidl/kaufland/profi/mega</p>
            </body>
            </html>
       \s""";
    }
}