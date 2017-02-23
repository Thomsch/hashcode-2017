package ch.thediggers.streaming.models;

import java.util.Map;

/**
 * Created by Thomsch on 23.02.2017.
 */
public class EndPoint {

    public final int dataCenterLatency;
    public final Map<Integer, Integer> cacheServers; // key = id, value = latency to endpoint [ms]

    public EndPoint(int dataCenterLatency, Map<Integer, Integer> cacheServers) {
        this.dataCenterLatency = dataCenterLatency;
        this.cacheServers = cacheServers;
    }
}
