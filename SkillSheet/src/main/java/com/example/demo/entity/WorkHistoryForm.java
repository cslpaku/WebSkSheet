package com.example.demo.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class WorkHistoryForm {

	// 社員番号
	@Getter
	@Setter
	private String employeeNumber;

	// 年齢
	@Getter
	@Setter
	private String age;

	// 性別
	@Getter
	@Setter
	private String sex;

	// 入社年月日_年
	@Getter
	@Setter
	private String dateEmploymentYear;

	// 入社年月日_月
	@Getter
	@Setter
	private String dateEmploymentMonth;

	// 入社年月日_日
	@Getter
	@Setter
	private String dateEmploymentDay;

	// 確認チェック
    @Getter
    @Setter
    private String checked;

    // 入社年月日_月のMapオブジェクト
    public Map<String,String> getMonthItems(){
    	Map<String,String> monthMap = new LinkedHashMap<String, String>();
    	for (int i = 1; i <= 12; i++) {
    		monthMap.put(String.valueOf(i), String.valueOf(i));
    	}
    	return monthMap;
    }

    // 入社年月日_日のMapオブジェクト
    public Map<String,String> getDayItems(){
	    Map<String, String> dayMap = new LinkedHashMap<String, String>();
	    for(int i = 1; i <= 31; i++){
	        dayMap.put(String.valueOf(i), String.valueOf(i));
	    }
	    return dayMap;

    }

    // 性別のMapオブジェクト
    public Map<String,String> getSexItems(){
        Map<String, String> sexMap = new LinkedHashMap<String, String>();
        sexMap.put("1", "男");
        sexMap.put("2", "女");
        return sexMap;
    }
}
