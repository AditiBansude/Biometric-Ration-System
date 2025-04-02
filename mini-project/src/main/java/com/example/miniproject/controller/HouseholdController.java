package com.example.miniproject.controller;

import com.example.miniproject.model.Households;
import com.example.miniproject.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.miniproject.repository.HouseholdRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/households")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @GetMapping
    public List<Households> getAllHouseholds1() {
        return householdService.getAllHouseholds();
    }
    

}
