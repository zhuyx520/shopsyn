package com.qiyue.shopsyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiyue.shopsyn.dao.primary.ShopMapper;
import com.qiyue.shopsyn.entity.ShopBean;
import com.qiyue.shopsyn.service.ShopService;
import com.qiyue.shopsyn.vo.request.ShopVo;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopMapper;

	@Override
	public List<ShopBean> getConditionMessage(ShopVo shopVo) {
		 return shopMapper.getConditionMessage(shopVo);
	}

	@Override
	public List<ShopBean> getPageConditionMessage(ShopVo shopVo,Integer page,Integer limit) {
		int startLine = (page - 1) * limit;									// 开始行数
		List<ShopBean> list = shopMapper.getPageConditionMessage(shopVo,startLine,limit);
		return list;
	}

	@Override
	public List<ShopBean> getPageConditionMessageGroupByPhone(ShopVo shopVo,Integer page,Integer limit) {
		int startLine = (page - 1) * limit;									// 开始行数
		List<ShopBean> list = shopMapper.getPageConditionMessageGroupByPhone(shopVo,startLine,limit);
		return list;
	}

}
