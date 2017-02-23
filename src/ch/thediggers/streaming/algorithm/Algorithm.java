package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.io.DataReader;
import ch.thediggers.streaming.models.CacheServer;
import ch.thediggers.streaming.models.InputData;

import java.io.IOException;
import java.util.List;

abstract class Algorithm {
    InputData input;

    void read(String filename) throws IOException {
        input = DataReader.readFile(filename);
    }

    abstract List<CacheServer> solve();
}
