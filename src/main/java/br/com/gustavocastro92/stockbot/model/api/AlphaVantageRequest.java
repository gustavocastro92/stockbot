package br.com.gustavocastro92.stockbot.model.api;

import br.com.gustavocastro92.stockbot.model.builder.AlphaVantageRequestBuilder;
import br.com.gustavocastro92.stockbot.constant.ServiceConstants;
import lombok.Data;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class AlphaVantageRequest {

    private final String SCHEME = "https";
    private final String HOST = "www.alphavantage.co";
    private final String BASE_PATH = "/query";
    private final String URI_AND = "&";
    private final String URI_EQUALS = "=";
    private final String URI_FUNCTION = "function";
    private final String URI_SYMBOL = "symbol";
    private final String URI_OUTPUTSIZE = "outputsize";
    private final String URI_DATATYPE = "datatype";
    private final String URI_APIKEY = "apikey";
    private final String URI_INTERVAL = "interval";

    private String function;
    private String symbol;
    private String outputSize = "compact";
    private String dataType = "json";
    private String apiKey = ServiceConstants.API_KEY;
    private String interval = "5min";

    public String buildUri() throws NoSuchFieldException {

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path(BASE_PATH);

        builder = addParamIfNotNull(builder, this.URI_FUNCTION, this.function );
        addParamIfNotNull(builder, this.URI_FUNCTION, this.function);
        addParamIfNotNull(builder, this.URI_SYMBOL, this.symbol);
        addParamIfNotNull(builder, this.URI_OUTPUTSIZE, this.outputSize);
        addParamIfNotNull(builder, this.URI_DATATYPE, this.dataType);
        addParamIfNotNull(builder, this.URI_INTERVAL, this.interval);
        addParamIfNotNull(builder, this.URI_APIKEY, this.apiKey);

        UriComponents uri = builder.build();

        return uri.toUriString();
    }

    private UriComponentsBuilder addParamIfNotNull(UriComponentsBuilder builder, String paramKey, String value){
        if (value != null) return builder.queryParam(paramKey, value);
        return builder;
    }

    public AlphaVantageRequest(AlphaVantageRequestBuilder builder){
        this.function = builder.getFunction();
        this.symbol = builder.getSymbol();
        this.outputSize = builder.getOutputSize() == null ? this.outputSize : builder.getOutputSize();
        this.dataType = builder.getDataType() == null ? this.dataType : builder.getDataType();
    }

}
