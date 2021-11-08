package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

/**
 * 社員情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {

	/**
	 * 社員情報 Repository
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 社員情報 全検索
	 * @return 検索結果
	 */
	public List<Employee> searchAll() {
		return employeeRepository.findAll();
	}

	//	/**
	//	 * 社員情報 Mapper
	//	 */
	//	@Autowired
	//	private EmployeeMapper employeeMapper;
	//
	//	/**
	//	 * 社員情報 Repository
	//	 */
	//	@Autowired
	//	private EmployeeRepository employeeRepository;
	//
	//	/**
	//	 * 社員情報検索
	//	 * @param employeeSearchRequest リクエストデータ
	//	 * @return 検索結果
	//	 */
	//	public Employee search(EmployeeSearchRequest employeeSearchRequest) {
	//		return employeeMapper.search(employeeSearchRequest);
	//	}
	//

	/**
	 * 社員情報 主キー検索
	 * @return 検索結果
	 */
	public Employee findById(Long id) {
		return employeeRepository.findById(id).get();
	}

	/**
	 * 社員情報 新規登録
	 * @param employee 社員情報
	 */
	public void create(EmployeeRequest employeeRequest) {
		Date now = new Date();
		Employee employee = new Employee();
		employee.setName(employeeRequest.getName());
		employee.setAddress(employeeRequest.getAddress());
		employee.setPhone(employeeRequest.getPhone());
		employee.setCreateDate(now);
		employee.setUpdateDate(now);
		employeeRepository.save(employee);
	}

//	/**
//	 * 社員情報 物理削除
//	 * @param id 社員ID
//	 */
//	public void delete(Long id) {
//		Employee employee = findById(id);
//		employeeRepository.delete(employee);
//	}
	//
	//	/**
	//	 * 社員情報 更新
	//	 * @param employee 社員情報
	//	 */
	//	public void update(EmployeeUpdateRequest employeeUpdateRequest) {
	//
	//		Employee employee = findById(employeeUpdateRequest.getId());
	//		employee.setAddress(employeeUpdateRequest.getAddress());
	//		employee.setName(employeeUpdateRequest.getName());
	//		employee.setPhone(employeeUpdateRequest.getPhone());
	//		employee.setUpdateDate(new Date());
	//	    employeeRepository.save(employee);
	//	}
}
