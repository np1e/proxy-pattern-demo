package com.nhafkemeyer.proxypatterndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class MainController {

    private VideoManager videoManager;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/videos")
    public String videoList(Model model) {
        long start = System.currentTimeMillis();

        Video[] videos = videoManager.listVideos();
        long end = System.currentTimeMillis();
        model.addAttribute("requestTime", end - start);
        model.addAttribute("videos", videos);
        return "videos";
    }

    @RequestMapping("videos/{name}")
    public String getVideo(@PathVariable String name, Model model) {

        long start = System.currentTimeMillis();
        Video video = videoManager.getVideoInfo(name);
        long end = System.currentTimeMillis();
        model.addAttribute("requestTime", end - start);

        model.addAttribute("video", video);
        return "video";
    }

    @RequestMapping(value = "video/{name}/download")
    public ResponseEntity downloadVideo(@PathVariable String name) {

        videoManager.downloadVideo(name);

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException(Exception ex) {
        ex.printStackTrace();
    }

    @Resource
    public void setVideoManager(VideoManager videoManager) {
        this.videoManager = videoManager;
    }
}
