package com.stylist.rest.webservices.restfulwebservices.service;

import com.stylist.rest.webservices.restfulwebservices.model.Apparel;
import com.stylist.rest.webservices.restfulwebservices.model.BasicColour;
import com.stylist.rest.webservices.restfulwebservices.model.mapper.ColourMap;
import com.stylist.rest.webservices.restfulwebservices.repo.ApparelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class OutfitGenerationService {
    private final ColourMap colourMap = new ColourMap();
    private final List<List<Apparel>> outfits = new ArrayList<>();

    @Autowired
    private ApparelRepo apparelRepo;

    public OutfitGenerationService() {
    }

    public void updateOutfits() {
        apparelRepo.findAll().stream()
                .filter(el -> !el.isBottom())
                .forEach(item -> {
                    if(item.isOnePiece())
                        this.outfits.add(new ArrayList<>(List.of(item)));
                    else {
                        List<Apparel> matches = this.getMatchyApparel(item);
                        matches.forEach(match -> this.outfits.add(new ArrayList<>(asList(item, match))));
                    }
                });

        System.out.println(this.outfits);
    }

    public List<Apparel> getMatchyApparel(Apparel chosenApparel) {
        List<BasicColour> colourMatches = this.colourMap.mapMatchingColours(chosenApparel.getColour());
        System.out.println(colourMatches);
        List<Apparel> allPossibleMatches = this.apparelRepo.findAll().stream()
                                            .filter(item -> item.isBottom() != chosenApparel.isBottom() && colourMatches.stream().map(BasicColour::getName).anyMatch(item.getColour().getName()::equals))
                                            .collect(Collectors.toList());
        System.out.println(allPossibleMatches);

        return allPossibleMatches;
    }

    public List<Apparel> getRandomOutfit() {
        Random rand = new Random();
        if(this.outfits.size() == 0) this.updateOutfits();
        return this.outfits.get(rand.nextInt(this.outfits.size()));
    }

}
