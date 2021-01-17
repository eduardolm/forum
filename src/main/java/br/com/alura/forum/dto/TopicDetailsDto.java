package br.com.alura.forum.dto;

import br.com.alura.forum.model.Answer;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.model.TopicStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDetailsDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private String authorName;
    private TopicStatus status;
    private List<AnswerDto> answers;

    public TopicDetailsDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
        this.authorName = topic.getUser().getName();
        this.status = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
    }
}
