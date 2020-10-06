package tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tw.ex.WeaponException;
import tw.response.WeaponResponse;
import tw.service.WeaponService;

import java.util.List;

/**
 * 武器控制器
 */
@RestController
@RequestMapping(path = "/weapon")
public class WeaponController {

    @Autowired
    WeaponService weaponService;

//    create

    /**
     * 新增武器
     *
     * @param name 武器名字
     * @return
     */
    @PostMapping
    public WeaponResponse save(@RequestParam String name) {
        WeaponResponse res = weaponService.insertWeapon(name);
        return res;
    }

    //    read


    /**
     * 根據ID查詢武器
     *
     * @param id 武器ID
     * @return
     * @throws WeaponException
     */
    @GetMapping
    public WeaponResponse findById(@RequestParam int id) throws WeaponException {
        return weaponService.findById(id);
    }

    /**
     * 查詢全部武器
     *
     * @return weapon list
     * @throws WeaponException
     */
    @GetMapping(value = "/all")
    public List<WeaponResponse> findAllBy() throws WeaponException {
        return weaponService.findAllBy();
    }

    /**
     * 分頁查詢武器
     *
     * @param size 一頁幾筆
     * @param page 頁碼
     * @return
     * @throws WeaponException
     */
    @GetMapping(value = "/allPage")
    public Page<WeaponResponse> findAll(@RequestParam int size, @RequestParam int page) throws WeaponException {
        return weaponService.findAllBy(PageRequest.of(page, size));
    }

//    delete

    /**
     * 根據ID刪除武器
     *
     * @param id 武器ID
     * @return
     * @throws WeaponException
     */
    @DeleteMapping
    public boolean delete(@RequestParam int id) throws WeaponException {
        return weaponService.deleteWeapon(id);
    }

    //    update

    /**
     * 更新武器
     *
     * @param id   武器ID
     * @param name 武器名稱
     * @return
     * @throws WeaponException
     */
    @PutMapping
    public boolean updateWeapon(@RequestParam int id, @RequestParam String name) throws WeaponException {
        return weaponService.updateWeapon(name, id);
    }
}
