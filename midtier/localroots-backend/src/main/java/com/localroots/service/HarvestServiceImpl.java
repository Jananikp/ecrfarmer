package com.localroots.service;

import com.localroots.dto.HarvestDTO;
import com.localroots.model.Harvest;
import com.localroots.repository.HarvestRepository;
import com.localroots.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarvestServiceImpl implements HarvestService {

    private final HarvestRepository harvestRepository;
    private final ModelMapper modelMapper;

    public HarvestServiceImpl(HarvestRepository harvestRepository, ModelMapper modelMapper) {
        this.harvestRepository = harvestRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HarvestDTO> getAllHarvests() {
        return harvestRepository.findAll().stream()
                .map(harvest -> modelMapper.map(harvest, HarvestDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HarvestDTO getHarvestById(Long id) {
        Harvest harvest = harvestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found with id: " + id));
        return modelMapper.map(harvest, HarvestDTO.class);
    }

    @Override
    public HarvestDTO createHarvest(HarvestDTO harvestDTO) {
        Harvest harvest = modelMapper.map(harvestDTO, Harvest.class);
        Harvest saved = harvestRepository.save(harvest);
        return modelMapper.map(saved, HarvestDTO.class);
    }

    @Override
    public HarvestDTO updateHarvest(Long id, HarvestDTO harvestDTO) {
        Harvest harvest = harvestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found with id: " + id));
        harvest.setHarvestDate(java.time.LocalDate.parse(harvestDTO.getHarvestDate()));
        // Add more fields as necessary
        Harvest updated = harvestRepository.save(harvest);
        return modelMapper.map(updated, HarvestDTO.class);
    }

    @Override
    public void deleteHarvest(Long id) {
        Harvest harvest = harvestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found with id: " + id));
        harvestRepository.delete(harvest);
    }
}
