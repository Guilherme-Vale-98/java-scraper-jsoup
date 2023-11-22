package com.gui.javascrapper.service;

import com.gui.javascrapper.model.PokemonProduct;
import com.gui.javascrapper.model.ResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ScraperService {
    public List<ResponseDTO> getProducts();

}
