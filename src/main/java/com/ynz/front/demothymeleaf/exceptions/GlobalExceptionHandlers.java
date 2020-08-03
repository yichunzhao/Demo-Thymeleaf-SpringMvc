package com.ynz.front.demothymeleaf.exceptions;

import com.ynz.front.demothymeleaf.dto.ClientDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler
    public String handleExceptions(Exception e, Model model) {
        List<String> errors = Stream.of(e.getMessage()).collect(toList());
        model.addAttribute("errs", errors);
        return "error";
    }

//    @ExceptionHandler(BindException.class)
//    public String handleBindException(BindException e, Model model) {
//        List<String> errors = e.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(toList());
//        model.addAttribute("errs", errors);
//        return "error";
//    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException e, Model model) {
        List<String> errors = Stream.of(e.getMessage()).collect(toList());
        model.addAttribute("errs", errors);
        return "error";
    }

    @ModelAttribute
    public ClientDto clientDto() {
        return new ClientDto();
    }

}
