package ch.thediggers.streaming.models;

import java.util.ArrayList;
import java.util.List;

public class CacheServer {
    private final int ID;
    private final List<Integer> videos = new ArrayList<>();

    public CacheServer(int id) {
        ID = id;
    }

    public List<Integer> getVideos() {
        return videos;
    }

    public int getID() {
        return ID;
    }
}
