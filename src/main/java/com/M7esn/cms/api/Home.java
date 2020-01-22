package com.M7esn.cms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.text.SimpleDateFormat;

@RestController
public class Home {

    @GetMapping
    public String input() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date());
        return "Application WORKS!... DATE: " + date;
    }
}
