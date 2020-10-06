package tw.model;

import javax.persistence.*;

/**
 * 武器
 */
@Entity
@Table(name = "weapon")
public class Weapon {

    /**
     * 系統唯一碼
     */
    @Id
    @Column(name = "weapon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 武器名
     */
    @Column(name = "weapon_name")
    private String name;

    @OneToOne(mappedBy = "weapon")
    private Role role;

    public Weapon() {
    }

    public Weapon(int id) {
        this.id = id;
    }

    public Weapon(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
