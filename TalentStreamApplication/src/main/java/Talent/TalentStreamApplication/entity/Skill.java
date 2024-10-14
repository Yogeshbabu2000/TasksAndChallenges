package Talent.TalentStreamApplication.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
@Entity
public class Skill {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Size(min = 1, message = "At least one skill is required")
private String skill;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSkill() {
	return skill;
}

public void setSkill(String skill) {
	this.skill = skill;
}
public Skill() {
}

public Skill(int id, String skill) {
	this.id = id;
	this.skill = skill;
}



}
