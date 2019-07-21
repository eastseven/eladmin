package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.Dept;
import me.zhengjie.modules.system.service.dto.DeptDTO;
import me.zhengjie.modules.system.service.dto.DeptQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2019-03-25
 */
@CacheConfig(cacheNames = "dept")
public interface DeptService {

    /**
     * queryAll
     *
     * @param criteria 标准
     * @return 结果
     */
    @Cacheable(keyGenerator = "keyGenerator")
    List<DeptDTO> queryAll(DeptQueryCriteria criteria);

    /**
     * findById
     *
     * @param id ID
     * @return 结果
     */
    @Cacheable(key = "#p0")
    DeptDTO findById(Long id);

    /**
     * create
     *
     * @param resources 资源
     * @return 结果
     */
    @CacheEvict(allEntries = true)
    DeptDTO create(Dept resources);

    /**
     * update
     *
     * @param resources 资源
     */
    @CacheEvict(allEntries = true)
    void update(Dept resources);

    /**
     * delete
     *
     * @param id ID
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * buildTree
     *
     * @param deptDTOS 部门
     * @return 结果
     */
    @Cacheable(keyGenerator = "keyGenerator")
    Object buildTree(List<DeptDTO> deptDTOS);

    /**
     * findByPid
     *
     * @param pid PID
     * @return 结果
     */
    @Cacheable(keyGenerator = "keyGenerator")
    List<Dept> findByPid(long pid);

    /**
     * 根据角色查询部门
     *
     * @param id 角色ID
     * @return 结果
     */
    Set<Dept> findByRoleIds(Long id);
}