package cn.schoolo2o.schoolo2o.mapper;

import cn.schoolo2o.schoolo2o.pojo.Shop;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopMapper {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
