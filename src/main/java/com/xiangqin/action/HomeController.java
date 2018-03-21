package com.xiangqin.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
import com.xiangqin.action.base.BaseController;
import com.xiangqin.domain.dto.WeiXinDto;
import com.xiangqin.service.WeiXinService;

@Controller
public class HomeController extends BaseController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private WeiXinService weiXinService;

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) throws Exception {
		WeiXinDto dto = weiXinService.getSignature();
		model.addAttribute("weiXinDto", dto);
		return "/app/index";
	}
	
/*	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(HttpServletResponse response, Dict dict) throws IOException {
		if (dict.getId() != null) {
			iDict.updateDict(dict);
		} else {
			iDict.addDict(dict);
		}
		Result result = new Result(1, "保存成功，请刷新后再查看");
		writeJSON(response, result);
	}*/
}
