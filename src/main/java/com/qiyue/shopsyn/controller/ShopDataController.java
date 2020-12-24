package com.qiyue.shopsyn.controller;

import java.io.IOException;
import java.util.*;

import javax.annotation.Resource;

import com.qiyue.shopsyn.util.DateTimeUtil;
import com.qiyue.shopsyn.util.ExcelExportUtils;
import com.qiyue.shopsyn.vo.request.ShopVo;
import com.qiyue.shopsyn.vo.response.ShopBusinessExportResponse;
import com.qiyue.shopsyn.vo.response.ShopResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import com.qiyue.shopsyn.entity.ShopBean;
import com.qiyue.shopsyn.service.ShopService;
import com.qiyue.shopsyn.util.GsonUtil;
import com.qiyue.shopsyn.vo.response.Response;

@RestController
@RequestMapping(value = "shop")
public class ShopDataController {

    private static final Logger log = LogManager.getLogger(ShopDataController.class);

    @Resource
    private ShopService shopService;

    @RequestMapping(value = "data", method = {RequestMethod.GET})            // 测试使用
    public Response data(@RequestParam Map<String, String> params) {
        ShopVo shopVo = new ShopVo();
        Date[] dateArr = new Date[2];
        try {
            dateArr = DateTimeUtil.getDayStartAndEnd(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String startTime = DateTimeUtil.formatTime(dateArr[0], DateTimeUtil.yyyyMMddHHmmss);
        String endTime = DateTimeUtil.formatTime(dateArr[1], DateTimeUtil.yyyyMMddHHmmss);

        shopVo.setGrabtimeS(params.getOrDefault("grabtimeS", startTime));
        shopVo.setGrabtimeE(params.getOrDefault("grabtimeE", endTime));
        shopVo.setCity(params.getOrDefault("city", "上海"));
        shopVo.setPage(Integer.valueOf(params.getOrDefault("page", "1")));
        shopVo.setLimit(Integer.valueOf(params.getOrDefault("limit", "10")));

        List<ShopBean> conditionList = shopService.getConditionMessage(shopVo);
        List<ShopBean> pageList = shopService.getPageConditionMessage(shopVo, shopVo.getPage(), shopVo.getLimit());
        log.info("list size=" + conditionList.size() + "  current list info=" + GsonUtil.toJson(pageList));
        return Response.response(0, conditionList.size(), "OK", pageList);
    }

    @RequestMapping(value = "export", method = {RequestMethod.GET})
    public Response export(@RequestParam Map<String, String> params){
        ShopVo shopVo = new ShopVo();
        Date[] dateArr = new Date[2];
        try {
            dateArr = DateTimeUtil.getDayStartAndEnd(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String startTime = DateTimeUtil.formatTime(dateArr[0], DateTimeUtil.yyyyMMddHHmmss);
        String endTime = DateTimeUtil.formatTime(dateArr[1], DateTimeUtil.yyyyMMddHHmmss);

        shopVo.setGrabtimeS(params.getOrDefault("grabtimeS", startTime));
        shopVo.setGrabtimeE(params.getOrDefault("grabtimeE", endTime));
        shopVo.setCity(params.getOrDefault("city", "上海"));

        log.info("从库存中导出商铺出租出售数据，请求参数{}", GsonUtil.toJson(shopVo));
        List<ShopBean> conditionList = shopService.getConditionMessage(shopVo);
        if(conditionList == null || conditionList.size() == 0){
            return Response.error(0, "需要导出的数据为空");
        }

        List<ShopResponse> responseList = new ArrayList<>(conditionList.size());
        for(ShopBean shopBean : conditionList){
            ShopResponse shopResponse = new ShopResponse();
            BeanUtils.copyProperties(shopBean, shopResponse);
            responseList.add(shopResponse);
        }
        try {
            byte[] shopByte = ExcelExportUtils.export2Byte(responseList);
            String shopStr = Base64.getEncoder().encodeToString(shopByte);

            ShopBusinessExportResponse shopBusinessExportResponse = new ShopBusinessExportResponse();
            shopBusinessExportResponse.setCount(responseList.size());
            shopBusinessExportResponse.setData(shopStr);
            return Response.contentOk(shopBusinessExportResponse);
        } catch (IOException e) {
            log.error("Excel数据导出错误", e.getMessage());
            return Response.error(500, "导出数据错误");
        }
    }

}
