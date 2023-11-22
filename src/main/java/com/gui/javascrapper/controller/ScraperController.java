package com.gui.javascrapper.controller;

import com.gui.javascrapper.model.PokemonProduct;
import com.gui.javascrapper.model.ResponseDTO;
import com.gui.javascrapper.service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ScraperController {

    @Autowired
    ScraperService scraperService;


    @GetMapping
    public List<ResponseDTO> scrapeProducts() {
        return scraperService.getProducts();
    }
}
