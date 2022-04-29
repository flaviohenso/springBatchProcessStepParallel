package com.example.demo.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

@Component
public class ManagerCache {

	private CacheManager cacheManager;
	
	public ManagerCache() {
		this.cacheManager = new ConcurrentMapCacheManager();
	}

	public void builderCache(String name, Object key , Object value) {
		cacheManager.getCache(name).put(key, value);
	}
	
    public CacheManager getCacheManager() {    	
    	if (cacheManager == null) {
    		cacheManager = new ConcurrentMapCacheManager();
        }
        return cacheManager;
    }
    
    public void clearCache(String name) {
    	cacheManager.getCache(name).clear();
    }
	
}
