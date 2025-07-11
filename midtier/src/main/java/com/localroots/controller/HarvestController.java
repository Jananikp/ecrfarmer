package com.localroots.controller;

import com.localroots.dto.HarvestDTO;
import com.localroots.service.HarvestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvests")
public class HarvestController {

    private final HarvestService harvestService;

    public HarvestController(HarvestService harvestService) {
        this.harvestService = harvestService;
    }

    @GetMapping
    public List<HarvestDTO> getAllHarvests() {
        return harvestService.getAllHarvests();
    }

    @GetMapping("/{id}")
    public HarvestDTO getHarvestById(@PathVariable Long id) {
        return harvestService.getHarvestById(id);
    }

    @PostMapping
    public HarvestDTO createHarvest(@RequestBody HarvestDTO harvestDTO) {
        return harvestService.createHarvest(harvestDTO);
    }

    @PutMapping("/{id}")
    public HarvestDTO updateHarvest(@PathVariable Long id, @RequestBody HarvestDTO harvestDTO) {
        return harvestService.updateHarvest(id, harvestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHarvest(@PathVariable Long id) {
        harvestService.deleteHarvest(id);
        return ResponseEntity.noContent().build();
    }
}
