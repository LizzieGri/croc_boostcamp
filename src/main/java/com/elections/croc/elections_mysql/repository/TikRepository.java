package com.elections.croc.elections_mysql.repository;


import com.elections.croc.elections_mysql.model.Tik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TikRepository extends JpaRepository<Tik, Integer> {
}
