package com.qiyue.shopsyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiyue.shopsyn.dao.primary.ShopBusinessMapper;
import com.qiyue.shopsyn.entity.ShopBusinessBean;
import com.qiyue.shopsyn.service.ShopBusinessService;
import com.qiyue.shopsyn.vo.request.ShopBusinessVo;

@Service
public class ShopBusinessServiceImpl implements ShopBusinessService {

	@Autowired
	private ShopBusinessMapper shopBusinessMapper;

	@Override
	public List<ShopBusinessBean> getConditionMessage(ShopBusinessVo shopVo) {
		 return shopBusinessMapper.getConditionMessage(shopVo);
	}

	@Override
	public List<ShopBusinessBean> getPageConditionMessage(ShopBusinessVo shopBusinessVo,Integer page,Integer limit) {
		int startLine = (page - 1) * limit;									// 开始行数
		List<ShopBusinessBean> list = shopBusinessMapper.getPageConditionMessage(shopBusinessVo,startLine,limit);
//		// 过滤中文字符
//		List<ShopBusinessBean> reslist = new ArrayList<ShopBusinessBean>();
//		for(ShopBusinessBean bean : list) {
//			String tmpTitle = bean.getTitle();
//			String title = ChinaCharUtil.getChinaChar(tmpTitle);
//			bean.setTitle(title);
//			reslist.add(bean);
//		}
		return list;
	}

	@Override
	public List<ShopBusinessBean> getPageConditionMessageGroupByPhone(ShopBusinessVo shopBusinessVo,Integer page,Integer limit) {
		int startLine = (page - 1) * limit;									// 开始行数
		List<ShopBusinessBean> list = shopBusinessMapper.getPageConditionMessageGroupByPhone(shopBusinessVo,startLine,limit);
//		// 过滤中文字符
//		List<ShopBusinessBean> reslist = new ArrayList<ShopBusinessBean>();
//		for(ShopBusinessBean bean : list) {
//			String tmpTitle = bean.getTitle();
//			String title = ChinaCharUtil.getChinaChar(tmpTitle);
//			bean.setTitle(title);
//			reslist.add(bean);
//		}
		return list;
	}
}
