package tw.model;

import javax.persistence.*;
import java.util.List;


/**
 * 人物角色
 */
@Entity
@Table(name = "role", indexes = {@Index(name = "UK_role_nick_name", columnList = "role_nick_name", unique = true)})
//, @Index(name = "FK_weapond_id", columnList = "weapon_id")
//        , @Index(name = "FK_account_id", columnList = "accounts_id")
public class Role {

    /**
     * 系統唯一碼
     */
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 血量
     */
    @Column(name = "role_hp")
    private int hp;

    /**
     * UK唯一, 暱稱
     */
    @Column(name = "role_nick_name", length = 30, nullable = false)
    private String nickName;

    /**
     * 等級, C,B,A,S級
     */
    @Column(name = "role_leve", length = 10)
    private String level;

    /**
     *
     * 帳號
     * FK, 名字叫account_id, 關連到account的id
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "accounts_id", referencedColumnName = "accounts_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_accounts_id", value = ConstraintMode.CONSTRAINT))
    private Accounts accounts;

    /**
     * 武器
     * FK, 名字叫weapon_id, 關聯到weapon的id
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id", referencedColumnName = "weapon_id", nullable = true)
    private Weapon weapon;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_skill", joinColumns = {@JoinColumn(name = "role_id")}
            , inverseJoinColumns = {@JoinColumn(name = "skill_id")}
            , uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id", "skill_id"})}
    )
    private List<Skill> skills;


    public Role() {
    }

    public Role(int id, int hp, String nickName, String level, Accounts accounts, Weapon weapon) {
        this.id = id;
        this.hp = hp;
        this.nickName = nickName;
        this.level = level;
        this.accounts = accounts;
        this.weapon = weapon;
    }

    public Role(int id, int hp, String nickName, String level, Accounts accounts, Weapon weapon, List<Skill> skills) {
        this.id = id;
        this.hp = hp;
        this.nickName = nickName;
        this.level = level;
        this.accounts = accounts;
        this.weapon = weapon;
        this.skills = skills;
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

    public Accounts getAccount() {
        return accounts;
    }

    public void setAccount(Accounts accounts) {
        this.accounts = accounts;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * 用這個要注意，要取出此物件原本的list參考，不要自己建立新的list!!!
     *
     * @param skills
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", hp=" + hp +
                ", nickName='" + nickName + '\'' +
                ", level='" + level + '\'' +
                ", accounts=" + accounts +
                ", weapon=" + weapon +
                ", skills=" + skills +
                '}';
    }
}


