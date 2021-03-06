package br.com.alura.forum.controller.request;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TopicRequest {

    private CourseRepository repository;

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

    @NotBlank(message = "Must not be blank.")
    @NotEmpty(message = "Must not be empty.")
    @NotNull(message = "Must not be null.")
    @Length(min = 5, message = "Length must be between 5 and 500.")
    private String courseName;

    public Topic convertTopicRequestToTopic(CourseRepository repository) {
        Course course = repository.findCourseByName(courseName);
        return new Topic(title, message, course);
    }
}
