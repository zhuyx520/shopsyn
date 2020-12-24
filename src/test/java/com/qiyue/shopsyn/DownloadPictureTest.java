package com.qiyue.shopsyn;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.qiyue.shopsyn.util.DateTimeUtil;
import com.qiyue.shopsyn.vo.request.ShopBusinessVo;
import com.qiyue.shopsyn.vo.request.ShopVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qiyue.shopsyn.cache.ShopCacheManager;
import com.qiyue.shopsyn.helper.ShopHelper;
import com.qiyue.shopsyn.service.ShopUploadBusinessService;
import com.qiyue.shopsyn.service.ShopUploadService;
import com.qiyue.shopsyn.service.impl.ShopUploadBusinessServiceImpl;
import com.qiyue.shopsyn.service.impl.ShopUploadServiceImpl;
import com.qiyue.shopsyn.util.ChinaCharUtil;
import com.qiyue.shopsyn.util.GsonUtil;
import com.qiyue.shopsyn.vo.response.Response;

import net.minidev.json.JSONObject;
import org.springframework.test.context.junit4.SpringRunner;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadPictureTest {
	
	@Resource
    private ShopUploadServiceImpl shopUploadService;

	@Resource
	private ShopHelper shopHelper;
	
	@Resource
	private ShopCacheManager shopCacheManager;
	
	@Resource
    private ShopUploadBusinessServiceImpl shopUploadBusinessService;
	
//	@Test
//	public void outputTest() {
//		List<String> input = new ArrayList<>();
//		input.add("E:/tempfile/input/t1/pic.jpg");
//		input.add("E:/tempfile/input/t1/pic_result.jpg");
//		List<String> res = shopUploadService.outputList(input);
//		System.out.println(GsonUtil.toJson(res));
//	}
	
//	@Test
//	public void pictureTest() {
//		String res = shopUploadService.uploadImage();
//		System.out.println("上传到商铺交易平台的路径：" + res);
//	}
	
//	@Test
//	public void uploadPicture() {
//		String imagePath = "D:/tempfile/p1/tiny/n_v2989acb7dbc1b4921a1b261e71489ec8b.jpg";
//		String res = shopCacheManager.uploadImage(imagePath);
//		System.out.println("上传后的路径：" + res);
//	}
	
//	@Test
//	public void dataTest() {
//		Response res = shopUploadService.uploadGrabShop();
//		System.out.println("上传到商铺交易平台的路径：" + GsonUtil.toJson(res));
//	}
	
//	@Test
//	public void strSubTest() {
//		String numDate = "20190101";
//		String strNum = numDate.substring(0,4) + "-" + numDate.substring(4,6) + "-" + numDate.substring(6,8);
//		System.out.println(strNum);
//	}
	
//	@Test
//	public void strSubTest1() {
//		String s1 = "03.01";
//		String s2 = "03";
//		String s3 = "03.02.01";
//		String str1 = s1.replace(".", "");
//		String str2 = s2.replace(".", "");
//		String str3 = s3.replace(".", "");
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(str3);
//	}
	
	@Test
	public void synShopPlusTest() {
		
//		Response response1 = shopUploadBusinessService.uploadGrabShop();	// 生意转让1
//		System.out.println(GsonUtil.toJson(response1));
		
//		Response response2 = shopUploadService.uploadGrabShop();		// 商铺发布2
//		System.out.println(GsonUtil.toJson(response2));

		String input = "124.8m";
		String area = input.split("m")[0];
		if(area.lastIndexOf(".") != -1){
			area = area.substring(0, area.lastIndexOf("."));
		}
		Integer cnt = Integer.valueOf(area);
		System.out.println(cnt);
		
//		// 批量下载测试完成
//		String imgUrl = "https://pic8.58cdn.com.cn/mobile/big/n_v240b0ea9c4fc748bd986e015d6582d103.jpg?w=640&h=480&crop=1";
//		List<String> list = shopUploadBusinessService.downloadImageList(imgUrl);
//		for(String str : list) {
//			System.out.println(str);
//		}
		
//		//  批量上传测试完成
//		List<String> list = new ArrayList<String>();
//		list.add("e:/tempfile/p1/big/n_v2c6bd3b1d0fdb4905bb51cc4a7cf85dab.jpg");
//		list.add("e:/tempfile/p1/big/n_v238054b3ac1e6454088c54b7c7ab0de81.jpg");
//		list.add("e:/tempfile/p1/big/n_v20517aa20b98042e29972bd2f15070562.jpg");
//		list.add("e:/tempfile/p1/big/n_v2a4551f8565e74e02b8eee88822854381.jpg");
//		String uploadStr = shopUploadBusinessService.uploadImageList(list);
//		System.out.println(uploadStr);
	}
	
	@Test
	public void synShopMysqlTest() {

		Date startDate = DateTimeUtil.addMinute(new Date(),-30);
		ShopBusinessVo shopBusinessVo = new ShopBusinessVo();
		String startTime = DateTimeUtil.formatTime(startDate, DateTimeUtil.yyyyMMddHHmmss);
		String endTime = DateTimeUtil.formatTime(new Date(), DateTimeUtil.yyyyMMddHHmmss);

		shopBusinessVo.setGrabtimeS(startTime);
		shopBusinessVo.setGrabtimeE(endTime);
		Response response1 = shopUploadBusinessService.uploadGrabShopMysql(shopBusinessVo);	// 生意转让1
		System.out.println(GsonUtil.toJson(response1));

//		ShopVo shopVo = new ShopVo();
//		shopVo.setGrabtimeS(startDate);
//		shopVo.setGrabtimeE(new Date());
//		Response response2 = shopUploadService.uploadGrabShopMysql();		// 商铺发布2
//		System.out.println(GsonUtil.toJson(response2));
		
	}
	
//	@Test
//	public void strTest() {
//		String urlstr = "https://pic7.58cdn.com.cn/p1/tiny/n_v2989acb7dbc1b4921a1b261e71489ec8b.jpg?w=480&h=360&corp=1";
//        String path="d:/tempfile/pic.jpg";
//        
//        URL url = null;
//        try {
//			url = new URL(urlstr);
//			System.out.println("URL 为：" + url.toString());
//	        System.out.println("协议为：" + url.getProtocol());
//	        System.out.println("验证信息：" + url.getAuthority());
//	        System.out.println("文件名及请求参数：" + url.getFile());
//	        System.out.println("主机名：" + url.getHost());
//	        System.out.println("路径：" + url.getPath());
//	        System.out.println("端口：" + url.getPort());
//	        System.out.println("默认端口：" + url.getDefaultPort());
//	        System.out.println("请求参数：" + url.getQuery());
//	        System.out.println("定位位置：" + url.getRef());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        String urlPath = "d:/tempfile" + url.getPath();
//        System.out.println(urlPath);
//        int cnt = urlPath.lastIndexOf("/");
//        System.out.println(urlPath.substring(0, cnt));
//        
//	}
	
//	@Test
//	public void priceTest() {
//		String str1 = ChinaCharUtil.getPrice("5万");
//		String str2 = ChinaCharUtil.getPrice("5.01万");
//		String str3 = ChinaCharUtil.getPrice("1800元");
//		String str4 = ChinaCharUtil.getPrice("无");
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(str3);
//		System.out.println(str4);
//	}
	
//	@Test
//	public void shopPartTest() {
//		String s = "暖气";
//		int s1 = ShopHelper.getShPartType(s);
//		System.out.println(s1);
//		
//		String message = "暖气,管煤,380V,外摆区";
//		String str = ShopHelper.getShPartTypeS(message);
//		System.out.println(str);
//	}

	@Test
	public void deletePic(){
		String oldPic = "http://new.cbe.com.cn/img/2020-06-02/2020060212330253.jpg,http://new.cbe.com.cn/img/2020-06-02/202006021233024.jpg,http://new.cbe.com.cn/img/2020-06-02/2020060212330269.jpg";
		boolean flag = shopHelper.deleteOldPic(oldPic);
		System.out.println("删除结果：" + flag);
	}
}
