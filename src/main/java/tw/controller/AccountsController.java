package tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tw.ex.AccountsException;
import tw.ex.CommonException;
import tw.model.Accounts;
import tw.response.AccountsResponse;
import tw.response.CommonResponse;
import tw.service.AccountsService;

import java.util.List;


/**
 * 帳號控制器
 */
@RestController
@RequestMapping(path = "accounts")
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    // ---------------------------------------------------
    // create
    // ---------------------------------------------------

    /**
     * 新增帳號
     *
     * @param account  帳號
     * @param password 密碼
     * @return
     * @throws AccountsException
     */
    @PostMapping
    public AccountsResponse insertAccounts(@RequestParam String account
            , @RequestParam String password) throws AccountsException {
        return accountsService.insertAccounts(account, password);
    }

    // ---------------------------------------------------
    // read
    // ---------------------------------------------------

    /**
     * 根據帳號ID查詢帳號
     *
     * @param id 帳號ID
     * @return
     * @throws AccountsException
     */
    @GetMapping
    public AccountsResponse findById(@RequestParam int id) throws AccountsException {
        return accountsService.findById(id);
    }

    /**
     * 查詢所有帳號
     *
     * @return accounts list
     * @throws AccountsException
     */
    @GetMapping(value = "/all")
    public List<AccountsResponse> findAll() throws AccountsException {
        return accountsService.findAll();
    }

    /**
     * 查詢所有帳號
     *
     * @param page 頁碼
     * @param size 數量
     * @return accounts pages
     * @throws AccountsException
     */
    @GetMapping(value = "/allPage")
    public Page<AccountsResponse> findAll(@RequestParam int page, @RequestParam int size)
            throws AccountsException {
        Pageable pageable = PageRequest.of(page, size);
        return accountsService.findAll(pageable);
    }


    // ---------------------------------------------------
    // update
    // ---------------------------------------------------

    /**
     * 帳號更新密碼
     *
     * @param account  帳號
     * @param password 密碼
     * @return true成功, false失敗
     * @throws AccountsException
     */
    @PutMapping
    public boolean updateAccount(@RequestParam String account, @RequestParam String password)
            throws AccountsException {
        return accountsService.updateAccounts(account, password);
    }

    /**
     * 用entity傳參數可以不全帶, 會檢查是否有存在此帳號ID, 沒有拋出錯誤訊息
     *
     * @param accounts
     * @return
     * @throws CommonException
     */
    @PutMapping(value = "/updateAccount")
    public CommonResponse updateAccount(@RequestBody Accounts accounts)
            throws CommonException {
        return accountsService.updateAccounts(accounts);
    }
    // ---------------------------------------------------
    // delete
    // ---------------------------------------------------

    /**
     * 備註刪除
     *
     * @param id 帳號ID
     * @return true成功, false失敗
     * @throws AccountsException
     */
    @DeleteMapping
    public boolean deleteAccounts(@RequestParam int id) throws AccountsException {
        return accountsService.deleteAccounts(id);
    }
}
