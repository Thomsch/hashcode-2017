package ch.thediggers.streaming.models;

/**
 * Created by Thomsch on 23.02.2017.
 */
public class Request {
    public final int requestedVideo;
    public final int endPointId;
    public final int numRequests;

    public Request(int requestedVideo, int endPointId, int numRequests) {
        this.requestedVideo = requestedVideo;
        this.endPointId = endPointId;
        this.numRequests = numRequests;
    }
}
