package tw.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tw.ex.RoleException;
import tw.model.Role;
import tw.response.RoleResponse;

import java.util.List;

public interface RoleService {
//    /**
//     * 新增角色
//     *
//     * @param role 角色
//     * @return
//     */
//    RoleResponse insertRole(Role role) throws RoleException;
    /**
     * 新增角色
     *
     * @param role 角色
     * @return
     */
    RoleResponse insertRole(Role role) throws RoleException;


    /**
     * 根據角色ID, 查詢角色(單筆)
     *
     * @param id 角色ID
     * @return
     */
    RoleResponse findByIdJPQL(int id) throws RoleException;

    /**
     * 查詢全部, 回傳List
     *
     * @return
     */
    List<RoleResponse> findAllBy() throws RoleException;

    /**
     * 暱稱模糊查詢, 實際上是回傳Role, spring會自動呼叫RoleResponse建構值(Role)
     * 例如模糊查詢: %D%
     *
     * @param nickName 暱稱
     * @return
     */
    List<RoleResponse> findAllByNickNameLike(String nickName);

    /**
     * 分頁查詢全部
     *
     * @param pageable
     * @return
     */
    Page<RoleResponse> findAllBy(Pageable pageable);

    /**
     * 暱稱分頁模糊查詢, 實際上是回傳Role, spring會自動呼叫RoleResponse建構值(Role)
     * 例如模糊查詢: D%
     *
     * @param nickName 暱稱
     * @param pageable 分頁介面
     * @return
     */
    Page<RoleResponse> findAllByNickNameLike(String nickName, Pageable pageable);

    /**
     * 暱稱模糊查詢, %nickName%
     *
     * @param nickName 暱稱
     * @return RoleResponses list
     * @throws RoleException
     */
    List<RoleResponse> findAllByNickNameContaining(String nickName) throws RoleException;

    /**
     * 分頁查詢包含暱稱, 也就是%nickName%
     *
     * @param nickName 暱稱
     * @return RoleResponses pages
     * @throws RoleException
     */
    Page<RoleResponse> findAllByNickNameContaining(String nickName, Pageable pageable) throws RoleException;

    /**
     * 更新角色, 如果要更新的角色ID不存在, 拋出例外
     *
     * @param role 角色
     * @return
     * @throws RoleException
     */
    RoleResponse updateRole(Role role) throws RoleException;

    /**
     * 更新角色, 如果要更新的角色ID不存在, 拋出例外
     *
     * @param id         角色ID
     * @param hp         血量 option
     * @param level      等級 option
     * @param nickName   暱稱 option
     * @param weaponId
     * @param weaponName 武器名字 option
     * @return
     */
    RoleResponse updateRole(Integer id, Integer hp, String level, String nickName
            , Integer weaponId, String weaponName) throws RoleException;

    /**
     * 根據ID刪除Role
     *
     * @param id 角色ID
     */
    void deleteById(int id);

}
