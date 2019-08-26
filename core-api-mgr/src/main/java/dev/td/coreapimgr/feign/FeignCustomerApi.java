package dev.td.coreapimgr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-persistence")
@RequestMapping("/persistenceService")
public interface FeignCustomerApi{
    @GetMapping("/query?feignApi")
    String query(@RequestParam("id") String args);
}
