package com.example.demo.Service;

import com.example.demo.Models.Lift;
import com.example.demo.Repository.LiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiftService {

    @Autowired
    private LiftRepository liftRepository;

    public String addLift(Lift lift){
        liftRepository.save(lift);
        return "lift is successfully saved";
    }
}
