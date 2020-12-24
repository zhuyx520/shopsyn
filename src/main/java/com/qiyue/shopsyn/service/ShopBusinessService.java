package com.qiyue.shopsyn.service;

import java.util.List;

import com.qiyue.shopsyn.entity.ShopBusinessBean;
import com.qiyue.shopsyn.vo.request.ShopBusinessVo;

public interface ShopBusinessService {

    /**
     * 获取所有的信息
     * @return
     */
    List<ShopBusinessBean> getConditionMessage(ShopBusinessVo shopVo);

    List<ShopBusinessBean> getPageConditionMessage(ShopBusinessVo shopVo, Integer page, Integer limit);

    List<ShopBusinessBean> getPageConditionMessageGroupByPhone(ShopBusinessVo shopVo, Integer page, Integer limit);

}

