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
import java.util.Map;

abstract class AlgorithmTest {

    @Test
    public void solveKittens() throws IOException {
        solve("kittens");
    }

    @Test
    public void solveZoo() throws IOException {
        solve("me_at_the_zoo");
    }

    @Test
    public void solveTrending() throws IOException {
        solve("trending_today");
    }

    @Test
    public void solveVideosWorthSpreading() throws IOException {
        solve("videos_worth_spreading");
    }

    abstract Algorithm getNewInstance();

    private void solve(String filename) throws IOException {
        Algorithm algorithm = getNewInstance();
        algorithm.read("data" + File.separator + filename + ".in");
        Instant start = Instant.now();
        Map<Integer, CacheServer> solution = algorithm.solve();
        Instant end = Instant.now();

        System.out.println("Execution time for " + filename + ".in: " + Duration.between(start, end).toMillis() + " ms.");

        DataWriter.write(solution, "data" + File.separator + filename + ".out");
    }
}
