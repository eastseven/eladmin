package me.zhengjie.modules.monitor.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 可自行扩展
 *
 * @author Zheng Jie
 * @date 2018-12-10
 */
public interface RedisService {

    /**
     * findById
     *
     * @param key Key
     * @return Page
     */
    Page findByKey(String key, Pageable pageable);

    /**
     * 查询验证码的值
     *
     * @param key Key
     * @return 结果
     */
    String getCodeVal(String key);

    /**
     * 保存验证码
     *
     * @param key Key
     * @param val Value
     */
    void saveCode(String key, Object val);

    /**
     * delete
     *
     * @param key Key
     */
    void delete(String key);

    /**
     * 清空所有缓存
     */
    void flushDb();
}
