package com.example.demo.Repository;

import com.example.demo.Models.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LiftRepository {
    Map<Integer, Lift>liftMap=new HashMap<>();


    public void save(Lift lift){
        int liftNo=lift.getLiftNo();
        liftMap.put(liftNo,lift);
    }

    public Lift getLift(int liftNo){
        return liftMap.get(liftNo);
    }

}
