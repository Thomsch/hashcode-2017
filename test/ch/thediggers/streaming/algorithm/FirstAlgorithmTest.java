package ch.thediggers.streaming.algorithm;

import static org.junit.Assert.*;

/**
 * @author Thomsch
 * @author Aleixosk
 */
public class FirstAlgorithmTest extends AlgorithmTest {

    @Override
    Algorithm getNewInstance() {
        return new FirstAlgorithm();
    }
}
