package de.jonasholtkamp.projectplanner.repository

import de.jonasholtkamp.projectplanner.model.Employee
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

/**
 *
 * @author jholtkamp
 */
//@RepositoryRestResource(collectionResourceRel = "workers", path = "workers")
interface EmployeeRepository : MongoRepository<Employee, UUID> {

}