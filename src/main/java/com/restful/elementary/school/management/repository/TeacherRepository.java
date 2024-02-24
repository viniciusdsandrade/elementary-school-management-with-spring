package com.restful.elementary.school.management.repository;

import com.restful.elementary.school.management.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.name LIKE %?1%")
    Page<Teacher> findByNameContainingIgnoreCase(String nome, Pageable pageable);
}
