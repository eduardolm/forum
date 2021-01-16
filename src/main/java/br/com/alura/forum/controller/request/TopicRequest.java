package br.com.alura.forum.controller.request;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TopicRequest {

    private CourseRepository repository;
    private String title;
    private String message;
    private String courseName;

    public Topic convertTopicRequestToTopic(CourseRepository repository) {
        Course course = repository.findCourseByName(courseName);
        return new Topic(title, message, course);
    }
}
