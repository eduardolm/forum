package br.com.alura.forum.service;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CourseService {

    private final CourseRepository repository;

    public Course findCourseByName(String name) {
        return repository.findCourseByName(name);
    }
}
