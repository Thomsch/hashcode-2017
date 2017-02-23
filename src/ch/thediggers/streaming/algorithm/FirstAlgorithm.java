package ch.thediggers.streaming.algorithm;

import ch.thediggers.streaming.models.CacheServer;
import ch.thediggers.streaming.models.Request;

import java.util.HashMap;
import java.util.Map;

public class FirstAlgorithm extends Algorithm {

    @Override
    Map<Integer, CacheServer> solve() {
        final Map<Integer, CacheServer> cacheServers = new HashMap<>();
//        for (EndPoint endPoint : input.endPoints) {
//            for(Map.Entry<Integer, Integer> cacheServer: endPoint.cacheServers.entrySet()) {
//                Integer key = cacheServer.getKey();
//                if (cacheServers.containsKey(key)) {
//                    cacheServers.get(key).latencyToEndpoints.put(endPoint, endPoint.dataCenterLatency);
//                }
//            }
//        }
        final int[] serverContents = new int[input.numCacheServers];

        for (int video = 0; video < input.videos.length; video++) {
            int maxScoreServerIndex = 0;
            int[] serverScores = new int[input.numCacheServers];
            for (int server = 0; server < input.numCacheServers; server++) {
                int thisServerScore = 0;
                for (Request request : input.requestDescriptions) {
                    if (request.requestedVideo == video) {
                        final int latencyDifference = input.endPoints[request.endPointId].cacheServers.get(server);
                        thisServerScore += request.numRequests * (latencyDifference);
                    }
                }
                if (thisServerScore > serverScores[maxScoreServerIndex]) {
                    maxScoreServerIndex = server;
                }
                serverScores[server] = thisServerScore;
            }
            CacheServer cacheServer = new CacheServer();
            if (cacheServers.containsKey(maxScoreServerIndex)) {
                cacheServer = cacheServers.get(maxScoreServerIndex);
            } else {
                cacheServers.put(maxScoreServerIndex, cacheServer);
            }
            cacheServer.videos.add(video);
            serverContents[maxScoreServerIndex] += input.videos[video];
        }

        return cacheServers;
    }

    /**
     * Thank you https://dzone.com/articles/knapsack-problem
     * For example, item 0 as a value of val[0] and a weight of wt[0].
     *
     * @param val is the list of values
     * @param wt  is the list of weight
     * @param W   is the max weight of the sack
     */

    public static int knapsack(int val[], int wt[], int W) {
        int N = wt.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter
        int[][] V = new int[N + 1][W + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        //What if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item = 1; item <= N; item++) {
            //Let's fill the values row by row
            for (int weight = 1; weight <= W; weight++) {
                //Is the current items weight less than or equal to running weight
                if (wt[item - 1] <= weight) {
                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
                    //is greater than the value without the current item itself
                    V[item][weight] = Math.max(val[item - 1] + V[item - 1][weight - wt[item - 1]], V[item - 1][weight]);
                } else {
                    //If the current item's weight is more than the running weight, just carry forward the value without the current item
                    V[item][weight] = V[item - 1][weight];
                }
            }
        }
        //Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return V[N][W];
    }
}
