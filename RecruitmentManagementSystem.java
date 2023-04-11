package rms;

import java.sql.*;
import java.util.*;

//LAU Ka Pui s226064
//Poon Tsz Ying s198137
//KWOK Yee Man	s216748
//YOUR_NAME YOUR_SID

public class RecruitmentManagementSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RecruitmentSystem recruitmentSystem = new RecruitmentSystem();

		DatabaseConnector.tablechecker();

		boolean quit = false;

		while (!quit) {
			System.out.println("Choose an option:");
			System.out.println("1 - Display all registered job applicants / candidates");
			System.out.println("2 - Display all registered employers");
			System.out.println("3 - Display all job descriptions in the system within a specific date range");
			System.out.println("4 - Post a job description in the system (by employer)");
			System.out.println("5 - Count the number of job descriptions that match a specific search criterion");
			System.out.println("6 - Display the job application history of an applicant");
			System.out.println("7 - Adjust the system date");
			System.out.println("8 - Match candidates to open requisitions");
			System.out.println("9 - Quit");

			int option = scanner.nextInt();
			scanner.nextLine(); // consume the newline character

			switch (option) {
			case 1:
				recruitmentSystem.displayAllCandidates();
				break;
			case 2:
				recruitmentSystem.displayAllEmployers();
				break;
			case 3:
				System.out.println("Enter start date (yyyy-MM-dd):");
				String startDate = scanner.nextLine();
				System.out.println("Enter end date (yyyy-MM-dd):");
				String endDate = scanner.nextLine();
				recruitmentSystem.displayJobDescriptionsInRange(java.sql.Date.valueOf(startDate),
						java.sql.Date.valueOf(endDate));
				break;
			case 4:
				JobDescription jD = new JobDescription();
				System.out.println("Enter job title:");
				String jobTitle = scanner.nextLine();
				System.out.println("Enter job description:");
				String jobDescription = scanner.nextLine();
				System.out.println("Enter job Responsibilities:");
				String jobResponsibilities = scanner.nextLine();
				System.out.println("Enter job Requirements:");
				String jobRequirements = scanner.nextLine();
				System.out.println("Enter job Salary:");
				String salary = scanner.nextLine();
				System.out.println("Enter Post date(yyyy-MM-dd):");
				String postdate = scanner.nextLine();
				boolean flag = false;
				while (!flag) {
					System.out.println("Please confirm the following information.");
					System.out.println("Job title:" + jobTitle + "\nJob description:" + jobDescription
							+ "\nJob Responsibilities:" + jobResponsibilities + "\nJob Requirements:" + jobRequirements
							+ "\nJob salary:" + salary + "\nPost Date:" + postdate);
					System.out.println("If confirm, enter (Yes):");
					if (scanner.next().equals("Yes")) {
						flag = true;

					} else {
						System.out.println("Please enter again.");
					}
				}

				jD.setJobTitle(jobTitle);
				jD.setJobDescription(jobDescription);
				jD.setJobResponsibilities(jobResponsibilities);
				jD.setJobRequirements(jobRequirements);
				jD.setJobSalary(salary);
				jD.setPostDate(postdate);
				recruitmentSystem.postJobDescription(jD);
				break;
			case 5:
                System.out.println("Enter search criterion:");
                String searchCriterion = scanner.nextLine();
			try {
				recruitmentSystem.countMatchingJobDescriptions(searchCriterion);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                break;
			case 6:
				System.out.println("Enter applicant ID:");
				int applicantId = scanner.nextInt();
				try {
					recruitmentSystem.getJobApplicationHistory(String.valueOf(applicantId));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 7:
				System.out.println("Enter new system date (yyyy-MM-dd):");
				String newSystemDate = scanner.nextLine();

				try {
					recruitmentSystem.updateSystemDate(newSystemDate);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				recruitmentSystem.displayJobsMatchingResults();
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("Invalid option. Try again.");
				break;

			}
		}

		scanner.close();
	}
}
