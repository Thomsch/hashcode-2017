package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.models.Slice;

import java.util.ArrayList;
import java.util.List;

class DummyAlgorithm extends Algorithm {

    @Override
    List<Slice> solve() {
        return new ArrayList<>();
    }
}
