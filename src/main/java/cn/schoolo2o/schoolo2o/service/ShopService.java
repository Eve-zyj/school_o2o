package cn.schoolo2o.schoolo2o.service;

import cn.schoolo2o.schoolo2o.Exception.ShopOperationException;
import cn.schoolo2o.schoolo2o.dto.ShopExecution;
import cn.schoolo2o.schoolo2o.pojo.Shop;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName);
}
