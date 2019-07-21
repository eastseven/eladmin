package me.zhengjie.modules.system;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import me.zhengjie.modules.system.repository.MenuRepository;
import me.zhengjie.modules.system.repository.PermissionRepository;
import me.zhengjie.modules.system.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author D7
 * 启动后，初始化数据
 */
@Slf4j
@Component
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppRunCommand implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    @Transactional(rollbackFor = Exception.class)
    public void init() {
        roleRepository.findById(1L).ifPresent(role -> {
            role.setMenus(Sets.newHashSet(menuRepository.findAll()));
            role.setPermissions(Sets.newHashSet(permissionRepository.findAll()));

            roleRepository.save(role);
            log.info(">>> role=[{}], menus=[{}], permissions=[{}]", role.getName(), role.getMenus().size(), role.getPermissions().size());
        });
    }
}
