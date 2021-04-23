package com.example.demo.mvc;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class SampleController {
	
	@Autowired private LocaleResolver localeResolver;
	
	@RequestMapping("/samplePage")
	public String samplePage(HttpServletRequest request, HttpServletResponse respone, Model model) {
		String lang = request.getParameter("lang");
		if(lang != null) {
			Locale locale = new Locale(lang);
			localeResolver.setLocale(request, respone, locale);
		}
		return "/i18n/samplePage";
	}
	
}
