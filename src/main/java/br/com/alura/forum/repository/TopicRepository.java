package br.com.alura.forum.repository;

import br.com.alura.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    /**
     * findByCourse_Name:
     * @param courseName -> Attribute Name from Course entity
     *
     * findByCourseName
     * @param courseName -> If an attribute with this name exists in Topic class, it would be selected instead of
     * the Name attribute inside Course class (via relationship)
     * @return
     */
    List<Topic> findByCourse_Name(String courseName); // Usando o nome como findByCourse_Name o spring automaticamente faz a query

}
