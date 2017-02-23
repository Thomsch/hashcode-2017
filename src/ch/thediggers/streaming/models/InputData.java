package ch.thediggers.streaming.models;

import java.util.ArrayList;
import java.util.List;

public class InputData {



    public final int videos;
    public final int endPoints;
    public final int requestDescriptions;
    public final int cacheServers;
    public final int cacheCapacity;

    public final List<ArrayList<Ingredient>> pizza;

    public InputData(int videos, int endPoints, int requestDescriptions, int cacheServers, int cacheCapacity, List<ArrayList<Ingredient>> pizza) {
        this.videos = videos;
        this.endPoints = endPoints;
        this.requestDescriptions = requestDescriptions;
        this.cacheServers = cacheServers;
        this.cacheCapacity = cacheCapacity;
        this.pizza = pizza;
    }
}
