package tw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.model.Role;
import tw.response.RoleResponse;

import java.util.List;

/**
 * spring data jpa方法命名规则
 *
 * @link https://blog.csdn.net/sbin456/article/details/53304148
 * <p>
 * Spring Data JPA @Query
 * @link https://www.baeldung.com/spring-data-jpa-query
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    // ---------------------------------------------------
    // Native SQL
    // ---------------------------------------------------

    /**
     * 會出現ConverterNotFoundException, Native SQL沒有辦法自動幫我們轉成Response物件, 需要自己轉
     *
     * @param role_id
     * @return
     */
    //    原生SQL查詢
//    @Query(value = "SELECT * FROM role WHERE role_id = :role_id", nativeQuery = true)
//    RoleResponse findByIdNative(@Param("role_id") int role_id);


    // ---------------------------------------------------
    // JPQL, spring自動Convert to Response
    // ---------------------------------------------------

    // ---------------------------------------------------
    // JPQL, create
    // ---------------------------------------------------


    // ---------------------------------------------------
    // JPQL, read
    // ---------------------------------------------------

    /**
     * 根據角色ID, 查詢角色(單筆)
     *
     * @param id 角色ID
     * @return
     */
    //JPQL查詢
//    @Query(value = "SELECT r FROM Role r WHERE r.id=?1")
    @Query(value = "SELECT r FROM Role r WHERE r.id=:xxx")
    RoleResponse findByIdJPQL(@Param("xxx") int id);
//    ?1?2要照順序, @Param

    /**
     * 查詢全部, 回傳List
     *
     * @return
     */
    List<RoleResponse> findAllBy();

    /**
     * 暱稱模糊查詢, 實際上是回傳Role, spring會自動呼叫RoleResponse建構值(Role)
     * 例如模糊查詢: %D%
     *
     * @param nickName 暱稱
     * @return
     */
    List<RoleResponse> findAllByNickNameLike(@Param("xxx") String nickName);
//    要注意順序

    /**
     * 分頁查詢全部
     *
     * @param pageable
     * @return
     */
    Page<RoleResponse> findAllBy(Pageable pageable);

    /**
     * 暱稱分頁模糊查詢, 實際上是回傳Role, spring會自動呼叫RoleResponse建構值(Role)
     * 例如模糊查詢: %D%
     *
     * @param nickName 暱稱
     * @param pageable 分頁介面
     * @return
     */
    Page<RoleResponse> findAllByNickNameLike(String nickName, Pageable pageable);

    /**
     * 暱稱模糊查詢
     */
    List<RoleResponse> findAllByNickNameContaining(String nickName);


    /**
     * 分頁查詢包含暱稱, 也就是%nickName%
     *
     * @param nickName 暱稱
     * @param pageable
     * @return RoleResponse pages
     */
    Page<RoleResponse> findAllByNickNameContaining(String nickName, Pageable pageable);

//    @Query(value = "SELECT * FROM role r WHERE r.weapon_id=:weaponId", nativeQuery = true)
//    Role findRoleByWeaponExists(@Param("weaponId") int weaponId);

//    @Query(value = "SELECT r FROM Role r WHERE r.weapon.id=:weaponId")
//    Role findRoleByWeaponExists(@Param("weaponId") int weaponId);

    /**
     * 查詢角色表有沒有此武器ID
     *
     * @param weaponId
     * @return
     */
    boolean existsByWeaponId(int weaponId);


    /**
     * 查詢有沒有存在nickName
     * @param nickName 暱稱
     * @return true存在, false不存在
     */
    boolean existsByNickName(@Param("nickName") String nickName);

    // ---------------------------------------------------
    // JPQL, update
    // ---------------------------------------------------


    // ---------------------------------------------------
    // JPQL, delete
    // ---------------------------------------------------
}
