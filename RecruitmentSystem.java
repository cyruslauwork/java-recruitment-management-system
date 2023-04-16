package rms;

import java.sql.*;
import java.sql.Date;
//import java.util.*;

public class RecruitmentSystem {
	String case1 = "";
	String case2 = "";
	String case3 = "";
	String case5 = "";
	String case6 = "";
	String case8 = "";
	public void displayAllCandidates() {
		try {
			Connection conn = DatabaseConnector.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");
			while (rs.next()) {
				System.out.println(rs.getString("name") + " | " + rs.getString("email") + " | " + rs.getString("phone")
						+ " | " + rs.getString("address") + " | " + rs.getString("education") + " | "
						+ rs.getString("work_experience") + " | " + rs.getString("skills"));
				case1 = case1 + 						
						"Name: "+ rs.getString("name") +"\n"+ 
						"email: "+rs.getString("email") +"\n"+
						"phone: "+ rs.getString("phone") +"\n"+
						"addres s: "+ rs.getString("address") +"\n"+
						"education: "+ rs.getString("education") +"\n"+
						"Work Experience: "+ rs.getString("work_experience") +"\n"+
						"skills: "+ rs.getString("skills") +"\n"+
						"\n";
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayAllEmployers() {
		try {
			Connection conn = DatabaseConnector.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employers");
			while (rs.next()) {
				System.out.println(rs.getString("name") + " | " + rs.getString("email") + " | " + rs.getString("phone")
						+ " | " + rs.getString("address") + " | " + rs.getString("description") + " | "
						+ rs.getString("industry"));
				case2 = case2 + 						
						"Name: "+ rs.getString("name") +"\n"+ 
						"email: "+rs.getString("email") +"\n"+
						"phone: "+ rs.getString("phone") +"\n"+
						"address: "+ rs.getString("address") +"\n"+
						"Description: "+ rs.getString("description") +"\n"+
						"Industry: "+ rs.getString("industry") +"\n"+
						"\n";
						

				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayJobDescriptionsInRange(Date startDate, Date endDate) {
		try {
			Connection conn = DatabaseConnector.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM JobDescriptions WHERE post_date BETWEEN ? AND ?");
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("job_title") + " | " + rs.getString("job_description") + " | "
						+ rs.getString("job_responsibilities") + " | " + rs.getString("job_requirements") + " | "
						+ rs.getString("salary") + " | " + rs.getString("post_date"));
				case3 = case3 + 						
						"Job Title: "+ rs.getString("job_title") +"\n"+ 
						"Job Description: "+rs.getString("job_description") +"\n"+
						"Job Responsibilities: "+ rs.getString("job_responsibilities") +"\n"+
						"Job_requirements: "+ rs.getString("job_requirements") +"\n"+
						"Salary: "+ rs.getString("salary") +"\n"+
						"Post Date: "+ rs.getString("post_date") +"\n"+
						"\n";
						

				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void postJobDescription(JobDescription jobDescription) {
		try {
			Connection conn = DatabaseConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO jobdescriptions (id, job_title, job_description, job_responsibilities, job_requirements, salary, post_date) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, countJobDescriptions("")+1);
			pstmt.setString(2, jobDescription.getJobTitle());
			pstmt.setString(3, jobDescription.getJobDescription());
			pstmt.setString(4, jobDescription.getJobResponsibilities());
			pstmt.setString(5, jobDescription.getJobRequirements());
			pstmt.setString(6, jobDescription.getJobSalary());
			pstmt.setDate(7, java.sql.Date.valueOf(jobDescription.getPostDate()));
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int countJobDescriptions(String keyword) throws SQLException {
		String sql = "SELECT COUNT(*) FROM JobDescriptions WHERE job_description LIKE '%" + keyword + "%'";
		try (Connection conn = DatabaseConnector.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}
	}

	public void getJobApplicationHistory(String candidateKey) throws SQLException {
		try {

			Connection conn = DatabaseConnector.getConnection();
      
			boolean isInteger;
			
			try {
				Integer.valueOf(candidateKey);
				isInteger=true;
			} catch(Exception e) {
				isInteger=false;
			}
			
			ResultSet rs;
			
			if(isInteger) {
			//Search by Candidate ID
			PreparedStatement pstmt = conn.prepareStatement("select a.apply_date,c.name,j.job_title "
					+ "from applications a "
					+ "inner join candidates c "
					+ "inner join jobdescriptions j "
					+ "on a.candidate_id=c.id AND a.job_id=j.id AND a.candidate_id=? "
					+ "order by a.apply_date desc;");
			pstmt.setString(1, candidateKey);
			rs = pstmt.executeQuery();
			
			} else {
				
			// Search by Candidate Name
			PreparedStatement pstmt2 = conn.prepareStatement("select a.apply_date,c.name,j.job_title "
					+ "from applications a "
					+ "inner join candidates c "
					+ "inner join jobdescriptions j "
					+ "on a.candidate_id=c.id AND a.job_id=j.id AND c.name like "+"\"%"+candidateKey+"%\""
					+ "order by a.apply_date desc;");
			
			System.out.println(pstmt2);
			rs = pstmt2.executeQuery();
			
			}
      
			case6 = case6 + "---------------------------------------------------------------------------------------------------\n";
      
			while (rs.next()) {
				System.out.println(rs.getDate("apply_date") + " | " 
								+ rs.getString("name") + " | "
								+ rs.getString("job_title"));
				case6 = case6 + 
						"Application Date:	"+rs.getDate("apply_date")+"\n"+ 
						"Candidate Name:	"+ rs.getString("name") +"\n"+
						"Job Title:	"+ rs.getString("job_title") +"\n"+
						"\n";
			}
      
			conn.close();

		} catch (Exception e) {
		}

	}

	public void updateSystemDate(String newDate) throws SQLException {
		String sql = "UPDATE system_date SET date = ?";
		try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, newDate);
			stmt.executeUpdate();
		} catch (SQLException e) {

		}
	}
	
	public void countMatchingJobDescriptions(String searchCriterion) throws SQLException {
        try {
        	String sql = "SELECT count(*) count FROM JobDescriptions WHERE job_title LIKE '%" + searchCriterion + "%'";
	        Connection conn = DatabaseConnector.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	            System.out.println("Number of job descriptions that match: " + rs.getString("count"));
	            case5 = "Number of job descriptions that match: " + rs.getString("count");
	        }
	        conn.close();
	    } catch (SQLException e) {
	    }
	}

	public void displayJobsMatchingResults() {
		try {
			String sql =
					"SELECT Candidates.name, Candidates.skills, JobDescriptions.job_title, employers.name FROM Candidates inner JOIN JobDescriptions ON "+
							"(INSTR(JobDescriptions.job_description, Candidates.skills) > 0 " +
							"OR INSTR(JobDescriptions.job_title, Candidates.skills) > 0 " +
							"OR INSTR(JobDescriptions.job_responsibilities, Candidates.skills) > 0 " +
							"OR INSTR(JobDescriptions.job_requirements, Candidates.skills) > 0) " +
							"left join Employers on Employers.id = JobDescriptions.employer_id " +
							"order by Candidates.name";
			Connection conn = DatabaseConnector.getConnection();
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("Candidates.name") + " | " + rs.getString("Candidates.skills") + " | "
						+ rs.getString("JobDescriptions.job_title")+ " | "+ rs.getString("employers.name"));
				case8 = case8 + 						
						"Name:"+ rs.getString("Candidates.name") +"\n"+ 
						"Skills: "+rs.getString("Candidates.skills") +"\n"+
						"Job Title: "+ rs.getString("JobDescriptions.job_title") +"\n"+
						"Company Name "+ rs.getString("employers.name") +"\n"+
						"\n";

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}