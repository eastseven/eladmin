package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-12-03
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     *
     * @param name 名称
     * @return 结果
     */
    Role findByName(String name);

    /**
     * findByUsers_Id
     *
     * @param id ID
     * @return 结果
     */
    Set<Role> findByUsers_Id(Long id);

    /**
     * findByMenus_Id
     *
     * @param id ID
     * @return 结果
     */
    Set<Role> findByMenus_Id(Long id);
}
