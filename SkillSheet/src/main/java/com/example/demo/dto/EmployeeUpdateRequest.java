package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 社員情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class EmployeeUpdateRequest extends EmployeeRequest implements Serializable {

	/**
	 * 社員ID
	 */
	@NotNull
	private Long id;
}
