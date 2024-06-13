package com.icss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("emp")
@Scope("singleton")
public class Employee {

	@Value("100")
	private int eid;
	@Value("张三")
	private String ename;
	@Value("10000")
	private double esalary;
}
