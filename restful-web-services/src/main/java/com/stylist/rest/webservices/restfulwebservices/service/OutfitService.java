package com.stylist.rest.webservices.restfulwebservices.service;

import com.stylist.rest.webservices.restfulwebservices.model.Apparel;
import com.stylist.rest.webservices.restfulwebservices.model.BasicColour;
import com.stylist.rest.webservices.restfulwebservices.model.User;
import com.stylist.rest.webservices.restfulwebservices.model.mapper.ColourMap;
import com.stylist.rest.webservices.restfulwebservices.repo.ApparelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class OutfitService {
    private final ColourMap colourMap = new ColourMap();
    private final Map<User, List<List<Apparel>>> outfits = new HashMap<>();

    @Autowired
    private final ApparelRepo apparelRepo;

    @Autowired
    private final SessionUtilsService sessionUtils;

    public OutfitService(ApparelRepo apparelRepo, SessionUtilsService sessionUtils) {
        this.apparelRepo = apparelRepo;
        this.sessionUtils = sessionUtils;
    }

    @Transactional
    public void updateOutfits() {
        User currentUser = this.sessionUtils.getCurrentUserId();
        this.outfits.computeIfAbsent(currentUser, k -> new ArrayList<>());
        this.outfits.get(currentUser).clear();
        apparelRepo.findAllByUser(currentUser).stream()
                .filter(el -> !el.isBottom())
                .forEach(item -> {
                    if(item.isOnePiece())
                        this.outfits.get(currentUser).add(new ArrayList<>(List.of(item)));
                    else {
                        List<Apparel> matches = this.getMatchyApparel(item);
                        matches.forEach(match -> this.outfits.get(currentUser).add(new ArrayList<>(asList(item, match))));
                    }
                });
        System.out.println("Updating outfits");
        System.out.println(this.outfits);
    }

    @Transactional
    public List<Apparel> getMatchyApparel(Apparel chosenApparel) {
        User currentUser = this.sessionUtils.getCurrentUserId();
        List<BasicColour> colourMatches = this.colourMap.mapMatchingColours(chosenApparel.getColour());
        System.out.println("Getting colour mactches");
        System.out.println(colourMatches);
        List<Apparel> allPossibleMatches = new ArrayList<>();
        if(colourMatches != null) {
            allPossibleMatches = this.apparelRepo.findAllByUser(currentUser).stream()
                    .filter(item -> item.isBottom() != chosenApparel.isBottom() && colourMatches.stream().map(BasicColour::getName).anyMatch(item.getColour().getName()::equals))
                    .collect(Collectors.toList());
            System.out.println("all possible matches");
            System.out.println(allPossibleMatches);
        }

        return allPossibleMatches;
    }

    @Transactional
    public List<Apparel> getRandomOutfit() {
        Random rand = new Random();
        User currentUser = this.sessionUtils.getCurrentUserId();

        this.outfits.computeIfAbsent(currentUser, k -> new ArrayList<>());
        if(this.outfits.get(currentUser).size() == 0) this.updateOutfits();

        List<List<Apparel>> outfitsForUser = this.outfits.get(currentUser);
        if(outfitsForUser.size() > 0) {
            int randomNr = rand.nextInt(outfitsForUser.size());
            return outfitsForUser.get(randomNr);
        }
        return new ArrayList<>();
    }

    @Transactional
    public boolean saveOutfit(Integer idFirst, Integer idSecond) {
        Apparel first = this.apparelRepo.findById(idFirst).orElseThrow(() -> new EntityNotFoundException(idFirst.toString()));
        if(idSecond > -1) {
            Apparel second = this.apparelRepo.findById(idSecond).orElseThrow(() -> new EntityNotFoundException(idSecond.toString()));
            first.saveMatch(second);
        }
        else {
            first.saveMatch(first);
        }

        return true;
    }

    @Transactional
    public List<List<Apparel>> getSavedOutfitsByUserId() {
        User currentUser = this.sessionUtils.getCurrentUserId();
        List<List<Apparel>> savedOutfits = new ArrayList<>();
        this.apparelRepo.findAllByUser(currentUser).forEach(item -> {
            for (Apparel savedMatch : item.getSavedMatches()) savedOutfits.add(asList(item, savedMatch));
            if (item.isSaved()) savedOutfits.add(asList(item));
        });
        return savedOutfits;
    }

    @Transactional
    public boolean deleteSavedOutfit(Integer idFirst, Integer idSecond) {
        Apparel first = this.apparelRepo.findById(idFirst).orElseThrow();

        if(idSecond > -1) {
            Apparel second = this.apparelRepo.findById(idSecond).orElseThrow(() -> new EntityNotFoundException(idSecond.toString()));
            first.removeMatch(second);
        }
        else {
            first.removeMatch(first);
        }

        return true;
    }

    @Transactional
    public boolean isOutfitSaved(Integer idFirst, Integer idSecond) {
        Apparel first = this.apparelRepo.findById(idFirst).orElseThrow();
        if(idSecond > -1) {
            Apparel second = this.apparelRepo.findById(idSecond).orElseThrow();
            boolean isSaved = first.getSavedMatches().contains(second);
            System.out.println(isSaved);
            return isSaved;
        }
        return first.isSaved();
    }


}
