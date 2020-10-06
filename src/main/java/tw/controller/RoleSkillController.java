package tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tw.ex.RoleException;
import tw.ex.SkillException;
import tw.service.impl.RoleSkillService;

@RestController
@RequestMapping(value = "roleSkill")
public class RoleSkillController {

    @Autowired
    RoleSkillService roleSkillService;

    @PostMapping
    public boolean addSkillToRole(@RequestParam int skillId, @RequestParam int roleId)
            throws SkillException, RoleException {
        return roleSkillService.addSkillToRole(skillId, roleId);
    }
}
