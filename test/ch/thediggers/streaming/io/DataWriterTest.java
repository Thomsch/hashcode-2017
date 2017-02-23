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
    public void write() throws Exception {

        DataWriter.write(new HashMap<Integer, CacheServer>(), "datawritertest.out");

    }

}
