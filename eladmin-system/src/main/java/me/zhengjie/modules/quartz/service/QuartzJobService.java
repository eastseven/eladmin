package me.zhengjie.modules.quartz.service;

import me.zhengjie.modules.quartz.domain.QuartzJob;
import me.zhengjie.modules.quartz.service.dto.JobQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
 * @author Zheng Jie
 * @date 2019-01-07
 */
@CacheConfig(cacheNames = "quartzJob")
public interface QuartzJobService {

    /**
     * queryAll quartzJob
     *
     * @param criteria 标准
     * @param pageable 分页
     * @return 结果
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(JobQueryCriteria criteria, Pageable pageable);

    /**
     * queryAll quartzLog
     *
     * @param criteria 标准
     * @param pageable 分页
     * @return 结果
     */
    Object queryAllLog(JobQueryCriteria criteria, Pageable pageable);

    /**
     * create
     *
     * @param resources 资源
     * @return 结果
     */
    @CacheEvict(allEntries = true)
    QuartzJob create(QuartzJob resources);

    /**
     * update
     *
     * @param resources 资源
     * @return 结果
     */
    @CacheEvict(allEntries = true)
    void update(QuartzJob resources);

    /**
     * del
     *
     * @param quartzJob Job
     */
    @CacheEvict(allEntries = true)
    void delete(QuartzJob quartzJob);

    /**
     * findById
     *
     * @param id ID
     * @return 结果
     */
    @Cacheable(key = "#p0")
    QuartzJob findById(Long id);

    /**
     * 更改定时任务状态
     *
     * @param quartzJob Job
     */
    @CacheEvict(allEntries = true)
    void updateIsPause(QuartzJob quartzJob);

    /**
     * 立即执行定时任务
     *
     * @param quartzJob Job
     */
    void execution(QuartzJob quartzJob);
}
