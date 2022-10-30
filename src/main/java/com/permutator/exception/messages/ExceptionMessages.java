package com.permutator.exception.messages;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessages {

    NO_RUNNING_ENTITY_FOUND("Żadne zadanie nie jest aktywne"),

    NOT_ENOUGH_PERMUTATION_TO_DISPLAY("Zbyt duża liczba żadąnych permutacji");

    private final String message;

}
