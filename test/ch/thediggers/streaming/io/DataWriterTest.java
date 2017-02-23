package ch.thediggers.streaming.io;

import ch.thediggers.streaming.models.CacheServer;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Thomsch on 23.02.2017.
 */
public class DataWriterTest {
    @Test
    public void write_nullResult() throws Exception {
        DataWriter.write(new HashMap<>(), "datawritertest-nullresult.out");
    }

    @Test
    public void write_normal() throws Exception {
        HashMap<Integer, CacheServer> solution = new HashMap<>();
        solution.put(1, new CacheServer(0,3,4,5));
        solution.put(4, new CacheServer(1,4,7,2,6,5));

        DataWriter.write(solution, "datawritertest-normal.out");
    }

}
