package vod.web.rest.dto;

import lombok.Data;
import vod.model.Producent;

@Data
public class GameDTO {
    private String title;
    private Producent producent;
    private float rating;
}
