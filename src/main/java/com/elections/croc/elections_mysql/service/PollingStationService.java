package com.elections.croc.elections_mysql.service;

import com.elections.croc.elections_mysql.model.PollingStation;
import com.elections.croc.elections_mysql.repository.PollingStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollingStationService {
    private final PollingStationRepository pollingStationRepository;

    @Autowired
    public PollingStationService(PollingStationRepository pollingStationRepository) {
        this.pollingStationRepository = pollingStationRepository;
    }

    public PollingStation findById(int id){
        return pollingStationRepository.getById(id);
    }

    public List<PollingStation> findAll(){
        return pollingStationRepository.findAll();
    }

    public PollingStation savePollingStation(PollingStation pollingStation){
        return pollingStationRepository.save(pollingStation);
    }

    public void deleteById(int id){
        pollingStationRepository.deleteById(id);
    }
}
