package com.example.demo.controllers;

import com.example.demo.model.LatestModel;
import com.example.demo.service.LatestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileReader;

@Controller
public class MainController {

    @Value("${latest.app_id}")
    private String appId;
    @Value("${latest.base}")
    private String base;

    private final LatestService latestService;

    @Autowired
    public MainController(LatestService latestService) {
        this.latestService = latestService;
    }


    @GetMapping("/app")
    @ResponseBody
    public String app() {


        LatestModel latestModel = latestService.getLatest(appId, base);
        System.out.println(latestModel.getTimestamp());
        return latestModel.toString();


    }

}
