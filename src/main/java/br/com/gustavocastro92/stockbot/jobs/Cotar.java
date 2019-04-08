package br.com.gustavocastro92.stockbot.jobs;

import br.com.gustavocastro92.stockbot.model.api.AlphaVantageResponse;
import br.com.gustavocastro92.stockbot.model.builder.AlphaVantageRequestBuilder;
import br.com.gustavocastro92.stockbot.model.api.AlphaVantageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Cotar {

    private static final Logger log = LoggerFactory.getLogger(Cotar.class);

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {

        AlphaVantageRequest alphaVantageRequest = new AlphaVantageRequestBuilder()
                .symbol("MSFT")
                .function("TIME_SERIES_DAILY")
                .build();

        try {
            ResponseEntity<AlphaVantageResponse> response
                    = restTemplate.getForEntity(alphaVantageRequest.buildUri(), AlphaVantageResponse.class);

            log.info("Status code: " + response.getStatusCode() + "\n" + "Response: " + response.getBody());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
