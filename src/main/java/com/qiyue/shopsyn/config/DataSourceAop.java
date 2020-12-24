package com.qiyue.shopsyn.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.qiyue.shopsyn.config.DataSourceType.DataBaseType;

@Aspect
@Component
public class DataSourceAop {
	@Before("execution(* com.qiyue.shopsyn.dao.primary.*.*(..))")
	public void setDataSource2test01() {
//		System.err.println("test01业务");
		DataSourceType.setDataBaseType(DataBaseType.PRIMARY01);
	}
	
	@Before("execution(* com.qiyue.shopsyn.dao.second.*.*(..))")
	public void setDataSource2test02() {
//		System.err.println("test02业务");
		DataSourceType.setDataBaseType(DataBaseType.SECONDARY02);
	}
}