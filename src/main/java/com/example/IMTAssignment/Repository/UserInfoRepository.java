package com.example.IMTAssignment.Repository;

import com.example.IMTAssignment.Models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByUsername(String username);
}
