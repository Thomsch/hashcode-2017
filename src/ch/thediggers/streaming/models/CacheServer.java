package ch.thediggers.streaming.models;

import java.util.*;

public class CacheServer {
    public final List<Integer> videos = new ArrayList<>();
    public Map<EndPoint, Integer> latencyToEndpoints = new HashMap<>();

    public CacheServer(Integer ... videos) {
        this.videos.addAll(Arrays.asList(videos));
    }
}
