package tw.response;

import tw.model.Skill;

public class SkillResponse {

    private String name;

    public SkillResponse() {
    }

    public SkillResponse(Skill skill) {
        this.name = skill.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SkillResponse{" +
                "name='" + name + '\'' +
                '}';
    }
}
