package br.com.gustavocastro92.stockbot.model.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_daily_time_serie")
public class DailyTimeSerie {

    @Id
    private Integer id;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Long volume;
    private String symbol;

}
