package total.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import total.service.GreetService;
import total.service.memberService;

@Controller
@RequestMapping
public class NavController {
	@Autowired
	GreetService greetService;
	@Autowired
	memberService memberService;
	
	@RequestMapping(path="/join",method=RequestMethod.GET)
	public String joinGetHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "join";
	}
	@RequestMapping(path="/join",method=RequestMethod.POST)
	public String joinPostHandle(Model model, @RequestParam String id, @RequestParam String email, @RequestParam String pw ,HttpSession session) {
		Map map = new HashMap<>();
		map.put("id", id);
		map.put("email", email);
		map.put("password", pw);
		if(memberService.create(map)) {
			session.setAttribute("logon", id);
			return "redirect:/index";
		}else {
			model.addAttribute("res",false);
			return "join";
		}
		
		
	}
	
	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String loginHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "login";
	}
	
}
