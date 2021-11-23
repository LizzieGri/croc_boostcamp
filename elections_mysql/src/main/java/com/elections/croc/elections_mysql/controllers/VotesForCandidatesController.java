package com.elections.croc.elections_mysql.controllers;

import com.elections.croc.elections_mysql.model.PollingStation;
import com.elections.croc.elections_mysql.model.Tik;
import com.elections.croc.elections_mysql.model.VotesCandidatesGet;
import com.elections.croc.elections_mysql.model.VotesForCandidates;
import com.elections.croc.elections_mysql.service.TikService;
import com.elections.croc.elections_mysql.service.VotesForCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VotesForCandidatesController {

    private final VotesForCandidatesService votesForCandidatesService;
    private final TikService tikService;

    @Autowired
    public VotesForCandidatesController(VotesForCandidatesService votesForCandidatesService, TikService tikService) {
        this.votesForCandidatesService = votesForCandidatesService;
        this.tikService = tikService;
    }

    @GetMapping("/votes_for_candidates")
    public String votesForCandidatesForm(Model model){

        model.addAttribute("votesForCandidates", new VotesCandidatesGet());
        return "votes/votes-for-candidates";
    }

    @PostMapping("/votes_for_candidates")
    public String votesForCandidates(@ModelAttribute("votesForCandidates") @Valid VotesCandidatesGet votesCandidatesGet,
                                     BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "votes/votes-for-candidates";
        }

        VotesForCandidates votesForCandidatesInBase1 = votesForCandidatesService.findById(1);
        votesForCandidatesInBase1.setAmountOfVotes(votesCandidatesGet.getAmountOfVotes1());
        votesForCandidatesService.save(votesForCandidatesInBase1);

        VotesForCandidates votesForCandidatesInBase2 = votesForCandidatesService.findById(2);
        votesForCandidatesInBase2.setAmountOfVotes(votesCandidatesGet.getAmountOfVotes2());
        votesForCandidatesService.save(votesForCandidatesInBase2);

        VotesForCandidates votesForCandidatesInBase3 = votesForCandidatesService.findById(3);
        votesForCandidatesInBase3.setAmountOfVotes(votesCandidatesGet.getAmountOfVotes3());
        votesForCandidatesService.save(votesForCandidatesInBase3);

        VotesForCandidates votesForCandidatesInBase4 = votesForCandidatesService.findById(4);
        votesForCandidatesInBase4.setAmountOfVotes(votesCandidatesGet.getAmountOfVotes4());
        votesForCandidatesService.save(votesForCandidatesInBase4);

        VotesForCandidates votesForCandidatesInBase5 = votesForCandidatesService.findById(5);
        votesForCandidatesInBase5.setAmountOfVotes(votesCandidatesGet.getAmountOfVotes5());
        votesForCandidatesService.save(votesForCandidatesInBase5);


        List<VotesForCandidates> candidatesList = votesForCandidatesService.findAll();
        int allVotes = 0;
        for (VotesForCandidates candidate : candidatesList){
            allVotes += candidate.getAmountOfVotes();
        }

        for (VotesForCandidates candidate : candidatesList){
            VotesForCandidates currentCandidate =
                    votesForCandidatesService.findById(candidate.getIdCandidate());
            double percent = Math.round(currentCandidate.getAmountOfVotes() * 1.0
                    / allVotes * 10000) / 100.0;
            currentCandidate.setPercentVotes(percent);
            votesForCandidatesService.save(currentCandidate);
        }
        return "redirect:/votes_for_candidates";
    }

    @GetMapping("/votes-info")
    public String votesForCandidates(Model model){
        for (int i = 1; i <= 5; i++){
            String name = "candidate" + i;
            model.addAttribute(name, votesForCandidatesService.findById(i));
        }

        int showedVoters = 0;
        int allVoters = 0;
        List<Tik> tikList = tikService.findAll();
        for (Tik tik : tikList){
            showedVoters += tik.getAmountVotersShowed();
            allVoters += tik.getAmountVoters();
        }

        double percent = Math.round(showedVoters*1.0/ allVoters * 10000) / 100.0;
        model.addAttribute("showedVoters", showedVoters);
        model.addAttribute("allVoters", allVoters);

        model.addAttribute("percent", percent);
        return "votes/votes-candidate";

    }
}
