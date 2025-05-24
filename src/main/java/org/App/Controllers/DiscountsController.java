package org.App.Controllers;

import org.App.Basic.Discounts;
import org.App.Service.DiscountsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/discounts")
public class DiscountsController {
    private final DiscountsService serviceD;

    public DiscountsController(DiscountsService serviceD) {
        this.serviceD = serviceD;
    }

    @GetMapping
    public List<Discounts> getAllDiscounts() {
        return serviceD.getAllDiscounts();
    }

    @GetMapping("/deals")
    public List<Discounts> getBestDeals() {
        return serviceD.findBestDeals();
    }

    @GetMapping("/new")
    public List<Discounts> getNewDiscounts() {
        return serviceD.findNewDiscounts();
    }

    @GetMapping("/store/{store}")
    public List<Discounts> getDByStore(@PathVariable String store) {
        return serviceD.getDiscountsByStore(store);
    }
}