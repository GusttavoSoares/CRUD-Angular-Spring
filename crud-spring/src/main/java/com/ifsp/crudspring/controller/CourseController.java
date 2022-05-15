package com.ifsp.crudspring.controller;

import java.util.List;

import com.ifsp.crudspring.model.Course;
import com.ifsp.crudspring.repository.CourseRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController // fala para o spring que essa classe contêm um end point, uma url que possibilita acessar a API
@RequestMapping ("/api/courses") // determina a url
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    
    // @RequestMapping(method = RequestMethod.GET)   
    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }
}
