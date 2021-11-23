package com.elections.croc.elections_mysql.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "votes_for_candidates")
public class VotesForCandidates {
    @Id
    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 1, message = "Ид должен быть от 1 до 5")
    @Max(value = 5, message = "Ид должен быть от 1 до 5")
    @Column(name = "id_candidate")
    private Integer idCandidate;

    @Column(name = "fio_candidate")
    private String fioCandidate;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Минимальное количество голосов равно 0")
    @Column(name = "amount_of_votes")
    private Integer amountOfVotes;

    @Column(name = "percent_votes")
    private double percentVotes;

}
