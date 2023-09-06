package com.example.demo.Controller;

import com.example.demo.Models.Passenger;
import com.example.demo.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @PostMapping("/add")
    public String addPassenger(@RequestBody Passenger passenger){
        try{
            return passengerService.addPassenger(passenger);
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/deleteLessId")
    public String deletePassengerLesserId(int id){
        return passengerService.deleteLesserId(id);
    }

    @GetMapping("/maxNoPassWithWeightX")
    public int findMaxWithX(@RequestParam Integer weight, @RequestParam Integer liftId){
        return passengerService.findMax(weight,liftId);
    }

    @GetMapping("/noOfPeople")
    public int noOfPeople(@RequestParam Integer id,@RequestParam Integer weight){
        return passengerService.getNoOfPeople(id,weight);
    }
}
