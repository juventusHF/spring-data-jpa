package ch.juventus.example;

import ch.juventus.example.data.Department;
import ch.juventus.example.data.DepartmentRepository;
import ch.juventus.example.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

    @Component
    class InitRepositoryCLR implements CommandLineRunner {

        private final DepartmentRepository departmentRepository;

        @Autowired
        public InitRepositoryCLR(DepartmentRepository departmentRepository) {
            this.departmentRepository = departmentRepository;
        }

        @Override
        public void run(String... strings) throws Exception {
            Department accounting = new Department("Accounting");
            accounting.addEmployee(new Employee("Tim", "Taylor"));
            accounting.addEmployee(new Employee("Al", "Borland"));
            accounting.addEmployee(new Employee("Wilson", "Wilson"));
            accounting.addEmployee(new Employee("Bob", "Vila"));
            departmentRepository.save(accounting);
        }
    }


}
