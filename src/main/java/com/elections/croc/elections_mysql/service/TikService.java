package com.elections.croc.elections_mysql.service;

import com.elections.croc.elections_mysql.model.PollingStation;
import com.elections.croc.elections_mysql.model.Tik;
import com.elections.croc.elections_mysql.repository.TikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TikService {

    private final TikRepository tikRepository;

    public TikService(TikRepository tikRepository) {
        this.tikRepository = tikRepository;
    }

    public Tik findById(int id){
        return tikRepository.getById(id);
    }

    public List<Tik> findAll(){
        return tikRepository.findAll();
    }

    public Tik saveTik(Tik tik){
        return tikRepository.save(tik);
    }

}
