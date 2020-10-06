package tw.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tw.enums.SkillErrorCode;
import tw.ex.SkillException;
import tw.model.Skill;
import tw.repository.SkillRepository;
import tw.response.SkillResponse;
import tw.service.SkillService;

import java.util.List;
import java.util.Optional;

/**
 * 技能服務
 */
@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillRepository skillRepository;

    @Override
    public SkillResponse insertSkill(String name) {
        Skill save = skillRepository.save(new Skill(name));
        return new SkillResponse(save);
    }

    @Override
    public boolean updateSkill(String name, int id) throws SkillException {
        Optional<Skill> byIdEquals = skillRepository.findById(id);
        if (byIdEquals.isPresent()) {
            Skill skill = byIdEquals.get();
            skill.setName(name);
            Skill save = skillRepository.save(skill);
            if (save != null) return true;
        }
        throw new SkillException(SkillErrorCode.SKILL_NOT_FOUND);
    }

    @Override
    public boolean deleteSkill(int id) throws SkillException {
        Optional<SkillResponse> byIdEquals = skillRepository.findByIdEquals(id);
        if (byIdEquals.isPresent()) {
            skillRepository.deleteById(id);
            return true;
        } else {
            throw new SkillException(SkillErrorCode.SKILL_NOT_FOUND);
        }
    }

    @Override
    public SkillResponse findByIdJPQL(int id) throws SkillException {
        Optional<SkillResponse> byIdEquals = skillRepository.findByIdEquals(id);
        if (byIdEquals.isPresent()) {
            return byIdEquals.get();
        }
        throw new SkillException(SkillErrorCode.SKILL_NOT_FOUND);
    }

    @Override
    public List<SkillResponse> findAllBy() throws SkillException {
        List<SkillResponse> res = skillRepository.findAllBy();
        if (res.isEmpty()) throw new SkillException(SkillErrorCode.NO_RESULT);
        return res;
    }

    @Override
    public Page<SkillResponse> findAllBy(Pageable pageable) throws SkillException {
        Page<SkillResponse> res = skillRepository.findAllBy(pageable);
        if (res.isEmpty()) throw new SkillException(SkillErrorCode.NO_RESULT);
        return res;
    }

    @Override
    public Optional<SkillResponse> findByIdEquals(int id) {
        return skillRepository.findByIdEquals(id);
    }
}
