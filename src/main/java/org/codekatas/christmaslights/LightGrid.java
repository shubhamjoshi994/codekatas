package org.codekatas.christmaslights;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LightGrid {

    private final int MAX_X = 1000;
    private final int MAX_Y = 1000;
    private final int MIN_X = 0;
    private final int MIN_Y = 0;
    private final Light[][] lights = new Light[MAX_X][MAX_Y];

    public LightGrid() {
        initializeGrid();
    }

    public void turnOn(CoordinatePair coordinatePair) {
        execute(coordinatePair, Light::turnOn);
    }

    public void turnOff(CoordinatePair coordinatePair) {
        execute(coordinatePair, Light::turnOff);
    }

    public void toggle(CoordinatePair coordinatePair) {
        execute(coordinatePair, Light::toggle);
    }

    public Light getLight(int row, int column) {
        return lights[row][column];
    }

    public int countOn() {
        AtomicInteger count = new AtomicInteger();
        forEachCoordinate((x, y) ->{
            if(getLight(x, y).isOn())
                count.getAndIncrement();
        });

        return count.get();
    }

    private void initializeGrid() {
        forEachCoordinate((x, y) -> lights[x][y] = new Light());
    }

    private void forEachCoordinate(BiConsumer<Integer, Integer> biConsumer) {
        for (int x = MIN_X; x < MAX_X; x++) {
            for (int y = MIN_Y; y < MAX_Y; y++) {
                biConsumer.accept(x, y);
            }
        }
    }

    private void execute(CoordinatePair coordinatePair, Consumer<Light> action) {
        for (int i = coordinatePair.getX1(); i <= coordinatePair.getX2(); i++) {
            for (int j = coordinatePair.getY1(); j <= coordinatePair.getY2(); j++) {
                action.accept(getLight(i,j));
            }
        }
    }
}
