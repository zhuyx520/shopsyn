package com.qiyue.shopsyn.service;

import java.util.List;

import com.qiyue.shopsyn.entity.ShopBean;
import com.qiyue.shopsyn.vo.request.ShopVo;

public interface ShopService {

    /**
     * 获取所有的信息
     * @return
     */
    List<ShopBean> getConditionMessage(ShopVo shopVo);

    List<ShopBean> getPageConditionMessage(ShopVo shopVo, Integer page, Integer limit);

    List<ShopBean> getPageConditionMessageGroupByPhone(ShopVo shopVo, Integer page, Integer limit);

}

