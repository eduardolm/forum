package br.com.alura.forum.controller.request;

import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicUpdateRequest {

    @NotBlank(message = "Must not be blank.")
    @NotEmpty(message = "Must not be empty.")
    @NotNull(message = "Must not be null.")
    @Length(min = 5, message = "Length must be between 5 and 500.")
    private String title;

    @NotBlank(message = "Must not be blank.")
    @NotEmpty(message = "Must not be empty.")
    @NotNull(message = "Must not be null.")
    @Length(min = 10, message = "Length must be between 10 and 500.")
    private String message;


    public Topic convertTopicUpdateRequestToTopic(Long id, TopicRepository repository) {
        Topic topic = repository.findById(id).orElseThrow();
        topic.setTitle(title);
        topic.setMessage(message);
        return topic;
    }
}
