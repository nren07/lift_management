package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lift {
    private int  LiftNo;
    private int CapacityInWeight;
    private int CapacityInPerson;
//    List<Passenger>passengers=new ArrayList<>();
}
