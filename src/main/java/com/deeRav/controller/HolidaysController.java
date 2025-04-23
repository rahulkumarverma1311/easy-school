package com.deeRav.controller;

import com.deeRav.entity.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {
    /*
    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean festival,@RequestParam(required = false) boolean federal,Model model) {
        model.addAttribute("festival",festival);
        model.addAttribute("federal",federal);
        List<Holiday> holidays = Arrays.asList(new Holiday("1 jan", "New Year   ", Holiday.Type.FESTIVAL), new Holiday("14 jan", "Sakraat", Holiday.Type.FESTIVAL), new Holiday("24 May", "Brother's day", Holiday.Type.FESTIVAL), new Holiday("14 june", "AESE Hi", Holiday.Type.FEDERAL), new Holiday("11 july", "Heat Wave", Holiday.Type.FEDERAL));
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(), (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return  "holidays.html";
    }


     */

    @GetMapping("/holidays/{display}")
    public String displayHolidaysPath(@PathVariable String display, Model model) {
        if(display != null && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(display != null && display.equals("federal")) {
            model.addAttribute("federal",true);
        }else if(display != null && display.equals("festival")){
            model.addAttribute("festival",true);
        }
        List<Holiday> holidays = Arrays.asList(new Holiday("1 jan", "New Year   ", Holiday.Type.FESTIVAL), new Holiday("14 jan", "Sakraat", Holiday.Type.FESTIVAL), new Holiday("24 May", "Brother's day", Holiday.Type.FESTIVAL), new Holiday("14 june", "AESE Hi", Holiday.Type.FEDERAL), new Holiday("11 july", "Heat Wave", Holiday.Type.FEDERAL));
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(), (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return  "holidays.html";
    }
}
