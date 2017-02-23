package ch.thediggers.streaming.models;

import java.util.List;

public class InputData {

    public final int videos;
    public final int numEndPoint;
    public final int requestDescriptions;
    public final int cacheServers;
    public final int cacheCapacity;
    public final int[] videosSize;
    public final EndPoint[] endPoints;
    public final List<Request> requests;

    public InputData(int videos, int numEndPoint, int requestDescriptions, int cacheServers, int cacheCapacity, int[] videosSize, EndPoint[] endPoints, List<Request> requests) {
        this.videos = videos;
        this.numEndPoint = numEndPoint;
        this.requestDescriptions = requestDescriptions;
        this.cacheServers = cacheServers;
        this.cacheCapacity = cacheCapacity;
        this.videosSize = videosSize;
        this.endPoints = endPoints;
        this.requests = requests;
    }
}
