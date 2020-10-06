package tw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.model.Skill;
import tw.response.SkillResponse;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

    // ---------------------------------------------------
    // JPQL, read
    // ---------------------------------------------------

    /**
     * 根據ID查詢技能
     *
     * @param id 技能ID
     * @return
     */
    @Query(value = "select s from Skill s where s.id =:id")
    SkillResponse findByIdJPQL(@Param("id") int id);

    /**
     * 查詢全部技能
     *
     * @return 技能list
     */
    List<SkillResponse> findAllBy();


    /**
     * 查詢全部技能
     *
     * @param pageable
     * @return 技能page
     */
    Page<SkillResponse> findAllBy(Pageable pageable);

    /**
     * 根據技能ID, 查詢技能
     *
     * @return Optional<SkillResponse>
     */
    Optional<SkillResponse> findByIdEquals(int id);
}
