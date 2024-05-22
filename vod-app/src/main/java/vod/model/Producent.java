package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Producent {

    private int id;
    private String firstName;
    @JsonIgnore
    private List<Game> games = new ArrayList<>();

    public Producent(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;

    }

    public Producent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        return "Producent{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
