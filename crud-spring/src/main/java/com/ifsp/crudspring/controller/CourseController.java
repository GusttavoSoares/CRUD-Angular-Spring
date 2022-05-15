package com.ifsp.crudspring.controller;

import java.util.List;

import com.ifsp.crudspring.model.Course;
import com.ifsp.crudspring.repository.CourseRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController // fala para o spring que essa classe contêm um end point, uma url que possibilita acessar a API
@RequestMapping ("/api/courses") // determina a url
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    
    // @RequestMapping(method = RequestMethod.GET)   
    @GetMapping
    public @ResponseBody List<Course> list(){
        return courseRepository.findAll();
    }

    @PostMapping // O ResponseEntity, além de mandar a resposta ele possibilita mudar o status Http
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){ // Spring recebe o payload do corpo do request e tenta mapear com a category e name do classe Course
       // System.out.println(course.getName());
       // return ResponseEntity.status(HttpStatus.CREATED)
        //.body(courseRepository.save(course));
        return courseRepository.save(course);
    }
}

