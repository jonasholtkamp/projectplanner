package de.jonasholtkamp.projectplanner

import de.jonasholtkamp.projectplanner.model.Employee
import de.jonasholtkamp.projectplanner.repository.EmployeeRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

/**
 *
 * @author jholtkamp
 */
@SpringBootTest
@RunWith(SpringRunner::class)
class DataLoadTest {

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @Test
    fun name() {
        val id = UUID.randomUUID()
        val employee = Employee("Jonas", "Holtkamp", id)
        employeeRepository.save(employee)

        val foundEmployees = employeeRepository.findAll()
        assertThat(foundEmployees).contains(employee)

        val foundEmployee = employeeRepository.findById(id)
        assertThat(foundEmployee.get()).isEqualTo(employee)
    }
}
