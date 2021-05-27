package com.nhafkemeyer.proxypatterndemo;

public class Video {

    private String name;
    private int duration;
    private int size;

    public Video(String name, int duration, int size) {
        this.name = name;
        this.duration = duration;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getSize() {
        return size;
    }
}
