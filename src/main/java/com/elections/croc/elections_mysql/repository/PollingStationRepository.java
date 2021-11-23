package com.elections.croc.elections_mysql.repository;


import com.elections.croc.elections_mysql.model.PollingStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollingStationRepository extends JpaRepository<PollingStation, Integer> {
}
