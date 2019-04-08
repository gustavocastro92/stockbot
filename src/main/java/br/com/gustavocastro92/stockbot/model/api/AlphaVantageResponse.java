package br.com.gustavocastro92.stockbot.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class AlphaVantageResponse {

    @JsonProperty("Meta Data")
    AlphaMetaData alphaMetaData;

    @JsonProperty("Time Series (Daily)")
    Map<LocalDate, DailyTimeSerieModel> timeSeries;

}
