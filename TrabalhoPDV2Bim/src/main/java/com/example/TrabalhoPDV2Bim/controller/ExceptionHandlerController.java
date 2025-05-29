package com.example.TrabalhoPDV2Bim.controller;


import com.example.TrabalhoPDV2Bim.dto.ApiExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ExceptionHandlerController {

    //Método par atratar Exception.class genérica
    //@ExceptionHandler(Exception.class) diz que este método irá tratar qualquer exceção do tipo Excetion
    // ou seja, qualquer exceção genérica não tratada especificamente por outros handlers
    //ApiExceptionDTO para transportar informadções do erro para o cliente
    // ResponseEntity.InternalServerError(): Retorna um HTTP 500 (erro interno do servidor)

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionDTO> handleException(Exception e){
        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO(e.getMessage());
        return ResponseEntity.internalServerError().body(apiExceptionDTO);
    }

    //@ExceptionHandler(MethodArgumentNotValidException.class trata as exceções lançadas quando a validação de parãmetros
    //de entrada falham
    //e.getBindingResut().getFielErrors() retorna os erros de validação de campos individuais
    //fielError.getField() nome do campo com erro
    //fieldError.getDefaultMessage() Mensagem associada à violaçãi de valdação (como "não pode estar em branco")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionDTO> handleException(MethodArgumentNotValidException e){
        List<String> errors = new ArrayList<>();

        for(FieldError fieldError : e.getBindingResult().getFieldErrors()){
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO(errors);

        return ResponseEntity.internalServerError().body(apiExceptionDTO);
    }

}
