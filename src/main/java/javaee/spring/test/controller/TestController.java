package javaee.spring.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaee.spring.test.entity.Student;
import javaee.spring.test.pojo.Message;
import javaee.spring.test.pojo.PageObject;
import javaee.spring.test.pojo.CommonQuery;
import javaee.spring.test.service.ITestService;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/class")
public class TestController {
	
	@Resource(name = "TestServiceImpl") 
	private ITestService testService;
	
	@RequestMapping("/redirect")
	public ModelAndView helloWorld(CommonQuery query){
		PageObject<Student> pageObject = new PageObject<Student>();
		List<Student> list = testService.findAllStudent();
		pageObject.setList(list);
		pageObject.setTotalCount(2L);
		return new ModelAndView("dwz/table", "pages", pageObject);
	}
	
	@RequestMapping("/saveMethod")
	public ModelAndView saveStudent() throws Exception{
		Student entity = new Student();
		entity.setStudentName("test1");
//		entity.setVersion(1);
//		testService.saveStudent(entity);
//		Student enStudent = new Student();
//		enStudent.setStudentName("tesssssssssssssssssssssssssssssssssssss");
//		testService.saveStudent(enStudent);
		List<Student> students = new ArrayList<Student>();
		students.add(entity);
//		students.add(enStudent);
//		testService.saveStudent(students);
		testService.insertStudents(students);
//		testService.insertStudent(enStudent);
		String message = "Hello World, Spring 3.0!";
		return new ModelAndView("hello", "message", message);
	}
	
	@RequestMapping("/findData")
	@ResponseBody
	public Map<Object, Object> findStudents(String name) {
		Map<Object, Object> rec = new HashMap<Object, Object>();
//		List<Student> list = testService.findAllStudent();
//		System.out.println("agc");
//		List<Student> list2 = testService.findAllStudent();
//		Long userId = 205L;
//		Student list = testService.findStudent(userId);
		return rec;
	}

	@RequestMapping("/lostUpdate1")
	@ResponseBody
	public void lostUpdate1() throws InterruptedException {
		testService.lostUpdate1(null);
	}
	
	@RequestMapping("/lostUpdate2")
	@ResponseBody
	public void lostUpdate2() {
		testService.lostUpdate2(null);
	}
	
	@RequestMapping("/dirtyRead1")
	public void dirtyRead1() {
		testService.dirtyRead1();
	}
	
	@RequestMapping("/dirtyRead2")
	public void dirtyRead2() {
		testService.dirtyRead2();
	}
	
	@RequestMapping("/phantomRead1")
	@ResponseBody
	public void phantomRead1() {
		testService.phantomRead1();
	}
	
	@RequestMapping("/phantomRead2")
	@ResponseBody
	public void phantomRead2() {
		testService.phantomRead2();
	}
	
	@RequestMapping("/unrepeatedRead1")
	@ResponseBody
	public void unrepeatedRead1() {
		testService.unrepeatedRead1();
	}
	
	@RequestMapping("/unrepeatedRead2")
	@ResponseBody
	public void unrepeatedRead2() {
		testService.unrepeatedRead2();
	}
	
	@RequestMapping("/persist")
	@ResponseBody
	public void persist() {
		testService.persist();
	}
	
	@RequestMapping("/merge")
	@ResponseBody
	public void merge() {
		testService.merge();
	}
	
	@RequestMapping("/mybatisUpdate")
	@ResponseBody
	public void mybatisUpdate() {
		testService.mybatisUpdate();
	}
	
	@RequestMapping("/mybatisInsert")
	@ResponseBody
	public void mybatisInsert() {
		testService.mybatisInsert();
	}
	
	@RequestMapping("/scene21")
	@ResponseBody
	public void scene21() {
		testService.scene21();
	}
	
	@RequestMapping("/scene22")
	@ResponseBody
	public void scene22() {
		testService.scene22();
	}
}
