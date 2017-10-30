package com.gt.customize.core.util;

import com.alibaba.fastjson.JSON;
import org.apache.velocity.texen.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by psr on 2017/10/28 0028.
 */
public class RedisCacheUtil {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

//    @Autowired
//    private JedisCluster jedisCluster;

//    private String getRedisNamePrefix() {
//        return PropertiesUtil.redisNamePrefix();
//    }

    //-------------------------------------------------- get ----------------------------------------------------------

    /**
     * 通过key获取对应的缓存内容
     *
     * @param key 键
     * @return Object 值
     */
    public String get(String key) {
        String result = null;
        try {
            ValueOperations<String, String> operations = this.redisTemplate.opsForValue();
            result = operations.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
//    public String get(String key) {
//        String result = null;
//        try {
//            String tgtKey = this.getRedisNamePrefix() + key;
//            result = jedisCluster.get(tgtKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    //-------------------------------------------------- set ----------------------------------------------------------

    /**
     * 通过key和value设置缓存，默认2小时
     *
     * @param key   键
     * @param value 值
     * @return boolean 是否设置成功
     */
    public boolean set(String key, Object value) {
        boolean result = false;
        try {
            set(key, value, 7200L);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过key、value和过期时间设置缓存
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间
     * @return boolean 是否设置成功
     */
    public boolean set(String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            String tgtValue = JSON.toJSONString(value);
            operations.set(key, tgtValue);
            this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
//    public boolean set(String key, Object value, Long expireTime) {
//        boolean result = false;
//        try {
//            String tgtKey = this.getRedisNamePrefix() + key + new Random().nextInt(Integer.MAX_VALUE);
//            String tgtValue = JSON.toJSONString(value);
//            jedisCluster.setex(tgtKey, expireTime.intValue(), tgtValue);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    //------------------------------------------------ remove ---------------------------------------------------------

    /**
     * 通过key移除对应缓存内容
     *
     * @param key 键
     * @return boolean 是否移除成功
     */
    public boolean remove(String key) {
        boolean result = false;
        try {
            this.redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过key集合，移除对应缓存内容
     *
     * @param keys 键集合
     * @return boolean 是否移除成功
     */
    public boolean remove(List<String> keys) {
        Set<String> tgtKeys = new HashSet<>();
        if (CommonUtil.isNotEmpty(keys)) {
            for (String key : keys) {
                tgtKeys.add(key);
            }
        }
        return this.remove(tgtKeys);
    }

    /**
     * 私有方法: 根据目标key集合，移除对应缓存对象
     *
     * @param tgtKeys 目标键集合
     * @return boolean 是否移除成功
     */
    private boolean remove(Set<String> tgtKeys) {
        boolean result = false;
        try {
            if (tgtKeys.size() > 0) {
                this.redisTemplate.delete(tgtKeys);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //------------------------------------------------ exists ---------------------------------------------------------

    /**
     * 根据key，判断是否存在对应的缓存内容
     *
     * @param key 键
     * @return boolean 是否存在
     */
    public boolean exists(String key) {
        boolean result = false;
        try {
            result = this.redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
