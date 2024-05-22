package vod.model;

import java.util.ArrayList;
import java.util.List;

public class GamesMuseum {

    private int id;
    private String name;
    private List<Game> games = new ArrayList<>();

    public GamesMuseum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GamesMuseum() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game g) {
        this.games.add(g);
    }

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                '}';
    }
}
