package com.example.demo.Service;

import com.example.demo.Models.Lift;
import com.example.demo.Models.Passenger;
import com.example.demo.Repository.LiftRepository;
import com.example.demo.Repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private LiftRepository liftRepository;

    public String addPassenger(Passenger passenger) throws Exception{
        passengerRepo.save(passenger);
        passengerRepo.associatePassengerLift(passenger);
        int liftNo=passenger.getLiftId();
        Lift lift=liftRepository.getLift(liftNo);
        lift.setCapacityInPerson(lift.getCapacityInPerson()-1);
        lift.setCapacityInWeight(lift.getCapacityInWeight()-passenger.getPassengerWeight());

        if(lift.getCapacityInWeight()==0 || lift.getCapacityInPerson()==0){
            throw new Exception("not able to add passenger");
        }
        liftRepository.save(lift);
        return "saved";
    }

    public String deleteLesserId(int id){
        passengerRepo.delete(id);
        return "delete";
    }

    public int findMax(int weight, int liftNo){
        int max=passengerRepo.findMax(weight, liftNo);
        return max;
    }

    public int getNoOfPeople(int liftNo,int weight){
        return passengerRepo.getNoOfPeople(liftNo,weight);
    }
}
