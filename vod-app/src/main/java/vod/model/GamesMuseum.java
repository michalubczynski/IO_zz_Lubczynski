package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="gamesmuseum")
public class GamesMuseum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 25)
    private String name;

    @ManyToMany(mappedBy = "gameMuseums")
    @JsonIgnore
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
