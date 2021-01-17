package br.com.alura.forum.config;

import br.com.alura.forum.dto.exception.NoSuchElementErrorDto;
import br.com.alura.forum.dto.exception.TopicRequestDtoError;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ErrorHandler {

    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<TopicRequestDtoError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<TopicRequestDtoError> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            TopicRequestDtoError error = new TopicRequestDtoError(e.getField(), message);
            dto.add(error);
        });
        return dto;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
     public NoSuchElementErrorDto handleNoSuchElementException(NoSuchElementException exception) {
        var excpetionMessage = exception.getLocalizedMessage();
        return new NoSuchElementErrorDto(excpetionMessage);
    }

}
