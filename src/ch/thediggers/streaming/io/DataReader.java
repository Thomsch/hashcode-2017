package ch.thediggers.streaming.io;

import ch.thediggers.streaming.models.EndPoint;
import ch.thediggers.streaming.models.InputData;
import ch.thediggers.streaming.models.Request;
import ch.thediggers.streaming.util.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thomsch
 */
public abstract class DataReader {

    public static InputData readFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            final String[] params = br.readLine().split(Config.SEPARATOR);
            final int numVideos = Integer.valueOf(params[0]);
            final int numEndPoints = Integer.valueOf(params[1]);
            final int numRequestDescriptions = Integer.valueOf(params[2]);
            final int numCacheServers = Integer.valueOf(params[3]);
            final int cacheServerCapacity = Integer.valueOf(params[4]);
            final int[] videos = new int[numVideos]; // index = id, value = size [MB]
            final EndPoint[] endPoints = new EndPoint[numEndPoints];
            final List<Request> requestDescriptions = new ArrayList<>(numRequestDescriptions);

            final String[] videoData = br.readLine().split(Config.SEPARATOR);

            for (int i = 0; i < videos.length; i++) {
                videos[i] = Integer.valueOf(videoData[i]);
            }

            for (int i = 0; i < numEndPoints; i++) {
                final String[] endPointData = br.readLine().split(Config.SEPARATOR);
                final int numConnectedCacheServers = Integer.valueOf(endPointData[1]);
                final Map<Integer, Integer> cacheServers = new HashMap<>(); // key = id, value = latency difference [ms]

                String[] connectionData;
                for (int j = 0; j < numConnectedCacheServers; j++) {
                    connectionData = br.readLine().split(Config.SEPARATOR);
                    cacheServers.put(Integer.valueOf(connectionData[0]), Integer.valueOf(endPointData[0]) - Integer.valueOf(connectionData[1]));
                }
                endPoints[i] = new EndPoint(Integer.valueOf(endPointData[0]), cacheServers);
            }

            for (int i = 0; i < numRequestDescriptions; i++) {
                final String[] requestDescriptionData = br.readLine().split(Config.SEPARATOR);

                int endPointId = Integer.valueOf(requestDescriptionData[1]);

                Request request = new Request(Integer.valueOf(requestDescriptionData[0]), endPointId, Integer.valueOf(requestDescriptionData[2]));

                endPoints[endPointId].addRequest(request);
                requestDescriptions.add(request);
            }

            return new InputData(numVideos, numEndPoints, numRequestDescriptions, numCacheServers, cacheServerCapacity, videos, endPoints, requestDescriptions);
        }
    }
}
