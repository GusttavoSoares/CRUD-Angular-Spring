package com.ifsp.crudspring;

import com.ifsp.crudspring.model.Course;
import com.ifsp.crudspring.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	// tudo isso é a nível de exemplo, apenas para ter registros!
	@Bean // o spring vai gerenciar todo o ciclo de vida
	CommandLineRunner initDatabase(CourseRepository courseRepository){
			return args -> {
					courseRepository.deleteAll();

					Course c = new Course();
					// não precisa do id, pois ele é automaticamente gerado
					c.setName("Angular com Spring");
					c.setCategory("back-end");

					courseRepository.save(c);
			};
	}
}
