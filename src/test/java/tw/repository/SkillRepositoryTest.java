package tw.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tw.model.Skill;
import tw.response.SkillResponse;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SkillRepositoryTest {

    @Autowired
    SkillRepository skillRepository;

    @Test
    void findByIdJPQL() {
        SkillResponse res = skillRepository.findByIdJPQL(1);
        System.out.println(res);
    }

    @Test
    void findAllByPage() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<SkillResponse> res = skillRepository.findAllBy(pageable);
        System.out.println(res);
    }

    @Test
    void findAllByList(){
        List<SkillResponse> res = skillRepository.findAllBy();
        System.out.println(res);
    }


    @Test
    void findById(){
        Optional<SkillResponse> byId = skillRepository.findByIdEquals(1);
        SkillResponse skillResponse = byId.get();
        System.out.println(skillResponse);
    }

    @Test
    void all(){
        List<Skill> all = skillRepository.findAll();
        System.out.println(all);
    }
}