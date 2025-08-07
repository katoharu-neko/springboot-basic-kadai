package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		
		return "contactFormView";
	}
	
	@PostMapping("/form")
	public String valForm(Model model,
			@Validated ContactForm form, BindingResult result) {
		//バリデーションエラーがあったら終了
		if(result.hasErrors()) {
			return "contactFormView";
		}
	//バリデーションに問題がなければ確認画面へ
	model.addAttribute("contactForm", form); //---追加
	return "confirmView";
	}
	

}
