package com.localroots.service;

import com.localroots.dto.HarvestDTO;
import java.util.List;

public interface HarvestService {
    List<HarvestDTO> getAllHarvests();
    HarvestDTO getHarvestById(Long id);
    HarvestDTO createHarvest(HarvestDTO harvestDTO);
    HarvestDTO updateHarvest(Long id, HarvestDTO harvestDTO);
    void deleteHarvest(Long id);
}
