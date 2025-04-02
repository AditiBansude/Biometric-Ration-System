package com.example.miniproject.repository;

import com.example.miniproject.model.Households;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdRepository extends JpaRepository<Households, Integer> {
	@Query("SELECT h FROM Households h")
	Optional<Households> findById(int householdId);


}
