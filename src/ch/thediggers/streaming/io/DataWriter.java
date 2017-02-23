package ch.thediggers.streaming.io;

import ch.thediggers.streaming.models.CacheServer;
import ch.thediggers.streaming.util.Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class DataWriter {

    public static void write(Map<Integer, CacheServer> cacheServers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(cacheServers.size()));
            writer.newLine();

            for (Map.Entry<Integer, CacheServer> cacheServer : cacheServers.entrySet()) {
                writer.write(String.valueOf(cacheServer.getKey()) + Config.SEPARATOR);

                final List<Integer> videos = cacheServer.getValue().videos;
                for (Integer video : videos)
                    writer.write(String.valueOf(video) + Config.SEPARATOR);

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
