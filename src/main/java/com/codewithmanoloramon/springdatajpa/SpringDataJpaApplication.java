package com.codewithmanoloramon.springdatajpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	//TODO: Create Repository
	@Bean
	CommandLineRunner commandLineRunner(StudentRepositor studentRepositor){
		return args -> {

//			//TODO: Section 1
//			Student1 andy = new Student1(
//				"Andy",
//				"Joe",
//				"andy-joe@gmail.com",
//				46
//			);
//			Student1 mandy = new Student1(
//					"Mandy",
//					"Jones",
//					"mandy-jones@gmail.com",
//					46
//			);
//
//			System.out.println("Adding andy and mandy");
//			studentRepositor.saveAll(
//					List.of(andy, mandy)
//			);
//
//			System.out.print("Number of Student:");
//			System.out.println(studentRepositor.count());
//
//			studentRepositor
//					.findById(2L)
//					.ifPresentOrElse(
//							System.out::println,
//							() -> System.out.println("Student with ID 2 not found")
//					);
//
//			studentRepositor
//					.findById(3L)
//					.ifPresentOrElse(
//							System.out::println,
//							() -> System.out.println("Student with ID 3 not found.")
//					);
//
//			System.out.println("Select all students");
//			List<Student1> student1s = studentRepositor.findAll();
//			student1s.forEach(System.out::println);
//
////			System.out.println("Delete andy");
////			studentRepositor.deleteById(1L);
//
//			System.out.println("Number of students");
//			System.out.println(studentRepositor.count());
//
//			// Implement from Student Repository
//			studentRepositor
//					.findStudent1ByEnail("mandy-jones@gmail.com")
//					.ifPresentOrElse(
//							System.out::println,
//							() -> System.out.println("Student with andy-joe@gmail.com not found!")
//					);
//
//			studentRepositor
//					.selectStudent1WhereFirstNameAndAgeGreaterOrEqual("Andy", 21)
//					.forEach(System.out::println);
//
//			studentRepositor
//					.selectStudentWhereFirstNameAndAgeGreaterOrEqualNative("Andy", 21)
//					.forEach(System.out::println);
//
//
//			System.out.println("Delete Mandy 2");
//			System.out.println(studentRepositor.deleteStudent1ById(2L));
			// Section 2 - Faker
			generateRandomStudents(studentRepositor);
		};
	}

	private void generateRandomStudents(StudentRepositor studentRepositor) {
		Faker faker = new Faker();
		for (int i = 0; i < 20; i++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s@therafits.com", firstName, lastName);
			Student1 student = new Student1(
				firstName,
				lastName,
				email,
				faker.number().numberBetween(17, 55)
			);
			studentRepositor.save(student);
		}
	}
}
