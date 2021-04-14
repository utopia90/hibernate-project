package com.example.controller;


import com.example.model.Tag;
import com.example.model.TagColor;
import com.example.model.Task;
import com.example.service.tagService.TagService;
import com.example.service.taskService.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {
    private final TagService tagService;
    private final Logger log = LoggerFactory.getLogger(TagController.class);

    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public List<Tag> findAll() {
        return tagService.findAllFromRepository();
    }
    @GetMapping("tags/id/{id}")
    public ResponseEntity<Tag> findTagById(@PathVariable Long id) {

        Tag tagOpt = tagService.findTagById(id);
        if( tagOpt != null){
            return ResponseEntity.ok().body(tagOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/tags/name/{name}")
    public ResponseEntity<Tag> findTagByName(@PathVariable String name) {

        Tag tagOpt = tagService.findTagByName(name);
        if( tagOpt != null){
            return ResponseEntity.ok().body(tagOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/tags/color/{color}")
    public ResponseEntity<List<Tag>> findTagByTagColor(@PathVariable TagColor color) {

        List<Tag> tagOpt = tagService.findTagByColor(color);
        if( tagOpt != null){
            return ResponseEntity.ok().body(tagOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/tags/post")
    public String  postTags(){
        return  tagService.postTagsFromRepository();
    }

    @PutMapping("/tags/update/{id}")
    public  ResponseEntity<Tag> updateTagById(@PathVariable("id") Long id) { log.debug("REST request to update a id{}", id);

        if(tagService.findTagById(id) == null){
            log.warn("updating tag without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            tagService.updateTagById(id);
            return ResponseEntity.ok().body(tagService.findTagById(id));
        }
    }
}
