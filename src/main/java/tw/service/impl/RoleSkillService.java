package tw.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.enums.RoleErrorCode;
import tw.enums.SkillErrorCode;
import tw.ex.RoleException;
import tw.ex.SkillException;
import tw.model.Role;
import tw.model.Skill;
import tw.repository.RoleRepository;
import tw.repository.SkillRepository;

import java.util.List;
import java.util.Optional;

/**
 * 角色既能服務
 */
@Service
public class RoleSkillService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    SkillRepository skillRepository;

    /**
     * 新增角色與技能 關聯表
     *
     * @param skillId 技能ID
     * @param roleId  角色ID
     * @return
     * @throws RoleException
     * @throws SkillException
     */
    public boolean addSkillToRole(int skillId, int roleId) throws RoleException, SkillException {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        Optional<Skill> optionalSkill = skillRepository.findById(skillId);

        if (!optionalRole.isPresent()) {
            throw new RoleException(RoleErrorCode.ERRORS_ROLE_ID);
        }
        if (!optionalSkill.isPresent()) {
            throw new SkillException(SkillErrorCode.SKILL_NOT_FOUND);
        }

        Role role = optionalRole.get();


        //檢查重複筆數問題 https://ithelp.ithome.com.tw/questions/10189095
        List<Skill> skills = role.getSkills();
        for (Skill skill : skills) {
            if (skill.getId() == skillId && role.getId() == roleId) {
                throw new RoleException(RoleErrorCode.ROLE_SKILL_DUPLICATE);
            }
        }
//        要拿這個entity 裡面的list
//        List<Skill> skills = role.getSkills();
//        skills.add(skill);
//        role.setSkills(skills);
        Skill skill = optionalSkill.get();
        role.getSkills().add(skill);

//      update role;
        roleRepository.save(role);
        return true;
    }
}
