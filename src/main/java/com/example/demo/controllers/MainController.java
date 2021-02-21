package com.example.demo.controllers;

import com.example.demo.model.CurrencyModel;
import com.example.demo.model.GifModel;
import com.example.demo.model.MetadataResponse;
import com.example.demo.service.GifService;
import com.example.demo.service.LatestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;

@RestController
public class MainController {

    @Value("${latest.app_id}")
    private String appId;
    @Value("${latest.base}")
    private String base;
    private String data = LocalDate.now().minusDays(1).toString();
    //  private String aDouble;
    private Double toDayDouble;
    private Double yesterdayDouble;
    private String messageId = "api_key=bdzlWaJruUVZsAczzsxNFwnARYh3eh7V&rich";
    private byte[] rich;
    private MetadataResponse meta;

    private final LatestService latestService;
    private final GifService gifService;


    public MainController(LatestService latestService, GifService gifService) {
        this.latestService = latestService;
        this.gifService = gifService;
    }


    @GetMapping(value = "/app" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MetadataResponse app(@RequestParam("code") String code) {
        CurrencyModel toDay = latestService.getCurrencyToday(appId, base);
        CurrencyModel yesterday = latestService.getCurrencyHistory(appId, data, base);
        toDayDouble = Double.parseDouble(yesterday.getRates().get(code));
        yesterdayDouble = Double.parseDouble(toDay.getRates().get(code));
     //   if (toDayDouble > yesterdayDouble) {
            meta = gifService.downloadFile("bdzlWaJruUVZsAczzsxNFwnARYh3eh7V","rich");


        return meta;


    }

}
