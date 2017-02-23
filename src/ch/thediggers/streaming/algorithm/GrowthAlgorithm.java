package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.models.Slice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The idea behind this algorithm is to secure the minimum mandatory slices and then make them grow to unused cells
 *
 * @author Thomsch
 */
class GrowthAlgorithm extends Algorithm {

    @Override
    List<Slice> solve() {
        List<int[]> minSlices = getMinSliceShapes();
        List<Slice> allMinSlices = new ArrayList<>();
        List<Slice> result = new ArrayList<>();
        boolean[][] usedCells = new boolean[pizza.size()][pizza.get(0).size()];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int[] shape : minSlices) {
                    System.out.println("Testing shape " + shape[0] + "x" + shape[1] + " at " + "(" + i + "," + j + ")");
                    if (isSliceValid(i, j, shape)) {
                        Slice slice = new Slice(i, j, shape[0], shape[1]);
                        allMinSlices.add(slice);
                        System.out.println("New min slice : " + slice.toString());
                    }
                }
            }
        }
        System.out.println("Got a total of " + allMinSlices.size() + " possibles minimum slices");

        // Try all the combinations possibilities with the minimum slices by trying one by one.
        while(!allMinSlices.isEmpty()) {
            Slice slice = allMinSlices.get(0);

            markUsed(usedCells, slice);
            removeInvalidSlices(usedCells, allMinSlices);

            for (boolean[] row : usedCells) {
                System.out.println(Arrays.toString(row));
            }

            result.add(slice);
        }

        return result;
    }

    /**
     * Remove slices that are located on already used cells.
     * @param usedCells The matrix representing if a cell is used (true) or not (false)
     * @param slices The slices we want to check against <code>usedCells</code>
     */
    private void removeInvalidSlices(boolean[][] usedCells, List<Slice> slices) {

    }

    /**
     * Marks the cells in the <code>slice</code> tagged as used in <code>usedCells</code>.
     * @param usedCells The matrix representing if a cell is used (true) or not (false)
     * @param slice The slice tag as used in <code>usedCells</code>
     */
    private void markUsed(boolean[][] usedCells, Slice slice) {

    }

    /**
     * Checks if the slice contains enough ingredients.
     *
     * @param startX     The x coordinate of the start of the slice
     * @param startY     The y coordinate of the start of the slice
     * @param sliceShape The size of the slice shape {number of rows, number of columns}
     * @return True is there is enough ingredients
     */
    private boolean isSliceValid(int startX, int startY, int[] sliceShape) {
        int tomatoes = 0;
        int mushrooms = 0;

        for (int i = startX; i < startX + sliceShape[0] && i < rows; i++) {
            for (int j = startY; j < startY + sliceShape[1] && j < columns; j++) {
                switch (pizza.get(i).get(j)) {
                    case TOMATO:
                        tomatoes++;
                        break;
                    case MUSHROOM:
                        mushrooms++;
                        break;
                }
            }
        }
        System.out.println(tomatoes + ";" + mushrooms);
        return tomatoes >= minIngredients && mushrooms >= minIngredients;
    }

    private List<int[]> getMinSliceShapes() {
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i <= maxCells; i++)
            for (int j = 1; j <= maxCells; j++)
                if (i * j <= maxCells && i * j == 2 * minIngredients) {
                    result.add(new int[]{i, j});
                }
        return result;
    }
}
