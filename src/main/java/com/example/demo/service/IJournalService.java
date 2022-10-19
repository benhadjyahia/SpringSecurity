package com.example.demo.service;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Playload.JournalRequest;
import com.example.demo.Playload.JournalResponse;
import com.example.demo.entities.ESociety;
import com.example.demo.entities.Journal;

import java.util.List;

public interface IJournalService {
    public JournalResponse addJournal (JournalRequest journalrequest , Long userId) throws UserNotFoundException;
   List<Journal> getJournalBySociety(ESociety society);
   Journal updateJournale(JournalRequest journarequest, Long journalId);
   List<Journal> findAll();
   public void deletJournal(Long journalId);
}
