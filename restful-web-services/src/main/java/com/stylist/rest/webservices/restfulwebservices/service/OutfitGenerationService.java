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

    @Autowired
    private ApparelRepo apparelRepo;

    public OutfitGenerationService() {}

    public List<Apparel> getRandomOufit() {
        Apparel chosenApparel = this.getRandomItem();
        System.out.println(chosenApparel);
        if(chosenApparel.isOnePiece())
            return new ArrayList<>(List.of(chosenApparel));

        List<BasicColour> colourMatches = this.colourMap.mapMatchingColours(chosenApparel.getColour());
        System.out.println(colourMatches);

        List<Apparel> allPossibleMatches = this.apparelRepo.findAll().stream()
                                            .filter(item -> item.isBottom() != chosenApparel.isBottom() && colourMatches.stream().map(BasicColour::getName).anyMatch(item.getColour().getName()::equals))
                                            .collect(Collectors.toList());

        System.out.println(allPossibleMatches);
        if(allPossibleMatches.size() > 0) {
            Random rand = new Random();
            System.out.println(rand);
            Apparel matchingApparel = allPossibleMatches.get(rand.nextInt(allPossibleMatches.size()));
            return new ArrayList<>(asList(chosenApparel, matchingApparel));
        }
        return null;
    }

    private Apparel getRandomItem() {
        List<Integer> allIds = apparelRepo.findAll().stream()
                                .map(Apparel::getId)
                                .collect(Collectors.toList());
        Random rand = new Random();
        int randomId = allIds.get(rand.nextInt(allIds.size()));
        return apparelRepo.findById(randomId).orElseThrow();
    }

}
