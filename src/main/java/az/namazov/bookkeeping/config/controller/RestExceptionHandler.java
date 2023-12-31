package az.namazov.bookkeeping.config.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.namazov.bookkeeping.exception.JwtAuthenticationException;
import az.namazov.bookkeeping.exception.NotFoundException;
import az.namazov.bookkeeping.exception.PreconditionFailed;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    private record ExceptionResponse(List<String> errors) {
    }

    @ExceptionHandler(value = PreconditionFailed.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ExceptionResponse preconditionFailed(final PreconditionFailed ex) {
        return new ExceptionResponse(List.of(ex.getMessage()));
    }


    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse illegalArgument(final IllegalArgumentException ex) {
        return new ExceptionResponse(List.of(ex.getMessage()));
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFound(final NotFoundException ex) {
        return new ExceptionResponse(List.of(ex.getMessage()));
    }

    // TODO: 27.06.2023 продумать статус ответа
    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionResponse badAuth(final JwtAuthenticationException ex) {
        return new ExceptionResponse(List.of(ex.getMessage()));
    }
}
