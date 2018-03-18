package de.jonasholtkamp.projectplanner.controller

import de.jonasholtkamp.projectplanner.model.EmployeeNotFoundException
import de.jonasholtkamp.projectplanner.repository.EmployeeRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.util.*


/**
 * @author jholtkamp
 */
@Controller
class EmployeeController(val employeeRepository: EmployeeRepository) {

    @GetMapping("/employee")
    fun greeting(@RequestParam id: UUID, model: Model): ModelAndView? {
        val employee = employeeRepository.findById(id)

        return employee
                .map { e -> ModelAndView("employee", mapOf(Pair("employee", e))) }
                .orElseThrow { EmployeeNotFoundException(id) }
    }
}
