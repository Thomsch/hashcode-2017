package ch.thediggers.streaming.models;

import java.util.List;

public class InputData {

    public final int numVideos;
    public final int numEndPoint;
    public final int numRequestDescriptions;
    public final int numCacheServers;
    public final int cacheServerCapacity;

    public final int[] videos;
    public final EndPoint[] endPoints;
    public final List<Request> requestDescriptions;

    public InputData(int numVideos, int numEndPoint, int numRequestDescriptions, int numCacheServers, int cacheServerCapacity, int[] videos, EndPoint[] endPoints, List<Request> requestDescriptions) {
        this.numVideos = numVideos;
        this.numEndPoint = numEndPoint;
        this.numRequestDescriptions = numRequestDescriptions;
        this.numCacheServers = numCacheServers;
        this.cacheServerCapacity = cacheServerCapacity;
        this.videos = videos;
        this.endPoints = endPoints;
        this.requestDescriptions = requestDescriptions;
    }
}
