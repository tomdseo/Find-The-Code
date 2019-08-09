package com.tommy.findTheCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("")
	public String indexPage1() {
		return "index.jsp";
	}
	
	@RequestMapping("/")
	public String indexPage2() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/checkCode", method=RequestMethod.POST)
	public String codeAction(@RequestParam(value="codeInput") String codeInput) {
		System.out.println(codeInput);
		if(codeInput.equals("bushido")) {
			return "redirect:/code";
		}
		return "redirect:/createError";
	}
	
	@RequestMapping("/createError")
	public String flashMessage(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("invalid", "You must train harder!");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String codePage() {
		return "code.jsp";
	}

}
