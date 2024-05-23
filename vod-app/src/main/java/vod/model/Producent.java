package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="producent")
public class Producent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @OneToMany(mappedBy = "producent")
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
