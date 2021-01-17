package br.com.alura.forum.dto;

import br.com.alura.forum.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private Long id;
    private String message;
    private LocalDateTime createAt;
    private String authorName;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.createAt = answer.getCreatedAt();
        this.authorName = answer.getAuthor().getName();
    }
}
