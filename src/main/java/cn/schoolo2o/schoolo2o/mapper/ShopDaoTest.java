package cn.schoolo2o.schoolo2o.mapper;

import cn.schoolo2o.schoolo2o.BaseTest;
import cn.schoolo2o.schoolo2o.pojo.Area;
import cn.schoolo2o.schoolo2o.pojo.PersonInfo;
import cn.schoolo2o.schoolo2o.pojo.Shop;
import cn.schoolo2o.schoolo2o.pojo.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private  ShopMapper shopMapper;

    public void testInsertShop(){
        Shop shop = new Shop();
        Area area  = new Area();
        shop.setOwnerId(1L);
        ShopCategory shopCategory = new ShopCategory();
        area.setAreaId(2L);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("笑嘻嘻");
        shop.setCreateTime(new Date());
        shop.setAdvice("审核中");
        shop.setPhone("test");
        shop.setEnableStatus(1);
        int row = shopMapper.insertShop(shop);
        System.out.println("````````````````````````````````````"+row);
    }
    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(29L);
        shop.setShopDesc("测试的信息");
        shop.setShopAddr("测试的地址");
        int row = shopMapper.updateShop(shop);
        System.out.println("`````````````````更新商铺```````````````````"+row);
    }
}
