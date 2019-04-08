package br.com.gustavocastro92.stockbot.model.builder;

import br.com.gustavocastro92.stockbot.model.api.AlphaVantageRequest;
import lombok.Data;

@Data
public class AlphaVantageRequestBuilder {

    private String function;
    private String symbol;
    private String outputSize = "compact";
    private String dataType = "json";

    public AlphaVantageRequestBuilder function(String function) {
        this.function = function;
        return this;
    }

    public AlphaVantageRequestBuilder symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public AlphaVantageRequestBuilder outputSize(String outputSize) {
        this.outputSize = outputSize;
        return this;
    }

    public AlphaVantageRequestBuilder dataType(String dataType) {
        this.dataType = dataType;
        return this;
    }

    public AlphaVantageRequest build() {
        return new AlphaVantageRequest(this);
    }

}