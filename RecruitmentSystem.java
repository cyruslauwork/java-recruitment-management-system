package rms;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class RecruitmentSystem {
	public void displayAllCandidates() {
		try {
			Connection conn = DatabaseConnector.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");
			while (rs.next()) {
				System.out.println(rs.getString("name") + " | " + rs.getString("email") + " | " + rs.getString("phone")
						+ " | " + rs.getString("address") + " | " + rs.getString("education") + " | "
						+ rs.getString("work_experience") + " | " + rs.getString("skills"));
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
					.prepareStatement("SELECT * FROM job_descriptions WHERE post_date BETWEEN ? AND ?");
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("job_title") + " | " + rs.getString("job_description") + " | "
						+ rs.getString("job_responsibilities") + " | " + rs.getString("job_requirements") + " | "
						+ rs.getString("salary") + " | " + rs.getString("post_date"));
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
					"INSERT INTO job_descriptions (job_title, job_description, job_responsibilities, job_requirements, salary, post_date) VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, jobDescription.getJobTitle());
			pstmt.setString(2, jobDescription.getJobDescription());
			pstmt.setString(3, jobDescription.getJobResponsibilities());
			pstmt.setString(4, jobDescription.getJobRequirements());
			pstmt.setString(5, jobDescription.getJobSalary());
			pstmt.setDate(6, java.sql.Date.valueOf(jobDescription.getPostDate()));
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int countJobDescriptions(String keyword) throws SQLException {
		String sql = "SELECT COUNT(*) FROM job_descriptions WHERE description LIKE '%" + keyword + "%'";
		try (Connection conn = DatabaseConnector.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}
	}

	public void getJobApplicationHistory(String applicantId) throws SQLException {
		try {

			Connection conn = DatabaseConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM applications WHERE candidate_id = ? ");
			pstmt.setString(1, applicantId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getDate("apply_date") + " | " + rs.getString("candidate_id") + " | "
						+ rs.getString("job_id"));
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
        	String sql = "SELECT count(*) count FROM Job_Descriptions WHERE job_title LIKE '%" + searchCriterion + "%'";
	        Connection conn = DatabaseConnector.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	            System.out.println("Number of job descriptions that match: " + rs.getString("count"));
	        }
	        conn.close();
	    } catch (SQLException e) {
	    }
	}

	public void displayJobsMatchingResults() {
		try {
			String sql = "SELECT Candidates.name, Candidates.skills, JobDescriptions.job_title FROM Candidates JOIN JobDescriptions ON"
					+ "Candidates.skills LIKE CONCAT('%', JobDescriptions.job_title, '%')"
					+ "OR Candidates.skills LIKE CONCAT('%', JobDescriptions.job_description, '%')"
					+ "OR Candidates.skills LIKE CONCAT('%', JobDescriptions.job_responsibilities, '%')"
					+ "OR Candidates.skills LIKE CONCAT('%', JobDescriptions.job_requirements, '%')";
			Connection conn = DatabaseConnector.getConnection();
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("Candidates.name") + " | " + rs.getString("Candidates.skills") + " | "
						+ rs.getString("JobDescriptions.job_title"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
