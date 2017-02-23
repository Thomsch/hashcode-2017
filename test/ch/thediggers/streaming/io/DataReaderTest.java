package ch.thediggers.streaming.io;

import ch.thediggers.streaming.models.InputData;
import org.junit.Test;

import java.io.File;

/**
 * Created by Thomsch on 23.02.2017.
 */
public class DataReaderTest {
    @Test
    public void readFile() throws Exception {

        InputData inputData = DataReader.readFile("data" + File.separator + "me_at_the_zoo.in");

        System.out.println(inputData.numVideos);
        System.out.println(inputData.numEndPoint);
        System.out.println(inputData.numRequestDescriptions);

    }

}
