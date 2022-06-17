package com.hakaneroztekin.javaspringwithdocker.controller;

import com.hakaneroztekin.javaspringwithdocker.model.ClickCount;
import com.hakaneroztekin.javaspringwithdocker.repository.ClickCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GreetingsController {

    private static final String DOCUMENT_KEY = "clickCount";

    private final ClickCountRepository clickCountRepository;

    @GetMapping
    public String printClickCount() {
        long clickCountInDatabase = getClickCountInDatabase();
        long incrementedClickCount = incrementClickCountInDatabase(clickCountInDatabase);
        return "Hello, this page is visited " + incrementedClickCount + " times.";
    }

    private long getClickCountInDatabase() {
        boolean documentExists = clickCountRepository.existsById(DOCUMENT_KEY);
        System.out.println("document exists? " + documentExists);
        if (documentExists) {
            ClickCount clickCount = clickCountRepository.findById(DOCUMENT_KEY).get();
            System.out.println("returning existing document with count " + clickCount.getCount());
            return clickCount.getCount();
        }

        long clickCountInDatabase = 0;
        System.out.println("document doesn't exist, creating a new document with count " + clickCountInDatabase);
        saveClickCount(clickCountInDatabase);
        return clickCountInDatabase;
    }

    private long incrementClickCountInDatabase(long clickCountInDatabase) {
        long incrementedClickCount = clickCountInDatabase + 1;
        System.out.println("incremented click count to " + incrementedClickCount);
        ClickCount savedClickCount = saveClickCount(incrementedClickCount);
        return savedClickCount.getCount();
    }

    private ClickCount saveClickCount(long clickCount) {
        return clickCountRepository.save(ClickCount.builder().id(DOCUMENT_KEY).count(clickCount).build());
    }
}