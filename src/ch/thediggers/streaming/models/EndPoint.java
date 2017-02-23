package ch.thediggers.streaming.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Thomsch on 23.02.2017.
 */
public class EndPoint {

    public final int dataCenterLatency;
    public final Map<Integer, Integer> cacheServers; // key = id, value = latency to endpoint [ms]
    public final List<Request> requests;

    public EndPoint(int dataCenterLatency, Map<Integer, Integer> cacheServers) {
        this.dataCenterLatency = dataCenterLatency;
        this.cacheServers = cacheServers;
        requests = new ArrayList<>();
    }

    public void addRequest(Request request) {
        requests.add(request);
    }
}
