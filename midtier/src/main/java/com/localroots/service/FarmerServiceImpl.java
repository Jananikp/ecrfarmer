package com.localroots.service;

import com.localroots.dto.FarmerProfileDTO;
import com.localroots.model.FarmerProfile;
import com.localroots.repository.FarmerProfileRepository;
import com.localroots.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerProfileRepository farmerProfileRepository;
    private final ModelMapper modelMapper;

    public FarmerServiceImpl(FarmerProfileRepository farmerProfileRepository, ModelMapper modelMapper) {
        this.farmerProfileRepository = farmerProfileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FarmerProfileDTO> getAllFarmers() {
        return farmerProfileRepository.findAll().stream()
                .map(farmer -> modelMapper.map(farmer, FarmerProfileDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FarmerProfileDTO getFarmerById(Long id) {
        FarmerProfile farmer = farmerProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with id: " + id));
        return modelMapper.map(farmer, FarmerProfileDTO.class);
    }

    @Override
    public FarmerProfileDTO createFarmer(FarmerProfileDTO farmerProfileDTO) {
        FarmerProfile farmer = modelMapper.map(farmerProfileDTO, FarmerProfile.class);
        FarmerProfile saved = farmerProfileRepository.save(farmer);
        return modelMapper.map(saved, FarmerProfileDTO.class);
    }

    @Override
    public FarmerProfileDTO updateFarmer(Long id, FarmerProfileDTO farmerProfileDTO) {
        FarmerProfile farmer = farmerProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with id: " + id));
        farmer.setBio(farmerProfileDTO.getBio());
        farmer.setLocation(farmerProfileDTO.getLocation());
        farmer.setPhotoUrl(farmerProfileDTO.getImageUrl());
        farmer.setVerified(farmerProfileDTO.isVerified());
        // Add more fields as necessary
        FarmerProfile updated = farmerProfileRepository.save(farmer);
        return modelMapper.map(updated, FarmerProfileDTO.class);
    }

    @Override
    public void deleteFarmer(Long id) {
        FarmerProfile farmer = farmerProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with id: " + id));
        farmerProfileRepository.delete(farmer);
    }
}
