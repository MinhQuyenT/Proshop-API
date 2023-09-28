package minhquyen.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public class CachedService {
    @Cacheable(value = "myCache", key = "#key")
    public String getCachedValue(String key) {
        // Lấy dữ liệu từ database hoặc nguồn dữ liệu khác ở đây
        return "Cached Value";
    }

    @CacheEvict(value = "myCache", key = "#key")
    public void clearCache(String key) {
        // Xóa dữ liệu khỏi cache
    }
}
