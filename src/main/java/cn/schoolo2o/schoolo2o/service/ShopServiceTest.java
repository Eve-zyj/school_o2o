package cn.schoolo2o.schoolo2o.service;

import cn.schoolo2o.schoolo2o.BaseTest;
import cn.schoolo2o.schoolo2o.dto.ShopExecution;
import cn.schoolo2o.schoolo2o.enums.ShopStateEnum;
import cn.schoolo2o.schoolo2o.pojo.Area;
import cn.schoolo2o.schoolo2o.pojo.PersonInfo;
import cn.schoolo2o.schoolo2o.pojo.Shop;
import cn.schoolo2o.schoolo2o.pojo.ShopCategory;
import cn.schoolo2o.schoolo2o.util.ImageUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger(ShopServiceTest.class);
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop(){
        Shop shop = new Shop();
		shop.setOwnerId(1L);
		Area area = new Area();
		area.setAreaId(1L);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shop.setShopName("卜一一的小店");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setLongitude(1D);
		shop.setLatitude(1D);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        logger.debug("shop:"+shop);
        File shopImg = new File("D:\\baidu\\work\\image\\xiaohuangren.jpg");
		InputStream is = null;
		try {
			is = new FileInputStream(shopImg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ShopExecution se = shopService.addShop(shop,is,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
