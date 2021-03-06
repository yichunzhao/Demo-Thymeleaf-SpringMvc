package com.ynz.front.demothymeleaf.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlers {

    @ExceptionHandler
    public String handleExceptions(Exception e, Model model) {
        log.error(e.getMessage(), e);

        List<String> errors = Stream.of(e.getMessage()).collect(toList());
        model.addAttribute("errs", errors);
        return "error";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException e, Model model) {
        log.warn(e.getMessage());
        String errMsg = "The persisted entity is already existed due to the same phone or email";

        List<String> errors = Stream.of(errMsg).collect(toList());
        model.addAttribute("errs", errors);
        return "error";
    }

}
