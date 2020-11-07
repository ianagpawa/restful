package com.ianagpawa.restful.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ianagpawa.restful.quote.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProjectRepository repository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Project>> typeReference = new TypeReference<List<Project>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json.projects.json");
            try {
                List<Project> projects = mapper.readValue(inputStream,typeReference);
                projects
                        .stream()
                        .forEach((quote) -> { log.info("Preloading " + repository.save(quote)); });
                log.info("Projects loaded!");
            } catch (IOException e){
                log.info("Unable to load projects: " + e.getMessage());
            }
        };
    }
}
