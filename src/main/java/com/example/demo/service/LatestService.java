package com.example.demo.service;

import com.example.demo.model.CurrencyModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "https://openexchangerates.org", name = "Latest-Service")
public interface LatestService {



    @RequestMapping(method = RequestMethod.GET, path = "/api/latest.json")
    CurrencyModel getCurrencyToday(@RequestParam(name = "app_id") String app_id, @RequestParam(name = "base") String base);

    @RequestMapping(method = RequestMethod.GET, path = "/api/historical/{data}.json")
    CurrencyModel getCurrencyHistory(@RequestParam(name = "app_id") String appId,
                                     @PathVariable String data,
                                     @RequestParam(name = "base") String base);


}
