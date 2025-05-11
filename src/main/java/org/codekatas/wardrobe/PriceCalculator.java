package org.codekatas.wardrobe;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceCalculator {

    private final Map<Integer, Integer> priceForSize;

    public PriceCalculator(Map<Integer, Integer> priceForSize) {
        this.priceForSize = priceForSize;
    }


    public List<List<Integer>> findCheapest(List<List<Integer>> combinations) {
        int minPrice = combinations.stream()
                .mapToInt(this::calculatePrice)
                .min()
                .orElse(0);

        return combinations.stream()
                .filter(combination -> calculatePrice(combination) == minPrice)
                .collect(Collectors.toList());
    }

    private int calculatePrice(List<Integer> combination) {
        return combination.stream()
                .mapToInt(size -> priceForSize.getOrDefault(size, 0))
                .sum();
    }
}
