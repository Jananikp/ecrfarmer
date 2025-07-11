package com.localroots.repository;

import com.localroots.model.FarmerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FarmerProfileRepository extends JpaRepository<FarmerProfile, Long> {
    List<FarmerProfile> findByVerified(Boolean verified);
    List<FarmerProfile> findByLocation(String location);
}
