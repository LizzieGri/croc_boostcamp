package com.elections.croc.elections_mysql.service;

import com.elections.croc.elections_mysql.model.VotesForCandidates;
import com.elections.croc.elections_mysql.repository.VotesForCandidatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotesForCandidatesService {

    private final VotesForCandidatesRepository votesForCandidatesRepository;

    public VotesForCandidatesService(VotesForCandidatesRepository votesForCandidatesRepository) {
        this.votesForCandidatesRepository = votesForCandidatesRepository;
    }

    public VotesForCandidates findById(int id){
        return votesForCandidatesRepository.getById(id);
    }

    public List<VotesForCandidates> findAll(){
        return votesForCandidatesRepository.findAll();
    }

    public VotesForCandidates save(VotesForCandidates votesForCandidates){
        return votesForCandidatesRepository.save(votesForCandidates);
    }
}
