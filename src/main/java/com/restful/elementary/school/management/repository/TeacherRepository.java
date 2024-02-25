package com.restful.elementary.school.management.repository;

import com.restful.elementary.school.management.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.name LIKE %?1%")
    Page<Teacher> findByNameContainingIgnoreCase(String nome, Pageable pageable);

    @Query("SELECT t FROM Teacher t WHERE t.email LIKE %?1%")
    Page<Teacher> findByEmailContainingIgnoreCase(String email, Pageable page);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Teacher t WHERE t.cpf = ?1")
    boolean existsByCpf(String cpf);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Teacher t WHERE t.email = ?1")
    boolean existsByEmail(String email);
}
