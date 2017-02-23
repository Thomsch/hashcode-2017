package ch.thediggers.streaming.io;

import ch.thediggers.streaming.models.CacheServer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Thomsch
 */
public abstract class DataWriter {

    public static void write(List<CacheServer> cacheServers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(cacheServers.size()));
            writer.newLine();

            for (CacheServer cacheServer : cacheServers) {
                writer.write(String.valueOf(cacheServer.getID()));
                final List<Integer> videos = cacheServer.getVideos();
                for (Integer video : videos) {
                    writer.write(video + ' ');
                }
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
