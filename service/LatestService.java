package com.example.demo.service;

import com.example.demo.model.LatestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://openexchangerates.org", name = "Latest-Service")
public interface LatestService {

   /* @GetMapping("/api/latest.json?app_id=${latest.app_id}&base=${latest.base}")
    public LatestModel getLatest();

    */

    @RequestMapping(method = RequestMethod.GET, path = "/api/latest.json")
    public LatestModel getLatest(@RequestParam(name = "app_id") String app_id, @RequestParam(name = "base") String base);


}
