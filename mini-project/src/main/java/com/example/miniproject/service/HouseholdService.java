package com.example.miniproject.service;

import com.example.miniproject.model.Households;
import com.example.miniproject.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HouseholdService {

    @Autowired
    private HouseholdRepository householdRepository;

    public List<Households> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public Optional<Households> findById(int householdId) {
        return householdRepository.findById(householdId);
    }

}
