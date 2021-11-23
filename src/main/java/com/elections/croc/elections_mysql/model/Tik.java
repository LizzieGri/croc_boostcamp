package com.elections.croc.elections_mysql.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tik")
public class Tik {

    @Id
    @Column(name = "id_tik")
    private int idTik;

    @Column(name = "name_tik")
    private String nameTik;

    @Column(name = "amount_voters")
    private int amountVoters;

    @Column(name = "amount_voters_showed")
    private int amountVotersShowed;

    @Column(name = "percent_voters")
    private double percentVoters;

    public Tik() {
    }
}
