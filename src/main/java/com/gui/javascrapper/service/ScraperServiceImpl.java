package com.gui.javascrapper.service;

import com.gui.javascrapper.model.PokemonProduct;
import com.gui.javascrapper.model.ResponseDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ScraperServiceImpl implements ScraperService {
    //Reading data from property file to a list
    @Value("#{'${website.url}'}")
    String url;

    Document doc;

    @Override
    public List<ResponseDTO> getProducts() {
        List<ResponseDTO> productsDTO = new ArrayList<>();
        try {
            doc = Jsoup
                    .connect(url)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements products = doc.getElementsByClass("a-section a-spacing-small puis-padding-left-small puis-padding-right-small");
        for (Element product : products) {
            String title = product.selectFirst("h2").text();
            String price = product.getElementsByClass("a-offscreen").get(0).text();

            productsDTO.add(new ResponseDTO(title, price));
        }
        return productsDTO;
    }
}