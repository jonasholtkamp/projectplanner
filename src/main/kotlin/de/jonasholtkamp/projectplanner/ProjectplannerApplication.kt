package de.jonasholtkamp.projectplanner

import de.jonasholtkamp.projectplanner.model.Employee
import de.jonasholtkamp.projectplanner.repository.EmployeeRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.util.*

@SpringBootApplication
class ProjectplannerApplication

fun main(args: Array<String>) {
    runApplication<ProjectplannerApplication>(*args)
}


@Component
class CLR(val employeeRepository: EmployeeRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val list = listOf(
                Employee("Alex", "Strassberger"),
                Employee("Jonas", "Holtkamp", UUID.fromString("01dcd2e8-222d-4569-aa84-0fff274bd433")))
        employeeRepository.insert(list)
    }
}
