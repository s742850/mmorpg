package tw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tw.enums.AccountsErrorCode;
import tw.ex.AccountsException;
import tw.model.Accounts;
import tw.repository.AccountsRepository;
import tw.response.AccountsResponse;
import tw.service.AccountsService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public AccountsResponse insertAccounts(String account, String password) {
        Accounts accounts = new Accounts(account, password);
        Accounts save = accountsRepository.save(accounts);
        return new AccountsResponse(save);
    }

    @Override
    public AccountsResponse findById(int id) throws AccountsException {
        Optional<Accounts> optionalAccounts = accountsRepository.findById(id);
        if (optionalAccounts.isPresent()) {
            return new AccountsResponse(optionalAccounts.get());
        } else {
            throw new AccountsException(AccountsErrorCode.ACCOUNT_NOT_FOUND);
        }
    }

    @Override
    public boolean deleteAccounts(int id) throws AccountsException {
        Optional<Accounts> optionalAccounts = accountsRepository.findById(id);
        if (optionalAccounts.isPresent()) {
            Accounts accounts = optionalAccounts.get();
            accounts.setDelete(1);
            accountsRepository.save(accounts);
            return true;
        } else {
            throw new AccountsException(AccountsErrorCode.ACCOUNT_NOT_FOUND);
        }
    }

    @Override
    public boolean updateAccounts(String account, String password) throws AccountsException {
        Optional<Accounts> optionalAccounts = accountsRepository.findByAccountEquals(account);
        if (optionalAccounts.isPresent()) {
            Accounts accounts = optionalAccounts.get();
            accounts.setPassword(password);

            accountsRepository.save(accounts);
            return true;
        } else {
            throw new AccountsException(AccountsErrorCode.ACCOUNT_NOT_FOUND);
        }
    }

    @Override
    public List<AccountsResponse> findAll() throws AccountsException {
        List<AccountsResponse> res = accountsRepository.findAllBy();
        if (res.isEmpty()) throw new AccountsException(AccountsErrorCode.ACCOUNT_NO_RESULT);
        return res;
    }

    @Override
    public Page<AccountsResponse> findAll(Pageable pageable) throws AccountsException {
        Page<AccountsResponse> res = accountsRepository.findAllBy(pageable);
        if (res.isEmpty()) throw new AccountsException(AccountsErrorCode.ACCOUNT_NO_RESULT);
        return res;
    }
}
