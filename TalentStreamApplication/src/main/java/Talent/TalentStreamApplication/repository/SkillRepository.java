package Talent.TalentStreamApplication.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Talent.TalentStreamApplication.entity.Skill;


public interface SkillRepository  extends JpaRepository<Skill, Integer>{
	Optional<Skill> existsBySkill(String skillName);
}
