package com.qiyue.shopsyn.controller;

import java.io.IOException;
import java.util.*;

import javax.annotation.Resource;

import com.qiyue.shopsyn.util.DateTimeUtil;
import com.qiyue.shopsyn.util.ExcelExportUtils;
import com.qiyue.shopsyn.vo.response.ShopBusinessExportResponse;
import com.qiyue.shopsyn.vo.response.ShopBusinessResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import com.qiyue.shopsyn.entity.ShopBusinessBean;
import com.qiyue.shopsyn.service.ShopBusinessService;
import com.qiyue.shopsyn.util.GsonUtil;
import com.qiyue.shopsyn.vo.request.ShopBusinessVo;
import com.qiyue.shopsyn.vo.response.Response;

@RestController
@RequestMapping(value = "shopBusiness")
public class ShopDataBusinessController {

    private static final Logger log = LogManager.getLogger(ShopDataBusinessController.class);

    @Resource
    private ShopBusinessService shopBusinessService;

    @RequestMapping(value = "data", method = {RequestMethod.GET})            // 测试使用
    public Response data(@RequestParam Map<String, String> params) {
        ShopBusinessVo shopBusinessVo = new ShopBusinessVo();
        Date[] dateArr = new Date[2];
        try {
            dateArr = DateTimeUtil.getDayStartAndEnd(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String startTime = DateTimeUtil.formatTime(dateArr[0], DateTimeUtil.yyyyMMddHHmmss);
        String endTime = DateTimeUtil.formatTime(dateArr[1], DateTimeUtil.yyyyMMddHHmmss);

        shopBusinessVo.setGrabtimeS(params.getOrDefault("grabtimeS", startTime));
        shopBusinessVo.setGrabtimeE(params.getOrDefault("grabtimeE", endTime));
        shopBusinessVo.setCity(params.getOrDefault("city", "上海"));
        shopBusinessVo.setPage(Integer.valueOf(params.getOrDefault("page", "1")));
        shopBusinessVo.setLimit(Integer.valueOf(params.getOrDefault("limit", "10")));

        List<ShopBusinessBean> conditionList = shopBusinessService.getConditionMessage(shopBusinessVo);
        List<ShopBusinessBean> pageList = shopBusinessService.getPageConditionMessage(shopBusinessVo, shopBusinessVo.getPage(), shopBusinessVo.getLimit());
        log.info("list size=" + conditionList.size() + "  current list info=" + GsonUtil.toJson(pageList));
        return Response.response(0, conditionList.size(), "OK", pageList);
    }

    @RequestMapping(value = "export", method = {RequestMethod.GET})
    public Response export(@RequestParam Map<String, String> params){
        ShopBusinessVo shopBusinessVo = new ShopBusinessVo();
        Date[] dateArr = new Date[2];
        try {
            dateArr = DateTimeUtil.getDayStartAndEnd(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String startTime = DateTimeUtil.formatTime(dateArr[0], DateTimeUtil.yyyyMMddHHmmss);
        String endTime = DateTimeUtil.formatTime(dateArr[1], DateTimeUtil.yyyyMMddHHmmss);

        shopBusinessVo.setGrabtimeS(params.getOrDefault("grabtimeS", startTime));
        shopBusinessVo.setGrabtimeE(params.getOrDefault("grabtimeE", endTime));
        shopBusinessVo.setCity(params.getOrDefault("city", "上海"));

        log.info("从库存中导出商铺生意转让数据，请求参数{}", GsonUtil.toJson(shopBusinessVo));
        List<ShopBusinessBean> conditionList = shopBusinessService.getConditionMessage(shopBusinessVo);
        if(conditionList == null || conditionList.size() == 0){
            return Response.error(0, "需要导出的数据为空");
        }

        List<ShopBusinessResponse> responseList = new ArrayList<>(conditionList.size());
        for(ShopBusinessBean businessBean : conditionList){
            ShopBusinessResponse shopBusinessResponse = new ShopBusinessResponse();
            BeanUtils.copyProperties(businessBean, shopBusinessResponse);
            responseList.add(shopBusinessResponse);
        }
        try {
            byte[] busiByte = ExcelExportUtils.export2Byte(responseList);
            String busiStr = Base64.getEncoder().encodeToString(busiByte);

            ShopBusinessExportResponse shopBusinessExportResponse = new ShopBusinessExportResponse();
            shopBusinessExportResponse.setCount(conditionList.size());
            shopBusinessExportResponse.setData(busiStr);
            return Response.contentOk(shopBusinessExportResponse);
        } catch (IOException e) {
            log.error("Excel数据导出错误", e.getMessage());
            return Response.error(500, "导出数据错误");
        }
    }

}
