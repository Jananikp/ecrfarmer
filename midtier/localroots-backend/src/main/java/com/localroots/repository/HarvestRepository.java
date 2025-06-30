package com.localroots.repository;

import com.localroots.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
    List<Harvest> findByFarmer_FarmerId(Long farmerId);
}
