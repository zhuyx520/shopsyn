package com.qiyue.shopsyn.dao.primary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//import com.qiyue.shopsyn.annotation.GrabSource;
import com.qiyue.shopsyn.entity.ShopBusinessBean;
import com.qiyue.shopsyn.vo.request.ShopBusinessVo;

//@GrabSource("primarySqlSessionTemplate")
@Mapper
public interface ShopBusinessMapper {


	/**
     * 获取所有的信息
     * @return
     */
	List<ShopBusinessBean> getConditionMessage(@Param("shopBusinessVo") ShopBusinessVo shopBusinessVo);

    List<ShopBusinessBean> getPageConditionMessage(@Param("shopBusinessVo") ShopBusinessVo shopBusinessVo, @Param("startLine") Integer startLine, @Param("limit") Integer limit);

	List<ShopBusinessBean> getPageConditionMessageGroupByPhone(@Param("shopBusinessVo") ShopBusinessVo shopBusinessVo, @Param("startLine") Integer startLine, @Param("limit") Integer limit);

}
