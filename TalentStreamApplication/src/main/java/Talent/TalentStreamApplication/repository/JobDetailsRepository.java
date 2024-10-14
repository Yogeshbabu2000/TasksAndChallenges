package Talent.TalentStreamApplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import Talent.TalentStreamApplication.entity.JobPostDetailsEntity;


public interface JobDetailsRepository  extends JpaRepository <JobPostDetailsEntity, Long>{


}
