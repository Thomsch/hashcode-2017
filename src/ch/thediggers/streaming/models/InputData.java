package ch.thediggers.streaming.models;

import java.util.ArrayList;
import java.util.List;

public class InputData {
    public final int rows;
    public final int columns;
    public final int minIngredients;
    public final int maxCells;
    public final List<ArrayList<Ingredient>> pizza;

    public InputData(int rows, int columns, int minIngredients, int maxCells, List<ArrayList<Ingredient>> pizza) {
        this.rows = rows;
        this.columns = columns;
        this.minIngredients = minIngredients;
        this.maxCells = maxCells;
        this.pizza = pizza;
    }
}
