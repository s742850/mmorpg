package tw.response;

import tw.model.Role;

/**
 * 回應給前端的物件 VO, 有些欄位不想回給client
 */
public class RoleResponse {
    private int id;

    private int hp;

    private String nickName;

    private String level;

//    @link https://stackoverflow.com/questions/37848789/spring-expected-instead-of-t-error-when-returning-list
//    private Accounts account;

    public RoleResponse() {

    }

    /**
     * 必須要有, spring 會自動塞進去, 且一定要開public
     *
     * @param role
     */
    public RoleResponse(Role role) {
        this.id = role.getId();
        this.hp = role.getHp();
        this.nickName = role.getNickName();
        this.level = role.getLevel();
//        this.account = role.getAccount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

//    public Accounts getAccount() {
//        return account;
//    }
//
//    public void setAccount(Accounts account) {
//        this.account = account;
//    }

    @Override
    public String toString() {
        return "RoleResponse{" +
                "id=" + id +
                ", hp=" + hp +
                ", nickName='" + nickName + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}

