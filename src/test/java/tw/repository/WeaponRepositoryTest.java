package tw.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tw.model.Weapon;
import tw.response.WeaponResponse;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class WeaponRepositoryTest {

    @Autowired
    WeaponRepository weaponRepository;

    @Test
    void findByIdJPQL() {
        WeaponResponse res = weaponRepository.findByIdJPQL(1);
        System.out.println(res);
    }

    @Test
    void findAll() {
        List<Weapon> res = weaponRepository.findAll();
        System.out.println(res);
    }

    @Test
    void listFindAllBy() {
        List<WeaponResponse> res = weaponRepository.findAllBy();
        System.out.println(res);
    }

    @Test
    void findAllBy() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<WeaponResponse> res = weaponRepository.findAllBy(pageable);
        System.out.println(res);
    }

    @Test
    void findByIdEquals() {
        Optional<WeaponResponse> res = weaponRepository.findByIdEquals(1);
        System.out.println(res.get());
    }
}