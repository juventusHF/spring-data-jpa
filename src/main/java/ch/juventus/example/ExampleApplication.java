package ch.juventus.example;

import ch.juventus.example.data.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

    @Component
    class initRepositoryCLR implements CommandLineRunner {

        private final DepartmentRepository departmentRepository;
        private final RoleRepository roleRepository;

        @Autowired
        public initRepositoryCLR(DepartmentRepository departmentRepository,
                                 RoleRepository roleRepository) {
            this.departmentRepository = departmentRepository;
            this.roleRepository = roleRepository;
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
