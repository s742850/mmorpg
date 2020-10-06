package tw.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tw.model.Accounts;
import tw.model.Role;
import tw.response.RoleResponse;

import java.util.List;

@SpringBootTest
class RoleRepositoryTest {
    @Autowired
    RoleRepository roleRepository;

    //    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void findAllByIdJPQL() {
        RoleResponse res = roleRepository.findByIdJPQL(2);
        System.out.println(res);
    }

    @Test
    void findAllBy() {
        List<RoleResponse> res = roleRepository.findAllBy();
        System.out.println(res);
    }

    @Test
    void findAllPage() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<RoleResponse> res = roleRepository.findAllBy(pageable);
        System.out.println(res);
    }

    @Test
    void findAllByNickNameLike() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<RoleResponse> res = roleRepository.findAllByNickNameLike("%D%", pageable);
        System.out.println(res);
    }

    @Test
    void findAllByNickNameLikePage() {
        List<RoleResponse> res = roleRepository.findAllByNickNameLike("%D%");
        System.out.println(res);
    }

    @Test
    void saveRole() {
        Role role = new Role();
        role.setHp(999);
        role.setNickName("role999");
        role.setLevel("B");

        Accounts account = new Accounts();
        account.setId(1);
        role.setAccount(account);

        Role res = roleRepository.save(role);
        System.out.println(res);
    }

    @Test
    void findAllByNickNameContaining() {
        List<RoleResponse> res = roleRepository.findAllByNickNameContaining("D");
        System.out.println(res);
    }

    @Test
    void findAllByNickNameContainingPage() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<RoleResponse> res = roleRepository.findAllByNickNameContaining("D", pageable);
        System.out.println(res);
    }

    @Test
    void findRoleByWeaponExists() {
        boolean res = roleRepository.existsByWeaponId(7);
        System.out.println(res);
    }


    @Test
    void existsByNickName(){
        boolean res = roleRepository.existsByNickName("Daniel");
        System.out.println(res);
    }
}