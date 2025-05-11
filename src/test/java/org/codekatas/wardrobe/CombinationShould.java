package org.codekatas.wardrobe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombinationShould {

    private final int MAX_WIDTH = 250;
    private final List<Integer> availableSizes = List.of( 50, 75, 100, 120);
    CombinationBuilder combinationBuilder;

    @BeforeEach
    public void setup() {
        combinationBuilder = new CombinationBuilder(MAX_WIDTH, availableSizes);
    }

    @Test
    public void return_all_combinations() {
        List<List<Integer>> combinations = combinationBuilder.getAllCombination();
        assertEquals(17, combinations.size());
        assertEquals(List.of(0, 50, 150), combinations.get(0));

    }

    @Test
    public void should_return_prices_of_all_combinations() {
        PriceCalculator priceCalculator = new PriceCalculator(Map.of(50, 59,
                75, 62,
                100, 90,
                120, 111));

        List<List<Integer>> combinations = combinationBuilder.getAllCombination();
        List<List<Integer>> cheapestCombinations = priceCalculator.findCheapest(combinations);
        assertTrue(cheapestCombinations.contains(List.of(0, 50, 150)));
        assertTrue(cheapestCombinations.contains(List.of(0, 50, 125, 175)));
        assertTrue(cheapestCombinations.contains(List.of(0, 50, 150, 200)));
        assertTrue(cheapestCombinations.contains(List.of(0, 50, 125, 200)));
    }
}
