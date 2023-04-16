- Create MySQL DB locally

For Win:

```bash
mysql -u root -h localhost
create database recruitment_db;
SHOW databases;
create user 'username' identified by 'password';
SELECT user FROM mysql.user;
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system mysql -u username -p;
```

For Mac:

```bash
/./Applications/XAMPP/xamppfiles/bin/mysql -u root -h localhost
create database recruitment_db;
SHOW databases;
create user 'username' identified by 'password';
SELECT user FROM mysql.user;
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system /./Applications/XAMPP/xamppfiles/bin/mysql -u username -p;
```

Then, run RecruitmentManagementSystem.java to create tables.

- Insert Employer Data

```sql
USE recruitment_db;
INSERT INTO Employers values (1, 'PwC', 'recruit@pwc.com', 30003000, 'Hong Kong', 'PwC Limited', 'Accounting');
INSERT INTO Employers values (2, 'Deloitte', 'recruit@deloitte.com', 30003000, 'Hong Kong', 'Deloitte Limited', 'Accounting');
INSERT INTO Employers values (3, 'KMPG', 'recruit@kmpg.com', 30003000, 'Hong Kong', 'KMPG Limited', 'Accounting');
INSERT INTO Employers values (4, 'Oracle', 'recruit@oracle.com', 30003000, 'USA', 'Oracle Corporation', 'Information Technology, Software');
INSERT INTO Employers values (5, 'Python Software Foundation', 'recruit@python.com', 30003000, 'USA', 'Python Software Foundation', 'Information Technology, Software');

INSERT INTO Candidates VALUES (1, "John Smith", "john.smith@email.com", "555-1234", "123 Main St. Anytown, USA", "Bachelor's Degree in Computer Science", "5 years of experience as a software developer", "Software");
INSERT INTO Candidates VALUES (2, "Sarah Johnson", "sarahj@gmail.com", "555-5678", "456 Oak Ave. Anytown, USA", "Master's Degree in Marketing", "3 years of experience in digital marketing", "SEO, SEM, Google Analytics");
INSERT INTO Candidates VALUES (3, "Michael Brown", "mbrown@email.com", "555-9876", "789 Maple St. Anytown, USA", "Bachelor's Degree in Business Administration", "7 years of experience in project management", "PMP certified, Agile, Scrum");
INSERT INTO Candidates VALUES (4, "Emily Davis", "emilydavis@yahoo.com", "555-4321", "321 Elm St. Anytown, USA", "Bachelor's Degree in Accounting", "2 years of experience in public accounting", "Accounting, GAAP, QuickBooks, Tax Preparation");
INSERT INTO Candidates VALUES (5, "David Lee", "dlee@email.com", "555-8765", "654 Pine St. Anytown, USA", "Bachelor's Degree in Business Administration", "4 years of experience as a sales representative", "Relationship Building, Cold Calling, Negotiation");
INSERT INTO Candidates VALUES (6, "Rachel Kim", "rachel.kim@email.com", "555-2468", "246 Cherry St. Anytown, USA", "Master's Degree in Human Resources", "6 years of experience in employee relations", "Performance Management, Conflict Resolution, Training and Development");
INSERT INTO Candidates VALUES (7, "James Wilson", "james.wilson@gmail.com", "555-3698", "369 Cedar St. Anytown, USA", "Bachelor's Degree in Computer Science", "3 years of experience as a software engineer", "Software");
INSERT INTO Candidates VALUES (8, "Jessica Garcia", "jessica.garcia@email.com", "555-1357", "135 Oak St. Anytown, USA", "Bachelor's Degree in Graphic Design", "4 years of experience in branding and advertising", "Adobe Creative Suite, Branding, Typography");
INSERT INTO Candidates VALUES (9, "Ryan Taylor", "ryan.taylor@email.com", "555-7890", "789 Maple St. Anytown, USA", "Master's Degree in Finance", "5 years of experience in investment banking", "Financial Modeling, Valuation, Mergers and Acquisitions, Accounting");
INSERT INTO Candidates VALUES (10, "Lauren Nguyen", "lauren.nguyen@email.com", "555-8642", "864 Pine St. Anytown, USA", "Bachelor's Degree in Marketing", "1 year of experience in social media marketing", "Content Creation, Social Media Advertising, Analytics,");

INSERT INTO JobDescriptions VALUES (1, "Software Engineer", "Seeking a highly skilled software engineer to develop and maintain software applications", "Design and implement software solutions", "Bachelor's degree in Computer Science or related field", "80000", "2022-04-11", 1);
INSERT INTO JobDescriptions VALUES (2, "Marketing Coordinator", "Looking for a creative marketing coordinator to assist with the development and implementation of marketing strategies", "Develop marketing materials and campaigns", "Bachelor's degree in Marketing or related field", "50000", "2022-04-10", 2);
INSERT INTO JobDescriptions VALUES (3, "Human Resources Manager", "Seeking an experienced human resources manager to oversee all HR functions", "Develop and implement HR policies and procedures", "Bachelor's degree in Human Resources or related field", "90000", "2022-04-09", 3);
INSERT INTO JobDescriptions VALUES (4, "Graphic Designer", "Looking for a talented graphic designer to create visual designs for various projects", "Develop design concepts and layouts", "Bachelor's degree in Graphic Design or related field", "60000", "2023-04-08", 4);
INSERT INTO JobDescriptions VALUES (5, "Project Manager", "Seeking a skilled project manager to oversee projects from start to finish", "Develop project plans and timelines", "Bachelor's degree in Business Administration or related field", "85000", "2023-04-07", 5);
INSERT INTO JobDescriptions VALUES (6, "Software Developer", "Looking for an experienced software developer to design, develop and maintain software applications", "Write clean and efficient code", "Bachelor's degree in Computer Science or related field", "90000", "2023-04-06", 1);
INSERT INTO JobDescriptions VALUES (7, "Social Media Specialist", "Seeking a creative social media specialist to manage and grow social media accounts", "Develop and implement social media strategies", "Bachelor's degree in Marketing or related field", "50000", "2023-04-05", 2);
INSERT INTO JobDescriptions VALUES (8, "Accountant", "Looking for an experienced accountant to manage financial records and transactions", "Prepare financial reports and statements", "Bachelor's degree in Accounting or related field", "70000", "2023-04-04", 3);
INSERT INTO JobDescriptions VALUES (9, "Business Analyst", "Looking for a skilled business analyst to analyze business operations and recommend improvements", "Develop business requirements and specifications", "Bachelor's degree in Business Administration or related field", "75000", "2023-04-02", 4);
INSERT INTO JobDescriptions VALUES (10, "UX/UI Designer", "Seeking a talented UX/UI designer to design and develop user interfaces for various platforms", "Develop design concepts and wireframes", "Bachelor's degree in Graphic Design or related field", "70000", "2023-04-01", 5);
INSERT INTO JobDescriptions VALUES (11, "Data Analyst", "Looking for a skilled data analyst to analyze and interpret complex data sets", "Develop data models and visualizations", "Bachelor's degree in Mathematics, Statistics or related field", "80000", "2023-03-31", 1);

INSERT INTO Applications VALUES (1, "2023-04-11", 1, 1);
INSERT INTO Applications VALUES (2, "2023-04-10", 2, 1);
INSERT INTO Applications VALUES (3, "2023-04-09", 3, 2);
INSERT INTO Applications VALUES (4, "2023-04-08", 4, 2);
INSERT INTO Applications VALUES (5, "2023-04-07", 5, 3);
INSERT INTO Applications VALUES (6, "2023-04-06", 6, 3);
INSERT INTO Applications VALUES (7, "2023-04-05", 7, 4);
INSERT INTO Applications VALUES (8, "2023-04-04", 8, 4);
INSERT INTO Applications VALUES (9, "2023-04-03", 9, 5);
INSERT INTO Applications VALUES (10, "2023-04-02", 10, 5);
INSERT INTO Applications VALUES (11, "2023-04-01", 1, 6);
INSERT INTO Applications VALUES (12, "2023-03-31", 2, 6);
INSERT INTO Applications VALUES (13, "2023-03-30", 3, 7);
INSERT INTO Applications VALUES (14, "2023-03-29", 4, 7);
INSERT INTO Applications VALUES (15, "2023-03-28", 5, 8);
INSERT INTO Applications VALUES (16, "2023-03-27", 6, 8);
INSERT INTO Applications VALUES (17, "2023-03-26", 7, 9);
INSERT INTO Applications VALUES (18, "2023-03-25", 8, 9);
INSERT INTO Applications VALUES (19, "2023-03-24", 9, 10);
INSERT INTO Applications VALUES (20, "2023-03-23", 10, 10);
```
