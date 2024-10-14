package Talent.TalentStreamApplication.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
@Entity
public class JobPostDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String jobTitle;

	private String jobDescription; 
	private int  minimumExperience;
	private int maximumExperience;

	private double minimumSalary;

	private double maximumSalary;	
	private String qualification;

	private String specialization;

	private String location;

	private String industryType;
	
	private String jobType;

	@NotNull
	@Column(columnDefinition = "json")
	private String skills;



        public String getJobTitle() {
			return jobTitle;
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		public String getJobDescription() {
			return jobDescription;
		}

		public void setJobDescription(String jobDescription) {
			this.jobDescription = jobDescription;
		}

		public int getMinimumExperience() {
			return minimumExperience;
		}

		public void setMinimumExperience(int minimumExperience) {
			this.minimumExperience = minimumExperience;
		}

		public int getMaximumExperience() {
			return maximumExperience;
		}

		public void setMaximumExperience(int maximumExperience) {
			this.maximumExperience = maximumExperience;
		}

		

		public double getMinimumSalary() {
			return minimumSalary;
		}

		public void setMinimumSalary(double minimumSalary) {
			this.minimumSalary = minimumSalary;
		}

		public double getMaximumSalary() {
			return maximumSalary;
		}

		public void setMaximumSalary(double maximumSalary) {
			this.maximumSalary = maximumSalary;
		}

		public String getQualification() {
			return qualification;
		}

		public void setQualification(String qualification) {
			this.qualification = qualification;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getIndustryType() {
			return industryType;
		}

		public void setIndustryType(String industryType) {
			this.industryType = industryType;
		}

		public String getJobType() {
			return jobType;
		}

		public void setJobType(String jobType) {
			this.jobType = jobType;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSkills() {
			return skills;
		}

		public void setSkills(String skills) {
			this.skills = skills;
		}

	
}


