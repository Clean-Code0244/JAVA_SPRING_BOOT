package com.omertursun.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "plain-login";
    }

    @GetMapping("showMyAccessDeniedPage")
    public String showMyAccessDeniedPage() {
        return "plain-access-denied";
    }
}

