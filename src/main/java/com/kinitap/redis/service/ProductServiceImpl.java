package com.kinitap.redis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinitap.redis.data.ProductData;
import com.kinitap.redis.manager.ProductManager;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductManager productManager;

	@Autowired
	public ProductServiceImpl(ProductManager redisCacheManager) {
		this.productManager = productManager;
	}

	@Override
	public void cacheProductDetails(boolean checkFlag) throws Exception {
		if (checkFlag && productManager.isCacheEmpty()) {
			//TODO : The below is just a sample, build a enity model as reference
			ProductData data = new ProductData();
			ProductData data2 = new ProductData();
			data.setId("prod001");
			data2.setId("prod002");
			List<ProductData> prodList = new ArrayList<ProductData>();
			prodList.add(data);
			prodList.add(data2);
			prodList.forEach(prod -> productManager.cacheProductDetails(prod));
		}
	}
}
