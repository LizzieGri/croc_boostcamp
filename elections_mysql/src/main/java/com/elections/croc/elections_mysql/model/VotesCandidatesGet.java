package com.elections.croc.elections_mysql.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class VotesCandidatesGet {

        @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Минимальное количество голосов равно 0")
    private Integer amountOfVotes1;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Минимальное количество голосов равно 0")
    private Integer amountOfVotes2;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Минимальное количество голосов равно 0")
    private Integer amountOfVotes3;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Минимальное количество голосов равно 0")
    private Integer amountOfVotes4;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Минимальное количество голосов равно 0")
    private Integer amountOfVotes5;
}
