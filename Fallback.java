package com.anil.demohystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class Fallback {
    @HystrixCommand(fallbackMethod = "testFallBack")

    public String readProductDetails() {
        System.out.println("Inside readProductDetails");
        //return new RestTemplate().getForObject("https://reqres.in/api/products/3", String.class);

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("getting result is ");
        //String result = restTemplate.getForObject("https://reqres.in/api/products/3", String.class);
        String result = restTemplate.getForObject("http://api1.plos.org/search?q=title:DNA", String.class);

        System.out.println("result is "+result);
        return result ;

    }
    public String testFallBack() {
        return ("product not found.");
    }



}
