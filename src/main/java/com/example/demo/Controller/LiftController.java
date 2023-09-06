package com.example.demo.Controller;

import com.example.demo.Models.Lift;
import com.example.demo.Service.LiftService;
import com.example.demo.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lift")
public class LiftController {
    @Autowired
    private LiftService liftService;

    @PostMapping("/add")
    public String addLift(@RequestBody Lift lift){
        return liftService.addLift(lift);
    }
}
