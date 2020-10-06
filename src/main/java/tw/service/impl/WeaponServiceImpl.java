package tw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tw.enums.WeaponErrorCode;
import tw.ex.WeaponException;
import tw.model.Weapon;
import tw.repository.RoleRepository;
import tw.repository.WeaponRepository;
import tw.response.WeaponResponse;
import tw.service.WeaponService;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    WeaponRepository weaponRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public WeaponResponse insertWeapon(String name) {
        Weapon weapon = new Weapon(name);
        Weapon save = weaponRepository.save(weapon);
        return new WeaponResponse(save);
    }

    @Override
    public WeaponResponse findById(int id) throws WeaponException {
        Optional<Weapon> res = weaponRepository.findById(id);
        if (!res.isPresent()) throw new WeaponException(WeaponErrorCode.WEAPON_NO_RESULT);
        return new WeaponResponse(res.get());
    }

    @Override
    public List<WeaponResponse> findAllBy() throws WeaponException {
        List<WeaponResponse> res = weaponRepository.findAllBy();
        if (res.isEmpty()) throw new WeaponException(WeaponErrorCode.WEAPON_NO_RESULT);
        return res;

    }

    @Override
    public Page<WeaponResponse> findAllBy(Pageable pageable) throws WeaponException {
        Page<WeaponResponse> res = weaponRepository.findAllBy(pageable);
        if (res.isEmpty()) throw new WeaponException(WeaponErrorCode.WEAPON_NO_RESULT);
        return res;
    }

    @Override
    public boolean deleteWeapon(int id) throws WeaponException {
        if (roleRepository.existsByWeaponId(id)) {
            throw new WeaponException(WeaponErrorCode.ROLE_HAS_THIS_WEAPON);
        }

        Optional<Weapon> optionalWeapon = weaponRepository.findById(id);
        if (!optionalWeapon.isPresent()) {
            throw new WeaponException(WeaponErrorCode.WEAPON_NOT_FOUND);
        }
        weaponRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateWeapon(String name, int id) throws WeaponException {
        Optional<Weapon> optionalWeapon = weaponRepository.findById(id);
        if (!optionalWeapon.isPresent()) throw new WeaponException(WeaponErrorCode.WEAPON_NOT_FOUND);
        Weapon weapon = optionalWeapon.get();
        weapon.setName(name);
        weaponRepository.save(weapon);
        return true;
    }
}
