package ch.thediggers.streaming.io;

import ch.thediggers.streaming.models.Slice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Thomsch
 */
public abstract class DataWriter {

    public static void write(List<Slice> slices, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(slices.size()));
            writer.newLine();

            for (Slice slice : slices) {
                writer.write(slice.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
