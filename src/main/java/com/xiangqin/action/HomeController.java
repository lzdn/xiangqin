package com.xiangqin.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiangqin.action.base.BaseController;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request) {
		return "/app/index";
	}
}
