package com.example.demo.service;

import com.example.demo.model.MetadataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "file", url = "api.giphy.com/v1/gifs")
public interface GifService {


    @RequestMapping(method = RequestMethod.GET, path = "/random",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    MetadataResponse downloadFile(@RequestParam(name = "api_key") String appId, @RequestParam("rich")String rich);
}
