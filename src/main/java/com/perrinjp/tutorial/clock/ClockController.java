package com.perrinjp.tutorial.clock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClockController {

    @GetMapping("/clock")
    String displayClock(){
        return "clock/clock";
    }

}
