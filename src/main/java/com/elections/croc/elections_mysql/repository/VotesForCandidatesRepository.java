package com.elections.croc.elections_mysql.repository;

import com.elections.croc.elections_mysql.model.VotesForCandidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesForCandidatesRepository extends JpaRepository<VotesForCandidates, Integer> {
    }
