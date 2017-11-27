package com.ohio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ohio.exception.StudentNotFoundException;
import com.ohio.model.RecordCounter;
import com.ohio.model.Student;

@Service
public class StudentService {
	private List<Student> students;
	
	public StudentService(){
		students=new ArrayList<Student>(
				Arrays.asList(
				new Student(101,"Abebe","Kebede"),
				new Student(102,"Amanuel","Kahsay"),
				new Student(103,"Hagos","Berihu"),
				new Student(104,"Belay","Mehari"),
				new Student(107,"Melat","Mikre")				
				));
	}
	
	public List<Student> getAllStudents(){
		return students;
	}
	
	//Method to count the number of returned result sets
	public RecordCounter getAll(){
		RecordCounter recordCounter=new RecordCounter();
		recordCounter.setData(students);
		recordCounter.setNumResult(students.size());
		return recordCounter;
	}

	public Student getStudent(int studentId) throws StudentNotFoundException {
		
	Student matchingStudent= students.stream()
			             .filter(stud->stud.getStudentId()==studentId)
			             .findFirst().get();	
	 System.out.println("The studnet is: "+matchingStudent.getFirstName()+" "+matchingStudent.getLastName());
		
		Student student=null;
		for(Student s:students){
			if(s.getStudentId()==studentId){
				student=s;
				//return student;
				break;
			}
		
		}
		if(student==null) throw new StudentNotFoundException("Student not found");
		
	  return student;
	  
			  
	}

	
	public void updateStudent(int id,Student student) {
		
		students.stream().filter(st->st.getStudentId()==id)
						 .forEach(st-> {
							 			st.setFirstName(student.getFirstName());//updating
							 			st.setLastName(student.getLastName());//updating
							 			}
								 );
						 
		
		/*for(Student st:students){
			if(st.getStudentId()==id){
				st.setFirstName(student.getFirstName());
				st.setLastName(student.getLastName());
				return;
			}
		}*/
		
		
		/*for(int i=0;i<students.size();i++){
			Student st=students.get(i);
			if(st.getStudentId()==id){
				students.set(i, student);
				return;
			}
		}*/
		
	}

	public void addStudent(Student student) {
		
		students.add(student);
		
	}
}
