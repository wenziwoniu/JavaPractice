package javaee.spring.test.controller;

import java.util.HashMap;
import java.util.Map;

import javaee.spring.test.entity.People;
import javaee.spring.test.pojo.CommonQuery;
import javaee.spring.test.pojo.PageObject;
import javaee.spring.test.pojo.ReponseResult;
import javaee.spring.test.service.IPeopleService;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "people")
public class PeopleController {
	
	@Resource(name = "PeopleServiceImpl")
	private IPeopleService peopleService;

	@RequestMapping(value = "redirect")
	public ModelAndView selectPeople(CommonQuery commonQuery, People people) {
		PageObject<People> pageObject = new PageObject<>();
		if (commonQuery.getNumPerPage() < 1) {
			commonQuery.setNumPerPage(5);
		}
		pageObject = peopleService.selectPeoples(people, commonQuery);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pages", pageObject);
		map.put("query", people);
		return new ModelAndView("dwz/table", map);
		
	}
	
	@RequestMapping(value = "savePeople")
	public ModelAndView savePopple(People people) {
		ModelAndView mav = new ModelAndView("dwz/ajaxDone");
		mav.addObject("statusCode", "200");
		mav.addObject("message", "成功");
		mav.addObject("forwardUrl", "");
		mav.addObject("callbackType", "closeCurrent");
		mav.addObject("rel", "peopleAdd");
		return mav;
//		ReponseResult reponseResult = new ReponseResult();
//		reponseResult.setCallbackType("closeCurrent");
//		reponseResult.setMessage("w");
//		reponseResult.setStatusCode("200");
//		reponseResult.setRel("peopleAdd");
//		return reponseResult;
	}
}
