package Talent.TalentStreamApplication.Dto;
import Talent.TalentStreamApplication.validation.CompanyNameValidator;
import Talent.TalentStreamApplication.validation.MobileNumberValidator;
import Talent.TalentStreamApplication.validation.PasswordValidator;
import Talent.TalentStreamApplication.validation.UniqueEmailValidator;

public class RecruiterDTO {
	
@CompanyNameValidator	
private String companyname;

@UniqueEmailValidator
private String email;

@MobileNumberValidator
private String mobileNumber;

@PasswordValidator
private String password;

	public RecruiterDTO(String companyname, String email, String mobileNumber, String password) {
		this.companyname = companyname;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	public RecruiterDTO() {
	}
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
