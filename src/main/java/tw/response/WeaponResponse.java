package tw.response;

import tw.model.Weapon;

public class WeaponResponse {

    private String name;

    public WeaponResponse() {
    }

    public WeaponResponse(Weapon weapon) {
        this.name = weapon.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeaponResponse{" +
                "name='" + name + '\'' +
                '}';
    }
}
