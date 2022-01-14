package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	//List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145,"Core Java Course","this course contains Java backend course"));
//		list.add(new Course(4343,"Spring boot Course","this course contains Spring boot course"));
	}

	@Override
	public List<Course> getCourses() {
		//return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
	//	Course c = null;
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c;
		
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e ->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		
//		return course;
		courseDao.save(course);
		return course;

	}

	@Override
	public void deleteCourse(long courseId) {
		//list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}
