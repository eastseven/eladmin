package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.Menu;
import me.zhengjie.modules.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-12-17
 */
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     *
     * @param name Name
     * @return 结果
     */
    Menu findByName(String name);

    /**
     * findByPid
     *
     * @param pid PID
     * @return 结果
     */
    List<Menu> findByPid(long pid);

    /**
     * 查询
     *
     * @param id ID
     * @return 结果
     */
    LinkedHashSet<Menu> findByRoles_IdOrderBySortAsc(Long id);
}
