package tw.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tw.ex.WeaponException;
import tw.response.WeaponResponse;

import java.util.List;

public interface WeaponService {

    /**
     * 新增武器
     *
     * @param name 武器名字
     * @return
     */
    WeaponResponse insertWeapon(String name);

    /**
     * 根據武器ID搜尋ID
     *
     * @param id 武器ID
     * @return
     */
    WeaponResponse findById(int id) throws WeaponException;

    /**
     * 查詢所有武器
     *
     * @return weapon list
     */
    List<WeaponResponse> findAllBy() throws WeaponException;

    /**
     * 分頁查詢武器
     *
     * @param pageable
     * @return
     */
    Page<WeaponResponse> findAllBy(Pageable pageable) throws WeaponException;

    /**
     * 刪除武器
     *
     * @param id 武器ID
     * @return
     */
    boolean deleteWeapon(int id) throws WeaponException;

    /**
     * 更新武器
     *
     * @param name 武器名 字
     * @param id   武器ID
     * @return true 更新成功
     */
    boolean updateWeapon(String name, int id) throws WeaponException;
}
