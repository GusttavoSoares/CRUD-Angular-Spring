package com.ifsp.crudspring.repository;

import com.ifsp.crudspring.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long >  { // Entidade, tipo do id
    
}
