package com.nhafkemeyer.proxypatterndemo;

import java.util.Map;

public interface VideoManager {

    /**
     * Retrieve a list of all available videos
     * @return an array of {@link com.nhafkemeyer.proxypatterndemo.Video}
     */
    Video[] listVideos();

    /**
     * Get metadata for a video
     * @param name the name of the video
     * @return
     */
    Video getVideoInfo(String name);

    /**
     * Download a video
     * @param name
     * @return
     */
    Video downloadVideo(String name);
}
