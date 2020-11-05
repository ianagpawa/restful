package com.ianagpawa.restful.quote;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(QuoteRepository repository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Quote>> typeReference = new TypeReference<List<Quote>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/quotes.json");
            try {
                List<Quote> quotes = mapper.readValue(inputStream,typeReference);
                quotes
                        .stream()
                        .forEach((quote) -> {
                            log.info("Preloading " + repository.save(quote));
                        });
                log.info("Quotes loaded!");
            } catch (IOException e){
                log.info("Unable to load quotes: " + e.getMessage());
            }
        };
    }
}

