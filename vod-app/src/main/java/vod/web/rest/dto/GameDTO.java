package vod.web.rest.dto;

import lombok.Data;
import vod.model.Producent;

@Data
public class GameDTO {
    private String title;
    private int producentId;
    private float rating;
}
