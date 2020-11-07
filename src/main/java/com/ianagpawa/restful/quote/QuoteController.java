package com.ianagpawa.restful.quote;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    private final QuoteRepository repository;

    QuoteController(QuoteRepository repository) { this.repository = repository; }

    @GetMapping("/quotes")
    List<Quote> all() { return repository.findAll(); }

    @PostMapping("/quotes")
    Quote newQuote(@RequestBody Quote newQuote) { return repository.save(newQuote); }

    @GetMapping("/quotes/{id}")
    Quote one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new QuoteNotFoundException(id));
    }

    @PutMapping("/quotes/{id}")
    Quote replaceQuote(@RequestBody Quote newQuote, @PathVariable Long id) {
        return repository
                .findById(id)
                .map(quote -> {
                    if (!newQuote.getName().isEmpty()) { quote.setName(newQuote.getName()); }
                    if (!newQuote.getContent().isEmpty()) { quote.setContent(newQuote.getContent()); }
                    if (!newQuote.getSource().isEmpty()) { quote.setSource(newQuote.getSource()); }
                    return repository.save(quote);
                })
                .orElseGet(() -> {
                    newQuote.setId(id);
                    return repository.save(newQuote);
                });
    }

    @DeleteMapping("/quotes/{id}")
    void deleteQuote(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/quotes/random")
    Quote random() {
        List<Quote> allQuotes = repository.findAll();
        int index = (new Random()).nextInt(allQuotes.size());
        return allQuotes.get(index);
    }
}
