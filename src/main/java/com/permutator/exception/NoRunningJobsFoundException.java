package com.permutator.exception;


import com.permutator.exception.messages.ExceptionMessages;

public class NoRunningJobsFoundException extends RuntimeException {

    public NoRunningJobsFoundException() {
        super(String.format(ExceptionMessages.NO_RUNNING_ENTITY_FOUND.getMessage()));
    }
}
