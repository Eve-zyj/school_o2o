package cn.schoolo2o.schoolo2o.service;

import cn.schoolo2o.schoolo2o.Exception.ShopOperationException;
import cn.schoolo2o.schoolo2o.dto.ShopExecution;
import cn.schoolo2o.schoolo2o.enums.ShopStateEnum;
import cn.schoolo2o.schoolo2o.mapper.ShopMapper;
import cn.schoolo2o.schoolo2o.pojo.Shop;
import cn.schoolo2o.schoolo2o.util.ImageUtil;
import cn.schoolo2o.schoolo2o.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
@Service
public class ShopServiceImpl implements ShopService {
    private static Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);
    @Autowired
    private ShopMapper shopMapper;
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        //logger.debug("我是日志");
        //空值判断
        if(shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            //给店铺信息赋值 初始值
            shop.setEnableStatus(0);//未上架
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopMapper.insertShop(shop);
            if(effectedNum<=0){
                throw new ShopOperationException("店铺创建失败");//只有是运行时异常事务才会回滚并停止
            }else {
                logger.debug("shop service:"+shop);
                if(shopImgInputStream!=null){
                    //存储图片
                    try {
                        addShopImg(shop,shopImgInputStream,fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error:"+e.getMessage()+shop+shopImgInputStream);//只有是运行时异常事务才会回滚并停止
                    }
                    //更新店铺的图片地址
                    effectedNum=shopMapper.updateShop(shop);
                    if(effectedNum<=0){
                        throw new ShopOperationException("更新图片地址失败");//只有是运行时异常事务才会回滚并停止
                    }
                }else {
                    throw new ShopOperationException("图片地址为空");//只有是运行时异常事务才会回滚并停止
                }
            }
        }catch (Exception e){
            throw  new ShopOperationException("addshopError:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    /**
     * 新增商铺图片
     * @param shop
     */
    private void addShopImg(Shop shop,InputStream shopImgInputStream, String fileName) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
