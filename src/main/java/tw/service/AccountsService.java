package tw.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tw.ex.AccountsException;
import tw.response.AccountsResponse;

import java.util.List;

public interface AccountsService {

    /**
     * 新增帳號
     *
     * @param account  帳號
     * @param password 密碼
     * @return
     */
    AccountsResponse insertAccounts(String account, String password);

    /**
     * 根據ID查詢帳號
     *
     * @param id 帳號ID
     * @return
     */
    AccountsResponse findById(int id) throws AccountsException;

    /**
     * 備註刪除
     *
     * @param id 帳號ID
     * @return
     */
    boolean deleteAccounts(int id) throws AccountsException;

    /**
     * 帳號更新密碼
     *
     * @param account  帳號
     * @param password 密碼
     * @return true成功, false失敗
     */
    boolean updateAccounts(String account, String password) throws AccountsException;

    /**
     * 查詢全部帳號
     *
     * @return accounts list
     */
    List<AccountsResponse> findAll() throws AccountsException;

    /**
     * 查詢全部帳號
     * @param pageable
     * @return accounts page
     * @throws AccountsException
     */
    Page<AccountsResponse> findAll(Pageable pageable) throws AccountsException;
}
