package tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tw.ex.SkillException;
import tw.response.SkillResponse;
import tw.service.SkillService;

import java.util.List;

/**
 * 技能控制器
 */
@RestController
@RequestMapping(path = "/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

//    create

    /**
     * 新增技能
     *
     * @param name 技能名字
     * @return
     */
    @PostMapping
    public SkillResponse save(@RequestParam String name) {
        SkillResponse res = skillService.insertSkill(name);
        return res;
    }

    //    read


    /**
     * 根據ID查詢技能
     *
     * @param id 技能ID
     * @return
     * @throws SkillException
     */
    @GetMapping
    public SkillResponse findById(@RequestParam int id) throws SkillException {
        return skillService.findByIdJPQL(id);
    }

    /**
     * 查詢全部技能
     *
     * @return skill list
     * @throws SkillException
     */
    @GetMapping(value = "/all")
    public List<SkillResponse> findAllBy() throws SkillException {
        return skillService.findAllBy();
    }

    /**
     * 分頁查詢技能
     *
     * @param size 一頁幾筆
     * @param page 頁碼
     * @return
     * @throws SkillException
     */
    @GetMapping(value = "/allPage")
    public Page<SkillResponse> findAll(@RequestParam int size, @RequestParam int page) throws SkillException {
        return skillService.findAllBy(PageRequest.of(page, size));
    }

//    delete

    /**
     * 根據ID刪除技能
     *
     * @param id 技能ID
     * @return
     * @throws SkillException
     */
    @DeleteMapping
    public boolean delete(@RequestParam int id) throws SkillException {
        return skillService.deleteSkill(id);
    }

    //    update

    /**
     * 更新技能
     *
     * @param id   技能ID
     * @param name 技能名稱
     * @return
     * @throws SkillException
     */
    @PutMapping
    public boolean updateSkill(@RequestParam int id, @RequestParam String name) throws SkillException {
        return skillService.updateSkill(name, id);
    }
}
