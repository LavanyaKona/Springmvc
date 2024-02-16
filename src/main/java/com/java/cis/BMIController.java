package com.java.cis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.Locale;

@Controller
public class BMIController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String input(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        return "inputForm";
    }
    @RequestMapping(value = "/bmi", method = RequestMethod.POST)
    public String result(@RequestParam("height") double heightInInches,
                         @RequestParam("weight") double weightInPounds,
                         Model model) {
        double bmi = (weightInPounds / (heightInInches * heightInInches)) * 703;

        DecimalFormat df = new DecimalFormat("#.##");
        bmi = Double.parseDouble(df.format(bmi));


        model.addAttribute("bmi", bmi);
        return "bmiResult";
    }
}