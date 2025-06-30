package com.localroots.controller;

import com.localroots.model.FarmerProfile;
//import com.localroots.model.Product;
import com.localroots.repository.FarmerProfileRepository;
import com.localroots.dto.FarmerProfileDTO;
import com.localroots.dto.ProductDTO;
//import com.localroots.dto.FarmerProfileDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FarmerController {

    private final FarmerProfileRepository farmerProfileRepository;

    public FarmerController(FarmerProfileRepository farmerProfileRepository) {
        this.farmerProfileRepository = farmerProfileRepository;
    }

    @GetMapping("/farmers")
    public List<FarmerProfileDTO> getFarmers() {
        List<FarmerProfile> farmers = farmerProfileRepository.findAll();
        return farmers.stream().map(farmer -> {
            FarmerProfileDTO dto = new FarmerProfileDTO();
            
            //dto.setId(farmer.getFarmerId());
            dto.setName(farmer.getUser().getName()); // Assuming User has getName()
            dto.setImageUrl(farmer.getPhotoUrl());
            //dto.setPhotoUrl(farmer.getPhotoUrl());
            dto.setProducts(
                farmer.getProducts().stream().map(product -> {
                    ProductDTO pdto = new ProductDTO();
                    pdto.setId(product.getProductId());
                    pdto.setName(product.getName());
                    pdto.setQuantity(product.getQuantity());
                    //pdto.setUnit("kg"); // Or fetch from product if available
                    pdto.setPrice(product.getPrice());
                    return pdto;
                }).collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }
}