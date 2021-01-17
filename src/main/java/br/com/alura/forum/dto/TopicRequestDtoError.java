package br.com.alura.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NotNull
public class TopicRequestDtoError {

    private String field;
    private String error;
}
