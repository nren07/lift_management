package com.example.demo.Repository;

import com.example.demo.Models.Lift;
import com.example.demo.Models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PassengerRepo {
    Map<Integer, Passenger> passengerMap=new HashMap<>();

    @Autowired
    private LiftRepository liftRepository;
    Map<Integer, List<Passenger>>listPassengerMap=new HashMap<>();

    public void save(Passenger passenger){
        int id=passenger.getPassengerId();
        passengerMap.put(id,passenger);
    }

    public void associatePassengerLift(Passenger passenger){
        int liftId=passenger.getLiftId();
        if(listPassengerMap.containsKey(liftId)){
            List<Passenger>passengerList=listPassengerMap.get(liftId);
            passengerList.add(passenger);
            listPassengerMap.put(liftId,passengerList);
        }
        else{
            listPassengerMap.put(liftId,new ArrayList<>());
        }
    }

    public void delete(int id){
        for(int keyId: passengerMap.keySet()){
            if(keyId<id) {
                Passenger passenger=passengerMap.get(keyId);
                int liftNo=passenger.getLiftId();
                passengerMap.remove(keyId);
                Lift lift=liftRepository.getLift(liftNo);
                lift.setCapacityInWeight(lift.getCapacityInWeight()+passenger.getPassengerWeight());
                lift.setCapacityInPerson(lift.getCapacityInPerson()+1);
                liftRepository.save(lift);
                List<Passenger>passengers=listPassengerMap.get(liftNo);
                passengers.remove(passenger);
                listPassengerMap.put(liftNo,passengers);
            }

        }
    }

    public int findMax(int w, int liftNo){
        Lift lift=liftRepository.getLift(liftNo);
        int maxWeight=lift.getCapacityInWeight();
        int max=maxWeight/w;
        return max;
    }

    public int getNoOfPeople(int liftNo, int weight){
        List<Passenger>list=listPassengerMap.get(liftNo);

        int cnt=0;

        for(Passenger passenger: list){
            if(passenger.getPassengerWeight()>weight){
                cnt++;
            }
        }
        return cnt;
    }
}
