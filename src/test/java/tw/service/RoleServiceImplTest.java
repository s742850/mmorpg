package tw.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.enums.RoleErrorCode;
import tw.ex.RoleException;
import tw.response.RoleResponse;

@SpringBootTest
class RoleServiceImplTest {
    @Autowired
    RoleService roleService;

    @Test
    void findByIdJPQL() {
        RoleResponse res;
        try {
            //有這筆資料的
            res = roleService.findByIdJPQL(2);
            Assert.assertEquals(2, res.getId());
            Assert.assertNotNull(res);
            //沒有這筆資料的
            res = roleService.findByIdJPQL(-1);
        } catch (RoleException exception) {
            RoleErrorCode roleErrorCode = exception.getRoleErrorCode();
            int code = roleErrorCode.getCode();
            String message = roleErrorCode.getMessage();
            Assert.assertEquals(1, code);
            Assert.assertEquals("errors.no.result", message);
        }
    }


    @Test
    void updateRole() throws RoleException {
//        Role role = new Role();
//
//        roleService.updateRole(role);
    }


    @Test
    void findAllBy() {
    }

    @Test
    void findAllByNickNameLike() {
    }

    @Test
    void testFindAllBy() {
    }

    @Test
    void testFindAllByNickNameLike() {
    }

    @Test
    void findAllByNickNameContaining() {
    }
}
