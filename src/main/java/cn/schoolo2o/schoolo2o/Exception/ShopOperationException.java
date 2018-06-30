package cn.schoolo2o.schoolo2o.Exception;

public class ShopOperationException extends RuntimeException{

    private static final long serialVersionUID = -3703302069772436511L;

    public ShopOperationException(String msg){
        super(msg);
    }
}
