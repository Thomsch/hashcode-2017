package ch.thediggers.streaming.algorithm;

import org.junit.jupiter.api.BeforeAll;

class DummyAlgorithmTest extends AlgorithmTest {

    @BeforeAll
    static void setUp() {
        algorithm = new DummyAlgorithm();
    }
}
