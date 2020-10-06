package tw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tw.enums.RoleErrorCode;
import tw.ex.RoleException;
import tw.model.Role;
import tw.model.Weapon;
import tw.repository.RoleRepository;
import tw.response.RoleResponse;
import tw.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * 根據角色ID, 搜尋角色
     *
     * @param id 角色ID
     * @return
     * @throws RoleException
     */
    @Override
    public RoleResponse findByIdJPQL(int id) throws RoleException {
        Optional<RoleResponse> res = Optional.ofNullable(roleRepository.findByIdJPQL(id));
        if (res.isPresent()) {
//            RoleResponse roleResponse = res.get();
//            Optional<Accounts> account = Optional.ofNullable(roleResponse.getAccount());
//            if (!account.isPresent()) {
//                throw new RoleException(RoleErrorCode.ERRORS_ACCOUNT_ID_INVALID);
//            }
//            return roleResponse;

            return res.get();
        } else {
            throw new RoleException(RoleErrorCode.NO_RESULT);
        }
    }

    @Override
    public List<RoleResponse> findAllBy() throws RoleException {
        List<RoleResponse> res = roleRepository.findAllBy();
        checkRoleResponse(res);
        return res;
    }

    @Override
    public List<RoleResponse> findAllByNickNameLike(String nickName) {
        List<RoleResponse> res = roleRepository.findAllByNickNameLike(nickName);
        return res;
    }

    @Override
    public Page<RoleResponse> findAllBy(Pageable pageable) {
        Page<RoleResponse> res = roleRepository.findAllBy(pageable);
        return res;
    }

    @Override
    public Page<RoleResponse> findAllByNickNameLike(String nickName, Pageable pageable) {
        Page<RoleResponse> res = roleRepository.findAllByNickNameLike(nickName, pageable);
        return res;
    }

    /**
     * @param nickName
     * @return
     * @throws RoleException
     */
    @Override
    public List<RoleResponse> findAllByNickNameContaining(String nickName) throws RoleException {
        List<RoleResponse> res = roleRepository.findAllByNickNameContaining(nickName);
        checkRoleResponse(res);
        return res;
    }

    /**
     * 分頁查詢包含暱稱, 也就是%nickName%
     *
     * @param nickName 暱稱
     * @param pageable
     * @return RoleResponse pages
     */
    @Override
    public Page<RoleResponse> findAllByNickNameContaining(String nickName, Pageable pageable) throws RoleException {
        Page<RoleResponse> res;
        res = roleRepository.findAllByNickNameContaining(nickName, pageable);
        checkRoleResponse(res);

        return res;
    }

    /**
     * 如果對應的Role ID存在, 則更新, 不存在則新增
     *
     * @param role 角色
     * @return RoleResponse
     */
    @Override
    public RoleResponse insertRole(Role role) throws RoleException {
        String nickName = role.getNickName();
        if (roleRepository.existsByNickName(nickName)) throw new RoleException(RoleErrorCode.ROLE_NICKNAME_DUPLICATE);
        Role save = roleRepository.save(role);
        return new RoleResponse(save);
    }

    /**
     * @param role 角色
     * @return
     * @throws RoleException
     * @Dupcated 更新角色, 如果要更新的角色ID不存在, 拋出例外
     */
    @Override
    public RoleResponse updateRole(Role role) throws RoleException {
        Optional<Role> byId = roleRepository.findById(role.getId());
        if (!byId.isPresent()) throw new RoleException(RoleErrorCode.ERRORS_ROLE_ID);
//        Role role = byId.get();
//
//
//        role.setAccount();
//        checkRoleId(role);
        Role save = roleRepository.save(role);
        return new RoleResponse(save);
    }

    /**
     * 更新角色, 如果要更新的角色ID不存在, 拋出例外
     *
     * @param id         角色ID
     * @param hp         血量 option
     * @param level      等級 option
     * @param nickName   暱稱 option
     * @param weaponName 武器名字 option
     * @return
     */
    @Override
    public RoleResponse updateRole(Integer id, Integer hp, String level, String nickName, String weaponName) throws RoleException {
        Optional<Role> byId = roleRepository.findById(id);
        if (!byId.isPresent()) throw new RoleException(RoleErrorCode.ERRORS_ROLE_ID);

        Role role = byId.get();
        if (hp != null) role.setHp(hp);
        if (level != null) role.setLevel(level);
        if (nickName != null) role.setNickName(nickName);
        if (weaponName != null) {
            Weapon weapon = role.getWeapon();
            if (Optional.ofNullable(weapon).isPresent()) {
                weapon.setName(weaponName);
            }
        }

        Role res = roleRepository.save(role);

        return new RoleResponse(res);
    }

    /**
     * 根據ID刪除Role
     *
     * @param id 角色ID
     */
    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

    /**
     * 檢查Role ID 是否不存在, 不存在拋出exception
     *
     * @param role 角色
     * @throws RoleException
     */
    private void checkRoleId(Role role) throws RoleException {
//        int roleId = role.getId();
//        Optional<RoleResponse> optionalRoleResponse = Optional.ofNullable(roleRepository.findByIdJPQL(roleId));
//        if (!optionalRoleResponse.isPresent()) {
//            throw new RoleException(RoleErrorCode.ERRORS_ROLE_ID);
//        }
        if (!roleRepository.findById(role.getId()).isPresent()) throw new RoleException(RoleErrorCode.ERRORS_ROLE_ID);
    }

    /**
     * 檢核RoleResponse
     *
     * @param res
     * @throws RoleException
     */
    private void checkRoleResponse(Page<RoleResponse> res) throws RoleException {
        if (!res.hasContent()) {
            throw new RoleException(RoleErrorCode.NO_RESULT);
        }
    }

    /**
     * 檢核RoleResponse
     *
     * @param roleResponseList
     */
    private void checkRoleResponse(List<RoleResponse> roleResponseList) throws RoleException {
        if (roleResponseList.isEmpty()) throw new RoleException(RoleErrorCode.NO_RESULT);
    }

    /**
     * 檢核RoleResponse
     *
     * @param roleResponse
     */
    private void checkRoleResponse(RoleResponse roleResponse) throws RoleException {
        if (roleResponse == null) throw new RoleException(RoleErrorCode.ERRORS_INVALID);
    }

}


