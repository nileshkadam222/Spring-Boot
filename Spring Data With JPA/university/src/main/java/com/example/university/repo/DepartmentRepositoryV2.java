package com.example.university.repo;

import com.example.university.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DataSource Management for the Departments at the University.
 *
 * Created by maryellenbowman
 */
public interface DepartmentRepositoryV2 extends JpaRepository<Department, Integer> {
	public default String getMyName() {
		return "nilesh";
	}
}
