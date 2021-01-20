package br.com.alura.forum.repository;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void shouldLoadCourseWhenFindByName() {
        String courseName = "HTML 5";

        Course html5 = new Course();
        html5.setName(courseName);
        html5.setCategory("Programação");
        em.persist(html5);

        Course course = repository.findCourseByName(courseName);

        assertNotNull(course);
        assertEquals(courseName, course.getName());
    }

    @Test
    public void shouldNotLoadCourseIfNameDoesNotExist() {
        String courseName = "JPA";
        Course course = repository.findCourseByName(courseName);

        assertNull(course);
    }
}
