package tw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.model.Accounts;
import tw.response.AccountsResponse;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

    // ---------------------------------------------------
    // JPQL, spring自動Convert to Response
    // ---------------------------------------------------

    // ---------------------------------------------------
    // JPQL read
    // ---------------------------------------------------

    /**
     * 根據ID查詢帳號
     *
     * @param id 帳號ID
     * @return
     */
    @Query(value = "select a from Accounts a where a.id =:id")
    AccountsResponse findByIdJPQL(@Param("id") int id);

    /**
     * 查詢全部帳號
     *
     * @return 帳號list
     */
    List<AccountsResponse> findAllBy();

    /**
     * 查詢全部帳號
     *
     * @param pageable
     * @return 帳號page
     */
    Page<AccountsResponse> findAllBy(Pageable pageable);

    /**
     * 根據帳號, 查詢帳號
     * @param account  帳號
     * @return
     */
    Optional<Accounts> findByAccountEquals(String account);

    // ---------------------------------------------------
    // update
    // ---------------------------------------------------

    // ---------------------------------------------------
    // delete
    // ---------------------------------------------------
}
