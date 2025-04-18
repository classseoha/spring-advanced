package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // 투두와 연관된 유저를 한 번에 조인해서 가져옴 (내부적으로 LEFT JOIN FETCH t.user처럼 작동)
    @EntityGraph(attributePaths = {"user"})
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    // 투두와 연관된 유저를 한 번에 조인해서 가져옴 (내부적으로 LEFT JOIN FETCH t.user처럼 작동)
    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);

    int countById(Long todoId);
}
