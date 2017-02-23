package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.io.DataWriter;
import ch.thediggers.streaming.models.CacheServer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

abstract class AlgorithmTest {
    static Algorithm algorithm;

    @Test
    void solveAll() throws IOException {
        solveKittens();
        solveZoo();
        solveTrending();
        solveVideosWorthSpreading();
    }

    private void solveKittens() throws IOException {
        solve("kittens");
    }

    private void solveZoo() throws IOException {
        solve("me_at_the_zoo");
    }

    private void solveTrending() throws IOException {
        solve("trending_today");
    }

    private void solveVideosWorthSpreading() throws IOException {
        solve("videos_worth_spreading");
    }

    private void solve(String filename) throws IOException {
        algorithm.read("data" + File.separator + filename + ".in");
        Instant start = Instant.now();
        HashMap<Integer, CacheServer> solution = algorithm.solve();
        Instant end = Instant.now();

        System.out.println("Execution time for " + filename + ".in: " + Duration.between(start, end).toMillis() + " ms.");

        DataWriter.write(solution, "data" + File.separator + filename + ".out");
    }
}
