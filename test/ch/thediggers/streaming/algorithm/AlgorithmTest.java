package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.io.DataWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

abstract class AlgorithmTest {
    static Algorithm algorithm;

    @Test
    void solveAll() throws IOException {
        solveExampleInput();
        solveSmallInput();
        solveMediumInput();
        solveBigInput();
    }

    @Test
    void solveExampleInput() throws IOException {
        solve("example");
    }

    @Test
    void solveSmallInput() throws IOException {
        solve("small");
    }

    @Test
    void solveMediumInput() throws IOException {
        solve("medium");
    }

    @Test
    void solveBigInput() throws IOException {
        solve("big");
    }

    private void solve(String filename) throws IOException {
//        algorithm.read("data" + File.separator + filename + ".in");
//        Instant start = Instant.now();
//        List<Slice> solution = algorithm.solve();
//        Instant end = Instant.now();
//
//        System.out.println("Execution time for " + filename + ".in: "
//                + Duration.between(start, end).toMillis() + " ms.");
//
//        DataWriter.write(solution, "data" + File.separator + filename + ".out");
    }
}
