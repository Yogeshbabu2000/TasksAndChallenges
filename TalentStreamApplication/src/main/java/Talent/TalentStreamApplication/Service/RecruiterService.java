package Talent.TalentStreamApplication.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Talent.TalentStreamApplication.Dto.JobPostDetailsDTO;
import Talent.TalentStreamApplication.Dto.RecruiterDTO;
import Talent.TalentStreamApplication.Dto.RecruiterLoginDTO;
import Talent.TalentStreamApplication.entity.JobPostDetailsEntity;
import Talent.TalentStreamApplication.entity.Recruiter;
import Talent.TalentStreamApplication.exception.CustomException;
import Talent.TalentStreamApplication.repository.JobDetailsRepository;
import Talent.TalentStreamApplication.repository.RecruiterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
@Autowired  
private  RecruiterRepository recruiterRep; 
@Autowired 
private JobDetailsRepository jobPostRepo;


   
   public RecruiterDTO createRecruiter(RecruiterDTO recruiterdto) { 
	   if (recruiterRep.existsByEmail(recruiterdto.getEmail()))
			   {
		   throw new CustomException("email","email already exists");
			   }
	     recruiterRep.save(toEntity(recruiterdto));
	   return recruiterdto;
   }
   
	 public Recruiter toEntity(RecruiterDTO recruiterdto) {
	   Recruiter  recruiter = new Recruiter();
	 recruiter.setCompanyname(recruiterdto.getCompanyname());
	   recruiter.setEmail(recruiterdto.getEmail());
	   recruiter.setMobileNumber(recruiterdto.getMobileNumber());
	   recruiter.setPassword(recruiterdto.getPassword());
	   return recruiter; 
   } 
   public RecruiterDTO toDto(Recruiter recruiter) {
	   RecruiterDTO  recruiterDTO = new RecruiterDTO();
	   recruiterDTO.setCompanyname(recruiter.getCompanyname());
	   recruiterDTO.setEmail(recruiter.getEmail());
	   recruiterDTO.setMobileNumber(recruiter.getMobileNumber());
	   recruiterDTO.setPassword(recruiter.getPassword());
	   return recruiterDTO;
   }
	   
  public RecruiterDTO loginRecruiter(RecruiterLoginDTO loginDTO) {
	    Optional<Recruiter> Recruiter = recruiterRep.findByEmail(loginDTO.getEmail());
	    if (Recruiter.isPresent()) {
	     Recruiter recruiter = Recruiter.get();
	    if (recruiter.getPassword().equals(loginDTO.getPassword())) {
	      return toDto(recruiter);
	        } 
	     else {
	           throw new CustomException("Password", "Incorrect password");
	        }
	    } else {
	        throw new CustomException("Email", "No account found with this email address");
	    }
  }
  public RecruiterDTO getRecruiterByEmail(String email) {
  Recruiter recruiter = recruiterRep.findByEmail(email)
                                     .orElseThrow(() -> new CustomException("Email", "No account found with this email address"));
	  return toDto(recruiter);
	  }
public RecruiterDTO getRecruiterById(int id) {
	Recruiter recruiter = recruiterRep.findById(id)
			                           .orElseThrow(() -> new CustomException("id", "no account found with this id"));
	return toDto(recruiter);
}
public String deleteRecruiterByEmail(String email) {
	 Recruiter recruiter =recruiterRep.findByEmail(email)
                                      .orElseThrow(() -> new CustomException("email", "no account found with this email"));
      recruiterRep.delete(recruiter);
			                        
	return "deleted sucessfully";
}

public RecruiterDTO updateRecruiterDetails(String email, RecruiterDTO updateRecruiterDto) {
	Recruiter existingrecruiter = recruiterRep.findByEmail(email)
			                          .orElseThrow(() -> new CustomException("email", "no account found"));
	if(updateRecruiterDto.getCompanyname()!=null && !updateRecruiterDto.getCompanyname().isEmpty()) {
		existingrecruiter.setCompanyname(updateRecruiterDto.getCompanyname());
	}
	if(updateRecruiterDto.getMobileNumber()!=null && !updateRecruiterDto.getMobileNumber().isEmpty()) {
		existingrecruiter.setMobileNumber(updateRecruiterDto.getMobileNumber());
	}
	if(updateRecruiterDto.getPassword()!=null && !updateRecruiterDto.getPassword().isEmpty()) {
		existingrecruiter.setPassword(updateRecruiterDto.getPassword());
	}
	recruiterRep.save(existingrecruiter);
	return toDto(existingrecruiter);
} 

public JobPostDetailsDTO postJob(String email, JobPostDetailsDTO jobPostDetailsDTO) {

    Optional<Recruiter> recruiterOptional = recruiterRep.findByEmail(email);
    if (recruiterOptional.isEmpty()) {
        throw new CustomException("Email", "No account found with the provided email");
    }

    Recruiter recruiter = recruiterOptional.get();

    try {
        JobPostDetailsEntity newJobPost = new JobPostDetailsEntity();
        
        newJobPost.setJobTitle(jobPostDetailsDTO.getJobTitle());
        newJobPost.setJobDescription(jobPostDetailsDTO.getJobDescription());
        newJobPost.setMinimumExperience(jobPostDetailsDTO.getMinimumExperience());
        newJobPost.setMaximumExperience(jobPostDetailsDTO.getMaximumExperience());
        newJobPost.setMinimumSalary(jobPostDetailsDTO.getMinimumSalary());
        newJobPost.setMaximumSalary(jobPostDetailsDTO.getMaximumSalary());
        newJobPost.setQualification(jobPostDetailsDTO.getQualification());
        newJobPost.setSpecialization(jobPostDetailsDTO.getSpecialization());
        newJobPost.setLocation(jobPostDetailsDTO.getLocation());
        newJobPost.setIndustryType(jobPostDetailsDTO.getIndustryType());
        newJobPost.setJobType(jobPostDetailsDTO.getJobType());
        
        List<String> skills = jobPostDetailsDTO.getSkills();
        if (skills != null && !skills.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String skillsJson = objectMapper.writeValueAsString(skills);
            newJobPost.setSkills(skillsJson); 
        } else {
            throw new CustomException("Job Post", "Skills cannot be null or empty");
        }

        jobPostRepo.save(newJobPost); 

        recruiter.getJobPosts().add(newJobPost);

        recruiterRep.save(recruiter);

    } catch (JsonProcessingException e) {
        throw new CustomException("Job Post", "Error processing JSON: " + e.getMessage());
    } catch (Exception e) {
        throw new CustomException("Job Post", "Error while saving job post: " + e.getMessage());
    }

    return jobPostDetailsDTO; 
}



public JobPostDetailsEntity toJobEntity(JobPostDetailsDTO jobPostDTO) {
	  JobPostDetailsEntity jobPost = new JobPostDetailsEntity();
jobPost.setJobTitle(jobPostDTO.getJobTitle());
jobPost.setJobDescription(jobPostDTO.getJobDescription());
jobPost.setMinimumExperience(jobPostDTO.getMinimumExperience());
jobPost.setMaximumExperience(jobPostDTO.getMaximumExperience());
jobPost.setMinimumSalary(jobPostDTO.getMinimumSalary());
jobPost.setMaximumSalary(jobPostDTO.getMaximumSalary());
jobPost.setQualification(jobPostDTO.getQualification());
jobPost.setSpecialization(jobPostDTO.getSpecialization());
jobPost.setLocation(jobPostDTO.getLocation());
jobPost.setIndustryType(jobPostDTO.getIndustryType());
jobPost.setJobType(jobPostDTO.getJobType());
jobPost.setSkills(jobPost.getSkills());
return jobPost;
}

public JobPostDetailsDTO toJobDto(JobPostDetailsEntity jobPost){
	JobPostDetailsDTO jobPostdto = new JobPostDetailsDTO();
jobPost.setJobTitle(jobPost.getJobTitle());
jobPost.setJobDescription(jobPost.getJobDescription());
jobPost.setMinimumExperience(jobPost.getMinimumExperience());
jobPost.setMaximumExperience(jobPost.getMaximumExperience());
jobPost.setMinimumSalary(jobPost.getMinimumSalary());
jobPost.setMaximumSalary(jobPost.getMaximumSalary());
jobPost.setQualification(jobPost.getQualification());
jobPost.setSpecialization(jobPost.getSpecialization());
jobPost.setLocation(jobPost.getLocation());
jobPost.setIndustryType(jobPost.getIndustryType());
jobPost.setJobType(jobPost.getJobType());
jobPost.setSkills(jobPost.getSkills());
return jobPostdto;
}

}

