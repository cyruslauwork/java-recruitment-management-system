package rms;

public class JobDescription {
	private String jobTitle, jobDescription, jobResponsibilities, jobRequirements, salary, postdate;
	public void setJobTitle(String jT) {
		jobTitle = jT;
	}
	public void setJobDescription(String jD) {
		jobDescription = jD;
	}
	public void setJobResponsibilities(String jRs) {
		jobResponsibilities = jRs;
	}
	public void setJobRequirements(String jRq) {
		jobRequirements = jRq;
	}
	public void setJobSalary(String s) {
		salary = s;
	}
	public void setPostDate(String d) {
		postdate = d;
	}
	public String getJobTitle() {
		return this.jobTitle;
	}
	public String getJobDescription() {
		return this.jobDescription;
	}
	public String getJobResponsibilities() {
		return this.jobResponsibilities;
	}
	public String getJobRequirements() {
		return this.jobRequirements;
	}
	public String getJobSalary() {
		return this.salary;
	}
	public String getPostDate() {
		return this.postdate;
	}
	

}
