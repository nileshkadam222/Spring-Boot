package com.example.demo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
  
@Service
public class StudentService
{
    @Cacheable("student")
	//@CachePut("student")
    public Student getStudentByID(String id)
    {
    	System.out.println("called");
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
 
        return new Student(id,"Sajal" ,"V");
    }
    @CacheEvict(value="student", allEntries=true)
    public void  removeValues() {
    	System.out.println("removed");
     }
}