package tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tw.ex.RoleException;
import tw.model.Accounts;
import tw.model.Role;
import tw.model.Weapon;
import tw.response.RoleResponse;
import tw.service.RoleService;

import java.util.List;


/**
 * 為控制器添加前綴
 *
 * @link https://www.itdaan.com/tw/30a7952d87033bb592879c8174570b90
 */
@RestController
@RequestMapping(path = "${role}")
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     * hello world
     *
     * @return
     */
    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    /**
     * 搜尋全部角色
     *
     * @return
     * @throws RoleException
     */
    @GetMapping(value = "/findAll")
    public List<RoleResponse> findAll() throws RoleException {
        List<RoleResponse> res = roleService.findAllBy();
        return res;
    }


    /**
     * 根據角色ID, 查詢角色(單筆)
     *
     * @param id 角色ID
     * @return
     */
    @GetMapping
    public RoleResponse findById(@RequestParam int id) throws RoleException {
        RoleResponse res = roleService.findByIdJPQL(id);
        return res;
    }


    /**
     * 暱稱模糊查詢, %nickName%
     *
     * @param nickName 暱稱
     * @return RoleResponses list
     * @throws RoleException
     */
    @GetMapping(value = "/findAllByNickNameContaining")
    public List<RoleResponse> findAllByNickNameLike(@RequestParam String nickName) throws RoleException {
        List<RoleResponse> res;
        res = roleService.findAllByNickNameContaining(nickName);
        return res;
    }


    /**
     * 分頁查詢包含暱稱, 也就是%nickName%
     *
     * @param nickName 暱稱
     * @return RoleResponses pages
     * @throws RoleException
     */
    @GetMapping(value = "/findAllByNickNameContainingPage")
    public Page<RoleResponse> findAllByNickNameContainingPage(@RequestParam String nickName
            , @RequestParam int page, @RequestParam int size) throws RoleException {
        Page<RoleResponse> res;

        Pageable pageable = PageRequest.of(page, size);
        res = roleService.findAllByNickNameContaining(nickName, pageable);

        return res;
    }


    /**
     * 新增角色
     *
     * @param hp        血量
     * @param level     等級
     * @param nickName  暱稱
     * @param weapon    武器, 非必要
     * @param accountId 帳號ID, 需注意有沒有此帳號ID
     * @return
     */
    @PostMapping
    public RoleResponse insertRole(@RequestParam int hp
            , @RequestParam String level
            , @RequestParam String nickName
            , @RequestParam(required = false) String weapon
            , @RequestParam int accountId) throws RoleException {
        Role role = new Role();
        role.setHp(hp);
        role.setLevel(level);
        role.setNickName(nickName);
        role.setWeapon(new Weapon(weapon));
        role.setAccount(new Accounts(accountId));
        RoleResponse save = roleService.insertRole(role);
        return save;
    }

    /**
     * 更新角色, 如果要更新的角色ID不存在, 拋出例外
     *
     * @param id         角色ID
     * @param hp         血量
     * @param level      等級
     * @param nickName   暱稱
     * @param weaponName 武器名字
     * @return
     * @throws RoleException
     */
    @PutMapping
    public RoleResponse updateRole(@RequestParam Integer id
            , @RequestParam(required = false) Integer hp
            , @RequestParam(required = false) String level
            , @RequestParam(required = false) String nickName
            , @RequestParam(required = false) String weaponName
            , @RequestParam(required = false) int weaponId) throws RoleException {

//        Weapon weapon = new Weapon(weaponName);
//        Accounts accounts = new Accounts(accountId);
//        Role role = new Role(id, hp, level, nickName, accounts, weapon);
//TODO 換武器
        RoleResponse save = roleService.updateRole(id, hp, level, nickName, weaponId, weaponName);
        return save;
    }

    /**
     * 根據ID刪除Role
     *
     * @param id
     */
    @DeleteMapping
    public void DeleteRole(@RequestParam int id) {
//        TODO 錯誤訊息
        roleService.deleteById(id);
    }
//
//    /**
//     * 根據URL路徑帶入ID查詢role
//     *
//     * @param id ID
//     * @return
//     */
//    @GetMapping(value = "/getRole/{id}")
//    public List<RoleResponse> getRoleByPathVariableId(@PathVariable("id") int id) {
//        return roleService.getRole(id);
//    }
//
//    /**
//     * 根據RequestParam ID查詢role
//     *
//     * @param id ID
//     * @return
//     */
//    @GetMapping(value = "/getRole")
//    public List<RoleResponse> getRole(@RequestParam("Id") int id) {
//        return roleService.getRole(id);
//    }
//
//    /**
//     * 寫死的查詢find all role分頁
//     *
//     * @return
//     */
//    @GetMapping(value = "/getRolePage")
//    public Page<RoleResponse> getRolePage() {
//        Page<RoleResponse> rolePage = roleService.getRolePage();
//        return rolePage;
//    }
//
//    /**
//     * 查詢role全部
//     *
//     * @return
//     */
//    @GetMapping(value = "/getRoleList")
//    public List<RoleResponse> getRoleList() {
//        List<RoleResponse> role = roleService.getRoleList();
//        return role;
//    }
//
//
//    /**
//     * 根據firstName模糊查詢-分頁
//     *
//     * @param keyword firstName
//     * @param page    第幾頁
//     * @param size    筆數
//     * @return
//     */
//    @GetMapping(value = "/role/task3")
//    public Page<RoleResponse> task3(@RequestParam String keyword, @RequestParam int page, @RequestParam int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<RoleResponse> result = roleService.findAllByFirstNameLike("%" + keyword + "%", pageable);
//        return result;
//    }
//
//
//    /**
//     * 用Role物件新增Role, client可以不給ID，因為會自動產生
//     *
//     * @param role
//     * @return
//     */
//    @PostMapping(value = "/role")
//    public RoleResponse insertRole(@RequestBody Role role) {
//        RoleResponse result = roleService.insertRole(role);
//        return result;
//    }
//
//    /**~
//     * 用物件Role更新Role, 如果對應的Role ID存在, 則更新, 不存在則新增
//     *
//     * @param role
//     */
//    @PutMapping(value = "/role")
//    public RoleResponse updateRole(@RequestBody Role role) {
//        RoleResponse res = roleService.updateRole(role);
//        return res;
//    }
//
//    /**
//     * 根據ID刪除Role
//     *
//     * @param id
//     */
//    @DeleteMapping(value = "/role")
//    public void DeleteRole(@RequestParam int id) {
//        roleService.deleteById(id);
//    }
//
//    /***
//     * 備註刪除, 不是真的刪除
//     * @param id ID
//     * @param isDelete true刪除, false還原
//     * @return
//     */
//    @DeleteMapping(value = "deleteFakeRole")
//    public RoleResponse DeleteFakeRole(@RequestParam int id, @RequestParam boolean isDelete) {
//        RoleResponse res = roleService.deleteFake(id, isDelete);
//        return res;
//    }
//
//    /**
//     * 模糊查詢firstName, 沒有填找全部, 不能包含已刪除(備註刪除)
//     *
//     * @param firstName
//     * @return
//     */
//    @GetMapping(value = "findAllByLikeFirstName")
//    public List<RoleResponse> findAllByLikeFirstName(@RequestParam(required = false) String firstName) {
//        List<RoleResponse> res;
//        res = roleService.findFirstNameLikeAndDelete(firstName);
//        return res;
//    }
}
