package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.EmployeeSearchRequest;
import com.example.demo.entity.Employee;

/**
 * 社員情報 Mapper
 */
@Mapper
public interface EmployeeMapper {

	/**
     * 社員情報検索
     *
     */
    Employee search(EmployeeSearchRequest employee);
}
