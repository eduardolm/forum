package br.com.alura.forum.controller;

import br.com.alura.forum.controller.request.TopicRequest;
import br.com.alura.forum.controller.request.TopicUpdateRequest;
import br.com.alura.forum.dto.TopicDetailsDto;
import br.com.alura.forum.dto.TopicDto;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.service.CourseService;
import br.com.alura.forum.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TopicController {

    private final TopicService topicService;
    private final CourseService courseService;

    @GetMapping
    public List<TopicDto> list(String courseName) {
        if (courseName == null) {
            List<Topic> topics = topicService.findAll();
            return TopicDto.convertTopicToTopicDto(topics);
        }
        else {
            List<Topic> topics = topicService.findByCourseName(courseName);
            return TopicDto.convertTopicToTopicDto(topics);
        }
    }

    @GetMapping("{id}")
    public TopicDetailsDto getById(@PathVariable() Long id) {
        Topic topic = topicService.findById(id).orElseThrow();
        return new TopicDetailsDto(topic);
    }

    @PostMapping
    public ResponseEntity<TopicDto> create(@RequestBody @Valid TopicRequest topicRequest, UriComponentsBuilder uriBuilder) {
        var response = topicService.create(topicRequest).orElseThrow();

        URI uri = uriBuilder.path("/api/v1/topics/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(response));
    }

    @PutMapping("{id}")
    public ResponseEntity<Topic> update(@PathVariable() Long id, @RequestBody @Valid TopicUpdateRequest topicUpdateRequest) {
        Topic topicToUpdate = topicService.update(id, topicUpdateRequest).orElseThrow();
        return ResponseEntity.ok(topicToUpdate);
    }
}
