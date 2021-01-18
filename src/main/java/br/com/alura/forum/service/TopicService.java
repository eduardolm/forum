package br.com.alura.forum.service;

import br.com.alura.forum.controller.request.TopicRequest;
import br.com.alura.forum.controller.request.TopicUpdateRequest;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TopicService {

    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;

    public Page<Topic> findAll(Pageable pagination) {

        return topicRepository.findAll(pagination);
    }

    public Page<Topic> findByCourseName(String courseName, Pageable pagination) {
        return topicRepository.findByCourse_Name(courseName, pagination);
    }

    public Optional<Topic> create(TopicRequest topicRequest) {
        Topic topic = topicRequest.convertTopicRequestToTopic(courseRepository);
        topicRepository.save(topic);
        return topicRepository.findById(topic.getId());
    }

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    public Optional<Topic> update(Long id, TopicUpdateRequest topicUpdateRequest) {
        Topic topicToUpdate = topicUpdateRequest.convertTopicUpdateRequestToTopic(id, topicRepository);
        topicRepository.save(topicToUpdate);
        return topicRepository.findById(id);
    }

    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}
