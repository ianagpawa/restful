package com.ianagpawa.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ianagpawa.restful.project.Project;
import com.ianagpawa.restful.project.ProjectRepository;
import com.ianagpawa.restful.quote.Quote;
import com.ianagpawa.restful.quote.QuoteRepository;
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

    @Bean
    CommandLineRunner initProjectDatabase(ProjectRepository repository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Project>> typeReference = new TypeReference<List<Project>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/projects.json");
            try {
                List<Project> projects = mapper.readValue(inputStream,typeReference);
                projects
                        .stream()
                        .forEach((project) -> {
                            log.info("Preloading " + repository.save(project));
                        });
                log.info("Projects loaded!");
            } catch (IOException e){
                log.info("Unable to load projects: " + e.getMessage());
            }
        };
    }
}

