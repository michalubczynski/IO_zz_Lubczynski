package vod.repository.mem;

import vod.model.GamesMuseum;
import vod.model.Producent;
import vod.model.Game;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<GamesMuseum> gamesMuseums = new ArrayList<>();

    static List<Producent> producents = new ArrayList<>();

    static List<Game> games = new ArrayList<>();

    static {

        Producent rockstar = new Producent(1, "Rockstar");
        Producent cdProjectRed = new Producent(2, "CD Project Red");
        Producent eaGames = new Producent(3, "EA");
        Producent blizzard = new Producent(4, "Blizzard");

        Game gta = new Game(1, "GTA V", rockstar, (float) 4.1);
        Game rdr2 = new Game(2, "Read Dead Redemption II",  rockstar, (float) 4.3);

        Game witcher = new Game(3, "Witcher III",  cdProjectRed, (float) 3.9);
        Game cyberPunk = new Game(4, "Cyberpunk 2077",  cdProjectRed, (float) 3.1);

        Game fifa = new Game(5, "Fifa 14",  eaGames, (float) 4.7);
        Game sims = new Game(6, "Sims 3", eaGames, (float) 4.4);

        Game overwatch = new Game(7, "Overwatch",  blizzard, (float) 4.9);
        Game heartStone = new Game(8, "HeartStone",  blizzard, (float) 4.3);

        bind(gta, rockstar);
        bind(rdr2, rockstar);

        bind(witcher, cdProjectRed);
        bind(cyberPunk, cdProjectRed);

        bind(fifa, eaGames);
        bind(sims, eaGames);

        bind(overwatch, blizzard);
        bind(heartStone, blizzard);

        GamesMuseum wMKIG = new GamesMuseum(1, "WARSZAWSKIE MUZEUM KOMPUTERÓW I GIER");
        GamesMuseum krakowArcadeMuseum = new GamesMuseum(2, "Kraków Arcade Museum");
        GamesMuseum wroclawMuseumGamesAndComputersOfThePast = new GamesMuseum(3, "Wroclaw Museum Games & Computers Of The Past Era");
        GamesMuseum nationalVideogameMuseum = new GamesMuseum(4, "National Videogame Museum");

        bind(wMKIG, rdr2);
        bind(wroclawMuseumGamesAndComputersOfThePast, rdr2);
        bind(wroclawMuseumGamesAndComputersOfThePast, gta);
        bind(wroclawMuseumGamesAndComputersOfThePast, witcher);

        bind(wMKIG, sims);
        bind(nationalVideogameMuseum, sims);
        bind(nationalVideogameMuseum, overwatch);
        bind(krakowArcadeMuseum, overwatch);
        bind(krakowArcadeMuseum, witcher);

        games.add(gta);
        games.add(rdr2);
        games.add(witcher);
        games.add(cyberPunk);
        games.add(fifa);
        games.add(sims);
        games.add(overwatch);
        games.add(heartStone);

        producents.add(rockstar);
        producents.add(cdProjectRed);
        producents.add(eaGames);
        producents.add(blizzard);

        gamesMuseums.add(wMKIG);
        gamesMuseums.add(krakowArcadeMuseum);
        gamesMuseums.add(wroclawMuseumGamesAndComputersOfThePast);
        gamesMuseums.add(nationalVideogameMuseum);

    }

    private static void bind(GamesMuseum gM, Game g) {
        gM.addGame(g);
        g.addMuseum(gM);
    }

    private static void bind(Game g, Producent p) {
        p.addGame(g);
        g.setProducent(p);
    }

}
