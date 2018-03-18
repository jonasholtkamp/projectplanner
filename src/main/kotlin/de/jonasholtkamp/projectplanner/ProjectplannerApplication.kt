package de.jonasholtkamp.projectplanner

import de.jonasholtkamp.projectplanner.model.Employee
import de.jonasholtkamp.projectplanner.repository.EmployeeRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@SpringBootApplication
class ProjectplannerApplication

val UUID_JONAS = UUID.fromString("01dcd2e8-222d-4569-aa84-0fff274bd433")

fun main(args: Array<String>) {
    runApplication<ProjectplannerApplication>(*args)
}

// Need a dedicated class here to have the provided bean available in tests
@Configuration
class TestStartUpConfiguration {

    @Bean
    fun init(employeeRepository: EmployeeRepository) = CommandLineRunner {
        val list = listOf(
                Employee("Alex", "Strassberger"),
                Employee("Jonas", "Holtkamp", UUID_JONAS))
        employeeRepository.insert(list)
    }
}
