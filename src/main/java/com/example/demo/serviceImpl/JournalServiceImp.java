package com.example.demo.serviceImpl;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Playload.JournalRequest;
import com.example.demo.Playload.JournalResponse;
import com.example.demo.Repository.JournalRepo;
import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.ESociety;
import com.example.demo.entities.User;
import com.example.demo.service.IJournalService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Journal;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class JournalServiceImp implements IJournalService {

final  JournalRepo jounalrepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public JournalServiceImp(JournalRepo jounalrepository) {
        this.jounalrepository = jounalrepository;
    }


    @Override
    public JournalResponse addJournal(JournalRequest journarequest, Long userId) throws UserNotFoundException {
        float credit,debit;
        User user = userRepository.findById(userId).orElse(null);
        if (user==null){
         throw   new UserNotFoundException("user not found");
        }
else{
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        //modelMapper
        debit = journarequest.getDebit();
        credit = journarequest.getCredit();

            Journal  journal = modelMapper.map(journarequest, Journal.class);
        float total=debit-credit;

        Journal journalSaved = jounalrepository.save(journal);
        //pour les reponses
       JournalResponse journalResponse = modelMapper.map(journal,JournalResponse.class);
journal.setCreatedAt(LocalDateTime.now());
journal.setTotal(total);
        return journalResponse ;
    }
    }

    @Override
    public List<Journal> getJournalBySociety(ESociety society) {
        return  jounalrepository.findBySociety(society);

    }

    @Override
    public Journal updateJournale(JournalRequest journarequest, Long journalId) {
      Journal journal = jounalrepository.findById(journalId).get();
        float credit,debit;
        debit = journarequest.getDebit();
        credit = journarequest.getCredit();

        journal.setTotal(debit-credit);

        journal.setUpdatedAt(LocalDateTime.now());

        journal.setCredit(journarequest.getCredit());
        journal.setDebit(journarequest.getDebit());
        journal.setSociety(journarequest.getSociety());
        journal.setLibelle(journarequest.getLibelle());
        jounalrepository.saveAndFlush(journal);
        return journal;
    }

    @Override
    public List<Journal> findAll() {

        return jounalrepository.findAll();
    }

    @Override
    public void deletJournal(Long journalId ) {

        jounalrepository.deleteById(journalId);
    }


}
