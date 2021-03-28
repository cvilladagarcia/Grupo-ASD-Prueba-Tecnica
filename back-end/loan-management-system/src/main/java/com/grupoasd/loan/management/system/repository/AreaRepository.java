/**
 * 
 */
package com.grupoasd.loan.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupoasd.loan.management.system.model.Area;

/**
 * AreaRepository
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

}
