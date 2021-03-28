/**
 * 
 */
package com.grupoasd.loan.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoasd.loan.management.system.model.Loan;

/**
 * LoanRepository
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
