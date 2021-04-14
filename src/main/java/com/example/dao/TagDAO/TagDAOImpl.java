package com.example.dao.TagDAO;

import com.example.model.Tag;
import com.example.model.TagColor;
import com.example.model.Task;
import com.example.repository.TagRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAllFromRepository() {
        return tagRepository.findAllEager();
    }

    @Override
    public Tag findTagById(@PathVariable Long id) {
        return tagRepository.findTagById(id);
    }

    @Override
    public Tag findTagByName(@PathVariable String name) {
        return tagRepository.findTagByName(name);
    }

    @Override
    public String postTagsFromRepository() {
        Tag tag1 = new Tag("angular", TagColor.BLUE);
        Tag tag2 = new Tag("hibernate", TagColor.YELLOW);
        Tag tag3 = new Tag("spring", TagColor.RED);
        Tag tag4 = new Tag("mockito", TagColor.GREEN);
        Tag tag5 = new Tag("mockito2", TagColor.GREEN);

        Task task1 = new Task("angular project with spring", "angular front end and spring in back end", false, LocalDate.of(2022,04,01));
        Task task2 = new Task("hibernate project with mockito", "hibernate project using mockito for testing", false, LocalDate.of(2021,03,31));

        task1.getTag().add(tag1);
        task1.getTag().add(tag3);
        task2.getTag().add(tag2);
        task2.getTag().add(tag4);
        task2.getTag().add(tag5);

        tag1.getTasks().add(task1);
        tag2.getTasks().add(task2);
        tag3.getTasks().add(task1);
        tag4.getTasks().add(task2);
        tag5.getTasks().add(task2);

        manager.persist(task1);
        manager.persist(task2);

        if(tagRepository.findTagByName(tag1.getName()) == null){
            manager.persist(tag1);

        }else{
            return "tag already exists";
        }
        if(tagRepository.findTagByName(tag2.getName()) == null){
            manager.persist(tag2);
        }else{
            return "tag already exists";
        }
        if(tagRepository.findTagByName(tag3.getName()) == null){
            manager.persist(tag3);
        }else{
            return "tag already exists";
        }
        if(tagRepository.findTagByName(tag4.getName()) == null){
            manager.persist(tag4);
        }else{
            return "tag already exists";
        }
        if(tagRepository.findTagByName(tag5.getName()) == null){
            manager.persist(tag5);
        }else{
            return "tag already exists";
        }

        manager.flush();
        return "tags inserted succesfuly";
    }

    @Override
    public void updateTag(Long id) {
        this.tagRepository.updateTag(id);
    }

    @Override
    public List<Tag> findTagsByColor(@PathVariable TagColor color) {
        return this.tagRepository.findTagByColor(color);
    }

}

