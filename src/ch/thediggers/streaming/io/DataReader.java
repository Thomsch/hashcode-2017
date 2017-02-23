package ch.thediggers.streaming.io;

import ch.thediggers.streaming.util.Config;
import ch.thediggers.streaming.models.Ingredient;
import ch.thediggers.streaming.models.InputData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomsch
 */
public abstract class DataReader {

    public static InputData readFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            final String[] params = br.readLine().split(Config.SEPARATOR);
            final int rows = Integer.valueOf(params[0]);
            final int columns = Integer.valueOf(params[1]);
            final int minIngredients = Integer.valueOf(params[2]);
            final int maxCells = Integer.valueOf(params[3]);
            final List<ArrayList<Ingredient>> pizza = new ArrayList<>();

            for (int i = 0; i < rows; ++i) {
                final String line = br.readLine();
                final ArrayList<Ingredient> slice = new ArrayList<>();
                pizza.add(slice);
                for (int j = 0; j < columns; ++j)
                    slice.add((line.charAt(j) == 'M') ? Ingredient.MUSHROOM : Ingredient.TOMATO);
            }
            return new InputData(rows, columns, minIngredients, maxCells, pizza);
        }
    }
}
