package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.WorkHistoryForm;

@Controller
public class UserController {
	/**
	 * 業務履歴登録画面に遷移する
	 *
	 */
	@RequestMapping("/user/input")
	public String input(Model model) {
		model.addAttribute("whForm", new WorkHistoryForm());
		return "user/input";
	}

	/**
	 * 業務履歴詳細画面に遷移する
	 *
	 */
	@RequestMapping("/user/output")
	public String output(@ModelAttribute WorkHistoryForm whForm, Model model) {
		model.addAttribute("whForm", whForm);
		return "user/output";
	}

	//    @RequestMapping("/user/admin")
	//    public String employeeList(Model model) {
	//        return "user/admin";
	//    }



}
