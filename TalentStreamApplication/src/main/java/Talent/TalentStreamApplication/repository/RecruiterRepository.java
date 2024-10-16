package Talent.TalentStreamApplication.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Talent.TalentStreamApplication.entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer>{
	
  // this is for registration
	boolean existsByEmail(String email);
	
	Optional<Recruiter>findByEmail(String email);
	
	

	

}
