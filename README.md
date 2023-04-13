- Create MySQL DB locally

For Win:

```bash
mysql -u root -h localhost
create database recruitment_db;
create user 'username' identified by 'password';
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system mysql -u username -p;
```

For MacOS:

```bash
/./Applications/XAMPP/xamppfiles/bin/mysql -u root -h localhost
create database recruitment_db;
create user 'username' identified by 'password';
grant all privileges on recruitment_db.* to 'username';
FLUSH PRIVILEGES;
system /./Applications/XAMPP/xamppfiles/bin/mysql -u username -p;
```

- Insert Employer Data

```bash
use recruitment_db;
insert into Employers values (1, 'PwC', 'recruit@pwc.com', 30003000, 'Hong Kong', 'PwC Limited', 'Accounting');
insert into Employers values (2, 'Deloitte', 'recruit@deloitte.com', 30003000, 'Hong Kong', 'Deloitte Limited', 'Accounting');
insert into Employers values (3, 'KMPG', 'recruit@kmpg.com', 30003000, 'Hong Kong', 'KMPG Limited', 'Accounting');
insert into Employers values (4, 'Oracle', 'recruit@oracle.com', 30003000, 'USA', 'Oracle Corporation', 'JavaScript');
insert into Employers values (5, 'Python Software Foundation', 'recruit@python.com', 30003000, 'Hong Kong', 'Python Software Foundation', 'Python');

INSERT INTO Candidates VALUES (1," John Smith "," john.smith@email.com "," 555-1234 "," 123 Main St. Anytown, USA "," Bachelor's Degree in Computer Science "," 5 years of experience as a software developer "," Java, Python, JavaScript");
INSERT INTO Candidates VALUES (2," Sarah Johnson "," sarahj@gmail.com "," 555-5678 "," 456 Oak Ave. Anytown, USA "," Master's Degree in Marketing "," 3 years of experience in digital marketing "," SEO, SEM, Google Analytics");
INSERT INTO Candidates VALUES (3," Michael Brown "," mbrown@email.com "," 555-9876 "," 789 Maple St. Anytown, USA "," Bachelor's Degree in Business Administration "," 7 years of experience in project management "," PMP certified, Agile, Scrum");
INSERT INTO Candidates VALUES (4," Emily Davis "," emilydavis@yahoo.com "," 555-4321 "," 321 Elm St. Anytown, USA "," Bachelor's Degree in Accounting "," 2 years of experience in public accounting "," GAAP, QuickBooks, Tax Preparation");
INSERT INTO Candidates VALUES (5," David Lee "," dlee@email.com "," 555-8765 "," 654 Pine St. Anytown, USA "," Bachelor's Degree in Business Administration "," 4 years of experience as a sales representative "," Relationship Building, Cold Calling, Negotiation");
INSERT INTO Candidates VALUES (6," Rachel Kim "," rachel.kim@email.com "," 555-2468 "," 246 Cherry St. Anytown, USA "," Master's Degree in Human Resources "," 6 years of experience in employee relations "," Performance Management, Conflict Resolution, Training and Development");
INSERT INTO Candidates VALUES (7," James Wilson "," james.wilson@gmail.com "," 555-3698 "," 369 Cedar St. Anytown, USA "," Bachelor's Degree in Computer Science "," 3 years of experience as a software engineer "," C++, Java, SQL");
INSERT INTO Candidates VALUES (8," Jessica Garcia "," jessica.garcia@email.com "," 555-1357 "," 135 Oak St. Anytown, USA "," Bachelor's Degree in Graphic Design "," 4 years of experience in branding and advertising "," Adobe Creative Suite, Branding, Typography");
INSERT INTO Candidates VALUES (9," Ryan Taylor "," ryan.taylor@email.com "," 555-7890 "," 789 Maple St. Anytown, USA "," Master's Degree in Finance "," 5 years of experience in investment banking "," Financial Modeling, Valuation, Mergers and Acquisitions");
INSERT INTO Candidates VALUES (10," Lauren Nguyen "," lauren.nguyen@email.com "," 555-8642 "," 864 Pine St. Anytown, USA "," Bachelor's Degree in Marketing "," 1 year of experience in social media marketing "," Content Creation, Social Media Advertising, Analytics");

```
