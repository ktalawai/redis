package com.kinitap.redis.manager;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import com.kinitap.redis.data.ProductData;
import com.kinitap.redis.util.RedisUtil;

@Configuration
public class ProductManagerImpl implements ProductManager{

	public static final String PRODUCT_TABLE = "PRODUCT_TABLE";
    public static final String PRODUCT = "PRODUCT_";
    private RedisUtil<ProductData> redisUtil;
    
    @Autowired
    public ProductManagerImpl(RedisUtil<ProductData> redisUtil) {
        this.redisUtil = redisUtil;
    }
    @Override
    public void cacheProductDetails(ProductData products){
        redisUtil.putMap(PRODUCT_TABLE,PRODUCT+products.getId(),products);
        redisUtil.setExpire(PRODUCT_TABLE,1,TimeUnit.MINUTES);
    }
    
    @Override
    public boolean isCacheEmpty() {
    	if(CollectionUtils.isEmpty(redisUtil.getMapAsAll(PRODUCT_TABLE))){
    		return true;
    	}
    return false;
    }
    
}
