package com.example.university;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.DepartmentRepositoryV2;

interface IFooBar {
	public default <T extends DepartmentRepository, X extends DepartmentRepositoryV2> T callMe() {
		return null;
	}
	

	
}

public class Test {

	@Autowired
	static DepartmentRepository departmentRepository;

	@Autowired
	static DepartmentRepositoryV2 departmentRepositoryV2;

	public static void main(String[] args) {
		Map<Boolean, IFooBar> myHashTable = new HashMap();
		
		myHashTable.put(true, new IFooBar() {
			public DepartmentRepository callMe() {
				return teleport();
			}
		});
		
		myHashTable.put(true, new IFooBar() {
			public DepartmentRepositoryV2 callMe() {
				return showHelp();
			}
		});
		
		Boolean val = false;
		
		if(val.equals(true)){
			
		}else {
			
		}
		
		myHashTable.get(true).callMe();
		
		myHashTable.get(false)

	}

	protected static DepartmentRepository teleport() {
		return departmentRepository;

	}

	protected static DepartmentRepositoryV2 showHelp() {
		return departmentRepositoryV2;

	}

}
