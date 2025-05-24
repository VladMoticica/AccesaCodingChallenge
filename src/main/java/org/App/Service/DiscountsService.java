package org.App.Service;

import org.App.Models.Discounts;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Discounts> findBestDeals() {
        LocalDate today = LocalDate.now();

        return getAllDiscounts().stream()
                .filter(d -> !d.getD_from_date().isAfter(today)) // from_date <= today
                .filter(d -> !d.getD_to_date().isBefore(today))  // to_date >= today
                .sorted(Comparator.comparing(Discounts::getD_percentage_of_discount).reversed())
                .limit(15)
                .toList();
    }

    public List<Discounts> findNewDiscounts() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        return getAllDiscounts().stream()
                .filter(d -> {
                    LocalDate fromDate = d.getD_from_date();
                    return fromDate.equals(today) || fromDate.equals(yesterday);
                })
                .sorted(Comparator.comparing(Discounts::getD_from_date).reversed()) // most recent first
                .toList();
    }

    public List<Discounts> getDiscountsByStore(String store) {
        return discountsByStore.getOrDefault(store, new ArrayList<>());
    }
}