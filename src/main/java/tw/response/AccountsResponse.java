package tw.response;

import tw.model.Accounts;

/**
 * 回應前端物件
 */
public class AccountsResponse {

    private String account;
    private String password;

    public AccountsResponse() {
    }

    public AccountsResponse(Accounts accounts) {
        this.account = accounts.getAccount();
        this.password = accounts.getPassword();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountsResponse{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
