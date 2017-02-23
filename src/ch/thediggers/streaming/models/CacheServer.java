package ch.thediggers.streaming.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheServer {
    public final List<Integer> videos = new ArrayList<>();
    public Map<EndPoint, Integer> latencyToEndpoints = new HashMap<>();

    public CacheServer() {
    }
}
