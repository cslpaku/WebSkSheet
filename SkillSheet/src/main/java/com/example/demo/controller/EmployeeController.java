package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	/**
	 * 社員情報 Service
	 */
	@Autowired
	EmployeeService employeeService;

	/**
	 * 社員情報一覧画面を表示
	 * @param model Model
	 * @return 社員情報一覧画面
	 */
	@GetMapping(value = "/user/admin")
	public String displayList(Model model) {
		List<Employee> employeelist = employeeService.searchAll();
		model.addAttribute("employeelist", employeelist);
		return "user/admin";
	}

	/**
	 * 新規登録画面を表示
	 * @param model Model
	 * @return
	 */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("employeeRequest", new EmployeeRequest());
		return "user/add";
	}

	/**
	 * 新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return 社員情報一覧画面
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute EmployeeRequest employeeRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/add";
		}
		// 社員情報の登録
		employeeService.create(employeeRequest);
		return "redirect:/user/admin";
	}

	/**
	   * 社員情報詳細画面を表示
	   * @param id 表示するID
	   * @param model Model
	   * @return 社員情報詳細画面
	   */
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {

		Employee employee = employeeService.findById(id);
	    model.addAttribute("userData", employee);
	    return "user/detail";
	  }
}
