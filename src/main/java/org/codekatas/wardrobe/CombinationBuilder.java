package org.codekatas.wardrobe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationBuilder {

    private final int MAX_WIDTH;
    private final List<Integer> availableSizes;
    private final Set<List<Integer>> combinations = new HashSet<>();

    public CombinationBuilder(int width, List<Integer> availableSizes) {
        this.MAX_WIDTH = width;
        this.availableSizes = availableSizes;
    }

    public List<List<Integer>> getAllCombination() {
        backtrack(new ArrayList<>(), 0);
        return new ArrayList<>(combinations);
    }

    private void backtrack(List<Integer> current, int sum) {
        if (sum == MAX_WIDTH) {
            List<Integer> sorted = new ArrayList<>(current);
            Collections.sort(sorted);
            combinations.add(sorted);
            return;
        }

        if (sum > MAX_WIDTH) {
            return;
        }

        for(int option : availableSizes) {
            current.add(sum);
            backtrack(current, sum + option);
            current.remove(current.size() - 1);
        }
    }
}
