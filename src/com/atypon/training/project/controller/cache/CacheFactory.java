package com.atypon.training.project.controller.cache;

import com.atypon.training.project.Constants;
import com.atypon.training.project.model.content.BaseContent;
import com.atypon.training.project.model.liscense.BaseLicense;
import com.atypon.training.project.model.user.BaseUser;

public class CacheFactory {
    private static Cache<BaseContent> contentCache;
    private static Cache<BaseUser> userCache;
    private static Cache<BaseLicense> licenseCache;

    private CacheFactory() {
    }

    public synchronized static Cache<BaseContent> getContentCacheInstance(String folder) {
        if (contentCache == null) {
            contentCache = new Cache<>(Constants.CACHE_SIZE,folder);
        }
        return contentCache;
    }

    public synchronized static Cache<BaseUser> getUserCacheInstance(String folder) {
        if (userCache == null) {
            userCache = new Cache<>(Constants.CACHE_SIZE,folder);
        }
        return userCache;
    }

    public synchronized static Cache<BaseLicense> getLicenseCacheInstance(String folder) {
        if (licenseCache == null) {
            licenseCache = new Cache<>(Constants.CACHE_SIZE,folder);
        }
        return licenseCache;
    }
}
