package tw.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {
    /**
     * ID系統唯一碼
     */
    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 技能名稱
     */
    @Column(name = "skill_name")
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "role_skill", joinColumns = {@JoinColumn(name = "skill_id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    public Skill() {
    }

    public Skill(String name) {
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
