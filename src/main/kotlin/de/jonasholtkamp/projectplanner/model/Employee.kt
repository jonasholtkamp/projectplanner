package de.jonasholtkamp.projectplanner.model

import org.springframework.data.annotation.Id
import java.util.*

/**
 *
 * @author jholtkamp
 */
data class Employee(val firstName: String, val lastName: String, @Id val id: UUID = UUID.randomUUID()) {

}