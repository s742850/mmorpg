package tw.model;

import javax.persistence.*;
import java.util.List;

/**
 * 玩家帳號
 */
@Entity
@Table(name = "accounts", indexes = {@Index(name = "UK_accounts_account", columnList = "accounts_account", unique = true)})
public class Accounts {

    /**
     * ID系統唯一碼
     */
    @Id
    @Column(name = "accounts_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 唯一, 帳號
     */
    @Column(name = "accounts_account", length = 20, unique = true, nullable = false)
    private String account;

    /**
     * 密碼
     */
    @Column(name = "accounts_passowrd", length = 8)
    private String password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private List<Role> roles;

    /**
     * 備註刪除, 0未刪除, 1已被刪除
     */
    @Column(name = "accounts_delete", length = 1)

    private int delete;

    public Accounts(int accountId) {
        this.id = accountId;
    }

    public Accounts() {

    }

    public Accounts(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", delete=" + delete +
                '}';
    }
}
