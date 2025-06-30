package com.localroots.service;

import com.localroots.dto.FarmerProfileDTO;
import java.util.List;

public interface FarmerService {
    List<FarmerProfileDTO> getAllFarmers();
    FarmerProfileDTO getFarmerById(Long id);
    FarmerProfileDTO createFarmer(FarmerProfileDTO farmerProfileDTO);
    FarmerProfileDTO updateFarmer(Long id, FarmerProfileDTO farmerProfileDTO);
    void deleteFarmer(Long id);
}
