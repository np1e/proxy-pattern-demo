package com.nhafkemeyer.proxypatterndemo;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class ProxyVideoManager implements VideoManager {

    @Resource(name = "realVideoManager")
    private VideoManager videoManager;

    private Video[] listCache;
    private Video videoCache;
    private Map<String,Video> downloadCache = new HashMap<>();

    @Override
    public Video[] listVideos() {
        if (listCache == null || listCache.length == 0) {
            listCache = videoManager.listVideos();
        }
        return listCache;
    }

    @Override
    public Video getVideoInfo(String name) {
        if (videoCache == null) {
            videoCache = videoManager.getVideoInfo(name);
        }

        return videoCache;
    }

    @Override
    public Video downloadVideo(String name) {
        if (!downloadExists(name)) {
            downloadCache.put(name, videoManager.downloadVideo(name));
        }

        return downloadCache.get(name);
    }

    private boolean downloadExists(String name) {
        return downloadCache.containsKey(name);
    }

}
