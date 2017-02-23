package ch.thediggers.streaming.io;

import ch.thediggers.streaming.models.CacheServer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DataWriter {

    public static void write(HashMap<Integer, CacheServer> cacheServers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(cacheServers.size()));
            writer.newLine();

            for (Map.Entry<Integer, CacheServer> cacheServer : cacheServers.entrySet()) {
                writer.write(String.valueOf(cacheServer.getKey()));

                final List<Integer> videos = cacheServer.getValue().videos;
                for (Integer video : videos)
                    writer.write(video + ' ');

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
