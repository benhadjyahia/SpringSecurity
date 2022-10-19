package com.example.demo.Controller;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Playload.JournalRequest;
import com.example.demo.Playload.JournalResponse;
import com.example.demo.entities.ESociety;
import com.example.demo.entities.Journal;
import com.example.demo.serviceImpl.JournalServiceImp;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {
final JournalServiceImp journalService;

    public JournalController(JournalServiceImp journalService) {
        this.journalService = journalService;
    }

    @PostMapping("/addJournal/{userId}")
    @ResponseBody
    public JournalResponse addJournal(@RequestBody JournalRequest journal, @PathVariable  Long userId) throws UserNotFoundException {



    return journalService.addJournal(journal,userId);
    }

    @GetMapping("/getJournalBySociety")
    @ResponseBody
    public List<Journal> getJournalBySociety(@RequestParam ESociety society){


        return journalService.getJournalBySociety(society);
    }

    @PutMapping("/update/{journalId}")
    @ResponseBody
    public Journal Update(@RequestBody JournalRequest journal,Long journalId){


        return journalService.updateJournale(journal,journalId);
    }
    @GetMapping("/findAll")
    @ResponseBody
    public List<Journal> getJournalBySociety(){


        return journalService.findAll();
    }
@DeleteMapping("/delete/{journalId}")
    @ResponseBody
    public void delet( Long journalId){
        journalService.deletJournal(journalId);
}

}
