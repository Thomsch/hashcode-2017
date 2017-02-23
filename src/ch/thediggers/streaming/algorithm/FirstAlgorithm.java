package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.models.CacheServer;
import ch.thediggers.streaming.models.EndPoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstAlgorithm extends Algorithm {

    @Override
    List<CacheServer> solve() {
        final Map<Integer, CacheServer> cacheServers = new HashMap<>();
        for (EndPoint endPoint : input.endPoints) {
            for(Map.Entry<Integer, Integer> cacheServer: endPoint.cacheServers.entrySet()) {
                Integer key = cacheServer.getKey();
                if (cacheServers.containsKey(key)) {
                    cacheServers.get(key).latencyToEndpoints.put(endPoint, endPoint.dataCenterLatency);
                }
            }
        }

        return null;
    }
}

