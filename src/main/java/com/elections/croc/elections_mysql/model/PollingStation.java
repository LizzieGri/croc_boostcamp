package com.elections.croc.elections_mysql.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "polling_station")
public class PollingStation {
    @Id
    @Column(name = "id_station")
    private int idStation;

    @Column(name = "name_station")
    private String nameStation;

    @Column(name = "amount_voters")
    private int amountVoters;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Количество не должно быть отрицательным")
    @Column(name = "amount_voters_showed")
    private Integer amountVotersShowed;

    @Column(name = "percent_voters")
    private double percentVoters;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Количество не должно быть отрицательным")
    @Column(name = "amount_issued_bulletins")
    private Integer amountIssuedBulletins;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Количество не должно быть отрицательным")
    @Column(name = "amount_spoiled_bulletins")
    private Integer amountSpoiledBulletins;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Количество не должно быть отрицательным")
    @Column(name = "amount_dropped_bulletins")
    private Integer amountDroppedBulletins;

    @Column(name = "id_tik")
    private int idTik;

    public PollingStation() {
    }

}
