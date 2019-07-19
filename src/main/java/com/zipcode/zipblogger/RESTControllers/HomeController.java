package com.zipcode.zipblogger.RESTControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    //Forward slash simply identifies which mapping you're going to take
    //This annotation is root URL
    //String will get returned to the UI
    @RequestMapping("/")
    public String home(){
        return "Zip Blogger here! On call and on duty with zippy and nifty blog posts to spur on your coding journey!";
    }

}
