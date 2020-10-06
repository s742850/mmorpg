package tw.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tw.ex.SkillException;
import tw.response.SkillResponse;

import java.util.List;
import java.util.Optional;

public interface SkillService {

//    create

    /**
     * 新增技能
     *
     * @param name 技能名稱
     * @return
     */
    SkillResponse insertSkill(String name);

//    update

    /**
     * update skill
     *
     * @param name skill name
     * @param id   技能ID
     * @return
     */
    boolean updateSkill(String name, int id) throws SkillException;

//    delete

    /**
     * delete skill by id
     *
     * @param id skill ID
     * @return true成功, false失敗
     */
    boolean deleteSkill(int id) throws SkillException;


    //    read

    /**
     * 根據ID查詢技能
     *
     * @param id 技能ID
     * @return
     */
    SkillResponse findByIdJPQL(int id) throws SkillException;

    /**
     * 查詢全部技能
     *
     * @return 技能list
     */
    List<SkillResponse> findAllBy() throws SkillException;

    /**
     * 查詢全部技能
     *
     * @param pageable
     * @return 技能page
     */
    Page<SkillResponse> findAllBy(Pageable pageable) throws SkillException;

    /**
     * 根據技能ID, 查詢技能
     *
     * @return Optional<SkillResponse>
     */
    Optional<SkillResponse> findByIdEquals(int id);
}
