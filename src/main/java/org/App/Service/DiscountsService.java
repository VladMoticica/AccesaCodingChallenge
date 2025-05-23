package org.App.Service;

import org.App.Basic.Discounts;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiscountsService {
    private final Map<String, List<Discounts>> discountsByStore = new HashMap<>();

    public void addDiscount(String store, Discounts discount) {
        discountsByStore.computeIfAbsent(store, k -> new ArrayList<>()).add(discount);
    }

    public List<Discounts> getAllDiscounts() {
        List<Discounts> all = new ArrayList<>();
        discountsByStore.values().forEach(all::addAll);
        return all;
    }

    public List<Discounts> getDiscountsByStore(String store) {
        return discountsByStore.getOrDefault(store, new ArrayList<>());
    }
}