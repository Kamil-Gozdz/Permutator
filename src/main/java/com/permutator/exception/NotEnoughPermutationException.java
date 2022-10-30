package com.permutator.exception;


import com.permutator.exception.messages.ExceptionMessages;

public class NotEnoughPermutationException extends RuntimeException {

    public NotEnoughPermutationException() {
        super(String.format(ExceptionMessages.NOT_ENOUGH_PERMUTATION_TO_DISPLAY.getMessage()));
    }
}
