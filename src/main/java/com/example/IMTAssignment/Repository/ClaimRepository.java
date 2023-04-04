package com.example.IMTAssignment.Repository;

import com.example.IMTAssignment.Models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
