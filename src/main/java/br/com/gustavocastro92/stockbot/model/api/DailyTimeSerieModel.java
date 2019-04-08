package br.com.gustavocastro92.stockbot.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class DailyTimeSerieModel {

    @JsonProperty("1. open")
    private Double open;

    @JsonProperty("2. high")
    private Double high;

    @JsonProperty("3. low")
    private Double low;

    @JsonProperty("4. close")
    private Double close;

    @JsonProperty("5. volume")
    private Long volume;
}
