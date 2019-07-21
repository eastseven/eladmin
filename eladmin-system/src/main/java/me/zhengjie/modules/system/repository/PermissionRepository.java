package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.Permission;
import me.zhengjie.modules.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-12-03
 */
public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     *
     * @param name Name
     * @return 结果
     */
    Permission findByName(String name);

    /**
     * findByPid
     *
     * @param pid PID
     * @return 结果
     */
    List<Permission> findByPid(long pid);
}
