package dev.td.coreapimgr.service;

import dev.td.coreapimgr.feign.FeignCustomerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private FeignCustomerApi feignCustomerApi;

    @Override
    public String query(String id) {
        return feignCustomerApi.query(id);
    }
}
