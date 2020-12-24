package com.qiyue.shopsyn.dao.second;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//import com.qiyue.shopsyn.annotation.CustomerSource;
import com.qiyue.shopsyn.entity.QyReleaseShopsEntity;

//@CustomerSource("secondarySqlSessionTemplate")
@Mapper
public interface QyReleaseShopsMapper{

	QyReleaseShopsEntity queryObject(@Param("value") String phone);
	
	Integer save(QyReleaseShopsEntity entity);
	
	Integer update(QyReleaseShopsEntity entity);
}
