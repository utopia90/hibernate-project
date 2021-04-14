package com.example.repository;

import com.example.model.Tag;
import com.example.model.TagColor;
import com.example.model.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @EntityGraph(attributePaths = "id")
    @Query("SELECT e FROM Tag e")
    List<Tag> findAllEager();

    @EntityGraph(attributePaths = {"id"})
    @Query("SELECT e FROM Tag e where e.id = :id")
    Tag findTagById(@Param("id")Long id);

    @EntityGraph(attributePaths = {"name"})
    @Query("SELECT e FROM Tag e where e.name = :name")
    Tag findTagByName(@Param("name") String name);

    @EntityGraph(attributePaths = {"id"})
    @Modifying
    @Query("UPDATE Tag set name='tagNameUpdated' where id = :id")
    void updateTag(@Param("id")Long id);

    @EntityGraph(attributePaths = {"tagColor"})
    @Query("SELECT e FROM Tag e where e.tagColor = :color")
    List<Tag> findTagByColor(TagColor color);
}
