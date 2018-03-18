package de.jonasholtkamp.projectplanner.model

import java.util.*

class EmployeeNotFoundException(id: UUID) : Exception("Employee with id ${id} not found") {

}
