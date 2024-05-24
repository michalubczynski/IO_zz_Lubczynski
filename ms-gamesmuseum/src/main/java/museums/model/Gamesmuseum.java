package museums.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Gamesmuseum implements Serializable {

    @ElementCollection
    @CollectionTable(name = "GAME_GAMESMUSEUM", joinColumns = @JoinColumn(name = "gamesmuseum_id"))
    @Column(name = "game_id")
    public Set<Integer> games;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Transient
    private List<String> gameNames = new ArrayList<>();

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                '}';
    }
}
