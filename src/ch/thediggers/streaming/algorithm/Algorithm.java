package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.io.DataReader;
import ch.thediggers.streaming.models.Ingredient;
import ch.thediggers.streaming.models.InputData;
import ch.thediggers.streaming.models.Slice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class Algorithm {
    int rows;
    int columns;
    int minIngredients;
    int maxCells;
    List<ArrayList<Ingredient>> pizza;

    void read(String filename) throws IOException {
        final InputData input = DataReader.readFile(filename);
        rows = input.rows;
        columns = input.columns;
        minIngredients = input.requestDescriptions;
        maxCells = input.cacheServers;
        pizza = input.pizza;
    }

    abstract List<Slice> solve();
}
