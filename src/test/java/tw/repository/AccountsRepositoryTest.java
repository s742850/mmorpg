package tw.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tw.model.Accounts;
import tw.response.AccountsResponse;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class AccountsRepositoryTest {

    @Autowired
    AccountsRepository accountsRepository;

    @Test
    void findAll() {
        List<Accounts> all = accountsRepository.findAll();
        System.out.println(all);
    }

    @Test
    void findByIdJPQL() {
        AccountsResponse res = accountsRepository.findByIdJPQL(2);
        System.out.println(res);
    }

    @Test
    void findAllByList() {
        List<AccountsResponse> res = accountsRepository.findAllBy();
        System.out.println(res);
    }


    @Test
    void findAllByPage() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<AccountsResponse> res = accountsRepository.findAllBy(pageable);
        System.out.println(res);
    }

    @Test
    void findByAccountEquals() {
        String account = "Betty";
        Optional<Accounts> res = accountsRepository.findByAccountEquals(account);
        System.out.println(res.get());
    }


    @Test
    void existsAccountsByAccount() {
        boolean res = accountsRepository.existsAccountsByAccount("hhhh");
        System.out.println(res);
    }

    @Test
    void existsAccountsById(){
        boolean res = accountsRepository.existsAccountsById(100);
        System.out.println(res);
    }
}