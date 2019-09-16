package com.kinitap.redis.manager;

import com.kinitap.redis.data.ProductData;

public interface ProductManager {

	void cacheProductDetails(ProductData products);

	boolean isCacheEmpty();

}
