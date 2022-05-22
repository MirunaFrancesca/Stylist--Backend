package com.stylist.rest.webservices.restfulwebservices.model.mapper;

import com.stylist.rest.webservices.restfulwebservices.model.BasicColour;
import lombok.NoArgsConstructor;

import java.util.*;

import static java.util.Arrays.asList;

@NoArgsConstructor
public class ColourMap {

    /*red*/
    private static final BasicColour maroon = new BasicColour("maroon");
    private static final BasicColour burgundy = new BasicColour("burgundy");
    private static final BasicColour red = new BasicColour("red");
    private static final BasicColour crimson = new BasicColour("crimson red");

    private final List<BasicColour> darkReds = new ArrayList<>(asList(maroon, burgundy));
    private final List<BasicColour> mediumReds = new ArrayList<>(asList(red, crimson));

    /*orange*/
    private static final BasicColour tangerine = new BasicColour("tangerine");
    private static final BasicColour orange = new BasicColour("orange");

    /*yellow*/
    private static final BasicColour mustard = new BasicColour("mustard");
    private static final BasicColour yellow = new BasicColour("yellow");
    private static final BasicColour lemon = new BasicColour("lemon");

    /*green*/
    private static final BasicColour darkGreen = new BasicColour("dark green");
    private static final BasicColour khaki = new BasicColour("khaki");
    private static final BasicColour emerald = new BasicColour("emerald green");
    private static final BasicColour green = new BasicColour("green");
    private static final BasicColour neon = new BasicColour("neon green");
    private static final BasicColour lime = new BasicColour("lime green");
    private static final BasicColour mint = new BasicColour("mint green");
    private static final BasicColour lightGreen = new BasicColour("light green");
    private static final BasicColour tea = new BasicColour("tea green");

    private final List<BasicColour> darkGreens = new ArrayList<>(asList(darkGreen, khaki));
    private final List<BasicColour> mediumGreens = new ArrayList<>(asList(green, emerald, neon));
    private final List<BasicColour> lightGreens = new ArrayList<>(asList(lime, mint, lightGreen, tea));

    /*blue*/
    private static final BasicColour navy = new BasicColour("navy blue");
    private static final BasicColour cobalt = new BasicColour("cobalt blue");
    private static final BasicColour royal = new BasicColour("royal blue");
    private static final BasicColour blue = new BasicColour("blue");
    private static final BasicColour bright = new BasicColour("bright blue");
    private static final BasicColour denim = new BasicColour("denim blue");
    private static final BasicColour azure = new BasicColour("azure blue");
    private static final BasicColour cyan = new BasicColour("cyan blue");
    private static final BasicColour turqoise = new BasicColour("turqoise blue");
    private static final BasicColour baby = new BasicColour("baby blue");

    private final List<BasicColour> darkBlues = new ArrayList<>(asList(navy, cobalt, royal));
    private final List<BasicColour> mediumBlues = new ArrayList<>(asList(blue, bright, denim));
    private final List<BasicColour> lightBlues = new ArrayList<>(asList(azure, cyan, turqoise, baby));

    /*purple*/
    private static final BasicColour plum = new BasicColour("plum");
    private static final BasicColour violet = new BasicColour("violet");
    private static final BasicColour purple = new BasicColour("purple");
    private static final BasicColour lilac = new BasicColour("lilac");
    private static final BasicColour lavender = new BasicColour("lavender");

    private final List<BasicColour> darkPurples = new ArrayList<>(asList(plum, violet));
    private final List<BasicColour> mediumPurples = new ArrayList<>(List.of(purple));
    private final List<BasicColour> lightPurples = new ArrayList<>(asList(lilac, lavender));

    /*pink*/
    private static final BasicColour magenta = new BasicColour("magenta");
    private static final BasicColour deepPink = new BasicColour("deep pink");
    private static final BasicColour hot = new BasicColour("hot pink");
    private static final BasicColour pink = new BasicColour("pink");
    private static final BasicColour salmon = new BasicColour("salmon pink");
    private static final BasicColour coral = new BasicColour("coral");
    private static final BasicColour lightPink = new BasicColour("light pink");

    private final List<BasicColour> darkPinks = new ArrayList<>(asList(magenta, deepPink));
    private final List<BasicColour> mediumPinks = new ArrayList<>(asList(hot, pink));
    private final List<BasicColour> lightPinks = new ArrayList<>(asList(salmon, coral, lightPink));

    /*brown*/
    private static final BasicColour darkBrown = new BasicColour("dark brown");
    private static final BasicColour brown = new BasicColour("brown");
    private static final BasicColour lightBrown = new BasicColour("light brown");

    /*nude*/
    private static final BasicColour nude = new BasicColour("nude");

    /*cream*/
    private static final BasicColour cream = new BasicColour("cream");

    /*beige*/
    private static final BasicColour beige = new BasicColour("beige");

    /*gray*/
    private static final BasicColour darkGray = new BasicColour("dark gray");
    private static final BasicColour gray = new BasicColour("gray");
    private static final BasicColour lightGray = new BasicColour("light gray");

    /*black*/
    private static final BasicColour black = new BasicColour("black");

    /*white*/
    private static final BasicColour white = new BasicColour("white");


    public List<BasicColour> mapMatchingColours(BasicColour toBeMatched) {

        final String colourName = toBeMatched.getName();
        if(containsColour(darkReds, colourName)) return getMatchingColoursForDarkReds();
        if(containsColour(mediumReds, colourName)) return getMatchingColoursForMediumReds();

        if(toBeMatched.getName().equals(orange.getName()) || toBeMatched.getName().equals(tangerine.getName())) return getMatchingColoursForOranges();

        if(toBeMatched.getName().equals(mustard.getName())) return getMatchingColoursForDarkYellows();
        if(toBeMatched.getName().equals(yellow.getName())) return getMatchingColoursForMediumYellows();
        if(toBeMatched.getName().equals(lemon.getName())) return getMatchingColoursForLightYellows();

        if(containsColour(darkGreens, colourName)) return getMatchingColoursForDarkGreens();
        if(containsColour(mediumGreens, colourName)) return getMatchingColoursForMediumGreens();
        if(containsColour(lightGreens, colourName)) return getMatchingColoursForLightGreens();

        if(containsColour(darkBlues, colourName)) return getMatchingColoursForDarkBlues();
        if(containsColour(mediumBlues, colourName)) return getMatchingColoursForMediumBlues();
        if(containsColour(lightBlues, colourName)) return getMatchingColoursForLightBlues();

        if(containsColour(darkPurples, colourName)) return getMatchingColoursForDarkPurples();
        if(containsColour(mediumPurples, colourName)) return getMatchingColoursForMediumPurples();
        if(containsColour(lightPurples, colourName)) return getMatchingColoursForLightPurples();

        if(containsColour(darkPinks, colourName)) return getMatchingColoursForDarkPinks();
        if(containsColour(mediumPinks, colourName)) return getMatchingColoursForMediumPinks();
        if(containsColour(lightPinks, colourName)) return getMatchingColoursForLightPinks();

        if(toBeMatched.getName().equals(darkBrown.getName())) return getMatchingColoursForDarkBrowns();
        if(toBeMatched.getName().equals(brown.getName())) return getMatchingColoursForMediumBrowns();
        if(toBeMatched.getName().equals(lightBrown.getName())) return getMatchingColoursForLightBrowns();

        if(toBeMatched.getName().equals(nude.getName()))  return getMatchingColoursForNude();

        if(toBeMatched.getName().equals(cream.getName())) return getMatchingColoursForCream();

        if(toBeMatched.getName().equals(beige.getName())) return getMatchingColoursForBeige();


        if(toBeMatched.getName().equals(darkGray.getName())) return getMatchingColoursForDarkGrays();
        if(toBeMatched.getName().equals(gray.getName())) return getMatchingColoursForMediumGrays();
        if(toBeMatched.getName().equals(lightGray.getName())) return getMatchingColoursForLightGrays();

        if(toBeMatched.getName().equals(black.getName()))return getMatchingColoursForBlack();

        if(toBeMatched.getName().equals(white.getName()))return getMatchingColoursForWhite();

        return null;
    }

    public boolean containsColour(final List<BasicColour> list, final String colour){
        return list.stream().map(BasicColour::getName).anyMatch(colour::equals);
    }

    private List<BasicColour> getMatchingColoursForDarkReds() {
        List<BasicColour> result = new ArrayList<>(darkGreens);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForMediumReds() {
        List<BasicColour> result = new ArrayList<>(mediumGreens);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForOranges() {
        List<BasicColour> result = new ArrayList<>(mediumBlues);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForDarkYellows() {
        List<BasicColour> result = new ArrayList<>(darkPurples);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForMediumYellows() {
        List<BasicColour> result = new ArrayList<>(mediumPurples);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForLightYellows() {
        List<BasicColour> result = new ArrayList<>(lightPurples);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForDarkGreens() {
        List<BasicColour> result = new ArrayList<>(darkPinks);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForMediumGreens() {
        List<BasicColour> result = new ArrayList<>(mediumPinks);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForLightGreens() {
        List<BasicColour> result = new ArrayList<>(lightPinks);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForDarkBlues() {
        List<BasicColour> result = new ArrayList<>(asList(orange, tangerine, black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForMediumBlues() {
        List<BasicColour> result = new ArrayList<>(asList(orange, tangerine, black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForLightBlues() {
        List<BasicColour> result = new ArrayList<>(asList(orange, tangerine, black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForDarkPurples() {
        List<BasicColour> result = new ArrayList<>(asList(orange, tangerine, black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForMediumPurples() {
        List<BasicColour> result = new ArrayList<>(asList(yellow, lemon, black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForLightPurples() {
        List<BasicColour> result = new ArrayList<>(lightGreens);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForDarkPinks() {
        List<BasicColour> result = new ArrayList<>(lightPinks);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForMediumPinks() {
        List<BasicColour> result = new ArrayList<>(mediumGreens);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForLightPinks() {
        List<BasicColour> result = new ArrayList<>(lightGreens);
        result.addAll(asList(black, white, cream, beige, lightGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForDarkBrowns() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray));
    }

    private List<BasicColour> getMatchingColoursForMediumBrowns() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
    }

    private List<BasicColour> getMatchingColoursForLightBrowns() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
    }

    private List<BasicColour> getMatchingColoursForNude() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
    }

    private List<BasicColour> getMatchingColoursForCream() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
    }

    private List<BasicColour> getMatchingColoursForBeige() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
    }

    private List<BasicColour> getMatchingColoursForDarkGrays() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray));
    }

    private List<BasicColour> getMatchingColoursForMediumGrays() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
    }

    private List<BasicColour> getMatchingColoursForLightGrays() {
        return new ArrayList<>(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
    }

    private List<BasicColour> getMatchingColoursForBlack() {
        List<BasicColour> result = new ArrayList<>(darkReds);
        result.addAll(mediumReds);
        result.addAll(darkGreens);
        result.addAll(mediumGreens);
        result.addAll(darkBlues);
        result.addAll(mediumBlues);
        result.addAll(darkPurples);
        result.addAll(mediumPurples);
        result.addAll(darkPinks);
        result.addAll(mediumPinks);
        result.addAll(lightPinks);
        result.addAll(asList(orange, tangerine, nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
        return result;
    }

    private List<BasicColour> getMatchingColoursForWhite() {
        List<BasicColour> result = new ArrayList<>(darkReds);
        result.addAll(mediumReds);
        result.addAll(darkGreens);
        result.addAll(mediumGreens);
        result.addAll(lightGreens);
        result.addAll(darkBlues);
        result.addAll(mediumBlues);
        result.addAll(lightBlues);
        result.addAll(darkPurples);
        result.addAll(mediumPurples);
        result.addAll(lightPurples);
        result.addAll(darkPinks);
        result.addAll(mediumPinks);
        result.addAll(lightPinks);
        result.addAll(asList(nude, beige, cream, black, white, brown, lightBrown, gray, lightGray, darkGray));
        return result;
    }
    
}

