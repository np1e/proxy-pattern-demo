package com.nhafkemeyer.proxypatterndemo;

import org.springframework.stereotype.Component;

import java.util.Arrays;

public class RealVideoManager implements VideoManager {

    private Video[] videos = new Video[]{
            new Video("video1", 160, 5100),
            new Video("video2", 165, 5200),
            new Video("video3", 145, 5120),
            new Video("video4", 180, 5160),
            new Video("video5", 163, 5270),
            new Video("video6", 156, 4900),
            new Video("video7", 151, 7800),
            new Video("video8", 132, 4570),
    };

    @Override
    public Video[] listVideos() {
        // Simulate API request
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return videos;
    }

    @Override
    public Video getVideoInfo(String name) {
        // simulate small API request
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.stream(videos)
                .filter(video -> video.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Video downloadVideo(String name) {
        // Simulate API request
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.stream(videos)
                .filter(video -> video.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
