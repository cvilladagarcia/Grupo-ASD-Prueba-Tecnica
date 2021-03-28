/**
 * 
 */
package com.grupoasd.loan.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupoasd.loan.management.system.model.Person;

/**
 * EmployeeRepository
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 26/03/2021
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
