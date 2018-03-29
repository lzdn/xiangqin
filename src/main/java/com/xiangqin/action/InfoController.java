package com.xiangqin.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiangqin.action.base.BaseController;
import com.xiangqin.domain.Person;
import com.xiangqin.service.PersonService;
import com.xiangqin.utils.Body;
import com.xiangqin.utils.Result;

@Controller
@RequestMapping("info")
public class InfoController extends BaseController {

	private static final Logger logger = Logger.getLogger(InfoController.class);

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void save(HttpServletResponse response, Person person) throws IOException {
		logger.error(person.toString());
		Result result = null;
		try {
			if(person.getId()==null) person.setCreateTime(new Date());
			person.setUpdateTime(new Date());
			Integer id = personService.addPerson(person);
			result = new Result(1, "保存成功!");
			Body body = new Body();
			body.setId(id);
			result.setBody(body);
		} catch (Exception e) {
			result = new Result(1, "保存失败!");
			logger.error("保存个人信息：" + e);
		}
		writeJSON(response, result);
	}

}
