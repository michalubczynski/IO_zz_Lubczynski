package vod.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JoinColumn(name= "producent_id")
    private Producent producent;

    private float rating;
    @ManyToMany
    @JoinTable(
            name="game_gamesmuseum",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "gamesmuseum_id", referencedColumnName = "id")
    )
    private List<GamesMuseum> gameMuseums = new ArrayList<>();

    public Game(int id, String title, Producent producent, float rating) {
        this.id = id;
        this.title = title;
        this.producent = producent;
        this.rating = rating;
    }

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Producent getProducent() {
        return producent;
    }
    public int getProducentId(){return producent.getId();}

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<GamesMuseum> getMuseums() {
        return gameMuseums;
    }

    public void setMuseums(List<GamesMuseum> gameMuseums) {
        this.gameMuseums = gameMuseums;
    }

    public void addMuseum(GamesMuseum gM) {
        this.gameMuseums.add(gM);
    }


    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", director=" + producent +
                ", rating=" + rating +
                '}';
    }
}
