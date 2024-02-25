package com.restful.elementary.school.management.repository;

import com.restful.elementary.school.management.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.email LIKE %?1%")
    Page<Student> findByEmailContainingIgnoreCase(String email, Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Student s WHERE s.cpf = ?1")
    boolean existsByCpf(String cpf);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Student s WHERE s.email = ?1")
    boolean existsByEmail(String email);
}
