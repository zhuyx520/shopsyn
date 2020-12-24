package com.qiyue.shopsyn.job;

import javax.annotation.Resource;

import com.qiyue.shopsyn.vo.request.ShopBusinessVo;
import com.qiyue.shopsyn.vo.request.ShopVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qiyue.shopsyn.service.ShopUploadBusinessService;
import com.qiyue.shopsyn.service.ShopUploadService;
import com.qiyue.shopsyn.util.DateTimeUtil;
import com.qiyue.shopsyn.util.GsonUtil;
import com.qiyue.shopsyn.vo.response.Response;

import java.util.Date;

@Component
@Configurable
@EnableScheduling
public class ShopUploadTimer {

	private static final Logger log = LogManager.getLogger(ShopUploadTimer.class);

	@Resource
	private ShopUploadService shopUploadService;

	@Resource
	private ShopUploadBusinessService shopUploadBusinessService;

	//每30分钟执行一次,同步58商铺交易数据 到 商铺交易网。
	@Scheduled(cron = "0 */30 *  * * * ")
	public void processShopUploadList(){
		log.info("synchronization shop grab data (shop_upload) : time = " + DateTimeUtil.getCurrentTime());
		ShopVo shopVo = new ShopVo();
		Date startDate = DateTimeUtil.addMinute(new Date(), -30);
		String startTime = DateTimeUtil.formatTime(startDate, DateTimeUtil.yyyyMMddHHmmss);
		String endTime = DateTimeUtil.formatTime(new Date(), DateTimeUtil.yyyyMMddHHmmss);

		shopVo.setGrabtimeS(startTime);
		shopVo.setGrabtimeE(endTime);
		Response response = shopUploadService.uploadGrabShopMysql(shopVo);
		log.info(DateTimeUtil.getCurrentTime() + "返回信息：" + GsonUtil.toJson(response));
	}

	//每30分钟执行一次,同步58商铺交易数据 到 商铺交易网。
	@Scheduled(cron = "0 */30 *  * * * ")
	public void processShopUploadPlusList(){
		log.info("synchronization shop grab data (business_upload) : time = " + DateTimeUtil.getCurrentTime());
		ShopBusinessVo shopBusinessVo = new ShopBusinessVo();
		Date startDate = DateTimeUtil.addMinute(new Date(),-30);
		String startTime = DateTimeUtil.formatTime(startDate, DateTimeUtil.yyyyMMddHHmmss);
		String endTime = DateTimeUtil.formatTime(new Date(), DateTimeUtil.yyyyMMddHHmmss);

		shopBusinessVo.setGrabtimeS(startTime);
		shopBusinessVo.setGrabtimeE(endTime);
		Response response = shopUploadBusinessService.uploadGrabShopMysql(shopBusinessVo);
		log.info(DateTimeUtil.getCurrentTime() + "返回信息：" + GsonUtil.toJson(response));
	}

}
