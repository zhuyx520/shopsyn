package com.qiyue.shopsyn.dao.primary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//import com.qiyue.shopsyn.annotation.GrabSource;
import com.qiyue.shopsyn.entity.ShopBean;
import com.qiyue.shopsyn.vo.request.ShopVo;

@Mapper
public interface ShopMapper {


	/**
     * 获取所有的信息
     * @return
     */
	List<ShopBean> getConditionMessage(@Param("shopVo") ShopVo shopVo);

    List<ShopBean> getPageConditionMessage(@Param("shopVo") ShopVo shopVo, @Param("startLine") Integer startLine, @Param("limit") Integer limit);

	List<ShopBean> getPageConditionMessageGroupByPhone(@Param("shopVo") ShopVo shopVo, @Param("startLine") Integer startLine, @Param("limit") Integer limit);
}
