package tw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.model.Weapon;
import tw.response.WeaponResponse;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

    // ---------------------------------------------------
    // JPQL, read
    // ---------------------------------------------------

    /**
     * 根據ID查詢武器
     *
     * @param id 武器ID
     * @return
     */
    @Query(value = "select w from Weapon w where w.id =:id")
    WeaponResponse findByIdJPQL(@Param("id") int id);

    /**
     * 查詢全部武器
     *
     * @return 武器list
     */
    List<WeaponResponse> findAllBy();

    /**
     * 查詢全部武器
     *
     * @param pageable
     * @return 武器page
     */
    Page<WeaponResponse> findAllBy(Pageable pageable);

    /**
     * 根據武器ID, 查詢武器
     *
     * @return Optional<WeaponResponse>
     */
    Optional<WeaponResponse> findByIdEquals(int id);
}
