package com.gui.javascrapper.model;

import lombok.Data;

@Data
public class PokemonProduct {
    private String url;
    private String image;
    private String name;
    private String price;

    @Override
    public String toString() {
        return "{ \"url\":\"" + url + "\", "
                + " \"image\": \"" + image + "\", "
                + "\"name\":\"" + name + "\", "
                + "\"price\": \"" + price + "\" }";
    }
}