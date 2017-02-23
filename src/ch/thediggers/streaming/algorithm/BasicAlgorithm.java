package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.models.Slice;

import java.util.ArrayList;
import java.util.List;

class BasicAlgorithm extends Algorithm {

    @Override
    List<Slice> solve() {
        final List<int[]> forms = new ArrayList<>();

        int sliceSize;
        int height = 1;
        for (int i = 1; i <= maxCells; i++)
            for (int j = 1; j <= maxCells; j++)
                if (i * j <= maxCells && i * j >= 2 * minIngredients)
                    forms.add(new int[]{i, j});

        for (int[] form : forms) {
            for (int i = 0; i <= rows - form[0]; i++)
                for (int j = 0; j <= columns - form[1]; j++) {
                    for (int k = 1; k <= maxCells; k++) {
                        for (int l = 1; l <= maxCells; l++) {

                        }
                    }
                }
        }

        return new ArrayList<>();
    }
}
