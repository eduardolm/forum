package br.com.alura.forum.dto;

import br.com.alura.forum.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
    }

    public static List<TopicDto> convertTopicToTopicDto(List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
    }
}
