-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 16, 2023 at 04:02 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recruitment_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `Applications`
--

CREATE TABLE `Applications` (
  `id` int(11) NOT NULL,
  `apply_date` date DEFAULT NULL,
  `candidate_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Applications`
--

INSERT INTO `Applications` (`id`, `apply_date`, `candidate_id`, `job_id`) VALUES
(1, '2023-04-11', 1, 1),
(2, '2023-04-10', 2, 1),
(3, '2023-04-09', 3, 2),
(4, '2023-04-08', 4, 2),
(5, '2023-04-07', 5, 3),
(6, '2023-04-06', 6, 3),
(7, '2023-04-05', 7, 4),
(8, '2023-04-04', 8, 4),
(9, '2023-04-03', 9, 5),
(10, '2023-04-02', 10, 5),
(11, '2023-04-01', 1, 6),
(12, '2023-03-31', 2, 6),
(13, '2023-03-30', 3, 7),
(14, '2023-03-29', 4, 7),
(15, '2023-03-28', 5, 8),
(16, '2023-03-27', 6, 8),
(17, '2023-03-26', 7, 9),
(18, '2023-03-25', 8, 9),
(19, '2023-03-24', 9, 10),
(20, '2023-03-23', 10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `Candidates`
--

CREATE TABLE `Candidates` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `work_experience` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Candidates`
--

INSERT INTO `Candidates` (`id`, `name`, `email`, `phone`, `address`, `education`, `work_experience`, `skills`) VALUES
(1, 'John Smith', 'john.smith@email.com', '555-1234', '123 Main St. Anytown, USA', 'Bachelor\'s Degree in Computer Science', '5 years of experience as a software developer', 'Software, Information Technology, Java, Python, JavaScript'),
(2, 'Sarah Johnson', 'sarahj@gmail.com', '555-5678', '456 Oak Ave. Anytown, USA', 'Master\'s Degree in Marketing', '3 years of experience in digital marketing', 'SEO, SEM, Google Analytics'),
(3, 'Michael Brown', 'mbrown@email.com', '555-9876', '789 Maple St. Anytown, USA', 'Bachelor\'s Degree in Business Administration', '7 years of experience in project management', 'PMP certified, Agile, Scrum'),
(4, 'Emily Davis', 'emilydavis@yahoo.com', '555-4321', '321 Elm St. Anytown, USA', 'Bachelor\'s Degree in Accounting', '2 years of experience in public accounting', 'Accounting, GAAP, QuickBooks, Tax Preparation'),
(5, 'David Lee', 'dlee@email.com', '555-8765', '654 Pine St. Anytown, USA', 'Bachelor\'s Degree in Business Administration', '4 years of experience as a sales representative', 'Relationship Building, Cold Calling, Negotiation'),
(6, 'Rachel Kim', 'rachel.kim@email.com', '555-2468', '246 Cherry St. Anytown, USA', 'Master\'s Degree in Human Resources', '6 years of experience in employee relations', 'Performance Management, Conflict Resolution, Training and Development'),
(7, 'James Wilson', 'james.wilson@gmail.com', '555-3698', '369 Cedar St. Anytown, USA', 'Bachelor\'s Degree in Computer Science', '3 years of experience as a software engineer', 'Software, Information Technology, C++, Java, SQL'),
(8, 'Jessica Garcia', 'jessica.garcia@email.com', '555-1357', '135 Oak St. Anytown, USA', 'Bachelor\'s Degree in Graphic Design', '4 years of experience in branding and advertising', 'Adobe Creative Suite, Branding, Typography'),
(9, 'Ryan Taylor', 'ryan.taylor@email.com', '555-7890', '789 Maple St. Anytown, USA', 'Master\'s Degree in Finance', '5 years of experience in investment banking', 'Financial Modeling, Valuation, Mergers and Acquisitions, Accounting'),
(10, 'Lauren Nguyen', 'lauren.nguyen@email.com', '555-8642', '864 Pine St. Anytown, USA', 'Bachelor\'s Degree in Marketing', '1 year of experience in social media marketing', 'Content Creation, Social Media Advertising, Analytics,');

-- --------------------------------------------------------

--
-- Table structure for table `Employers`
--

CREATE TABLE `Employers` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Employers`
--

INSERT INTO `Employers` (`id`, `name`, `email`, `phone`, `address`, `description`, `industry`) VALUES
(1, 'PwC', 'recruit@pwc.com', '30003000', 'Hong Kong', 'PwC Limited', 'Accounting'),
(2, 'Deloitte', 'recruit@deloitte.com', '30003000', 'Hong Kong', 'Deloitte Limited', 'Accounting'),
(3, 'KMPG', 'recruit@kmpg.com', '30003000', 'Hong Kong', 'KMPG Limited', 'Accounting'),
(4, 'Oracle', 'recruit@oracle.com', '30003000', 'USA', 'Oracle Corporation', 'Information Technology, Software'),
(5, 'Python Software Foundation', 'recruit@python.com', '30003000', 'USA', 'Python Software Foundation', 'Information Technology, Software');

-- --------------------------------------------------------

--
-- Table structure for table `JobDescriptions`
--

CREATE TABLE `JobDescriptions` (
  `id` int(11) NOT NULL,
  `job_title` varchar(50) DEFAULT NULL,
  `job_description` text DEFAULT NULL,
  `job_responsibilities` text DEFAULT NULL,
  `job_requirements` text DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `post_date` date DEFAULT NULL,
  `employer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `JobDescriptions`
--

INSERT INTO `JobDescriptions` (`id`, `job_title`, `job_description`, `job_responsibilities`, `job_requirements`, `salary`, `post_date`, `employer_id`) VALUES
(1, 'Software Engineer', 'Seeking a highly skilled software engineer to develop and maintain software applications', 'Design and implement software solutions', 'Bachelor\'s degree in Computer Science or related field', '80000.00', '2022-04-11', 1),
(2, 'Marketing Coordinator', 'Looking for a creative marketing coordinator to assist with the development and implementation of marketing strategies', 'Develop marketing materials and campaigns', 'Bachelor\'s degree in Marketing or related field', '50000.00', '2022-04-10', 2),
(3, 'Human Resources Manager', 'Seeking an experienced human resources manager to oversee all HR functions', 'Develop and implement HR policies and procedures', 'Bachelor\'s degree in Human Resources or related field', '90000.00', '2022-04-09', 3),
(4, 'Graphic Designer', 'Looking for a talented graphic designer to create visual designs for various projects', 'Develop design concepts and layouts', 'Bachelor\'s degree in Graphic Design or related field', '60000.00', '2023-04-08', 4),
(5, 'Project Manager', 'Seeking a skilled project manager to oversee projects from start to finish', 'Develop project plans and timelines', 'Bachelor\'s degree in Business Administration or related field', '85000.00', '2023-04-07', 5),
(6, 'Software Developer', 'Looking for an experienced software developer to design, develop and maintain software applications', 'Write clean and efficient code', 'Bachelor\'s degree in Computer Science or related field', '90000.00', '2023-04-06', 1),
(7, 'Social Media Specialist', 'Seeking a creative social media specialist to manage and grow social media accounts', 'Develop and implement social media strategies', 'Bachelor\'s degree in Marketing or related field', '50000.00', '2023-04-05', 2),
(8, 'Accountant', 'Looking for an experienced accountant to manage financial records and transactions', 'Prepare financial reports and statements', 'Bachelor\'s degree in Accounting or related field', '70000.00', '2023-04-04', 3),
(9, 'Business Analyst', 'Looking for a skilled business analyst to analyze business operations and recommend improvements', 'Develop business requirements and specifications', 'Bachelor\'s degree in Business Administration or related field', '75000.00', '2023-04-02', 4),
(10, 'UX/UI Designer', 'Seeking a talented UX/UI designer to design and develop user interfaces for various platforms', 'Develop design concepts and wireframes', 'Bachelor\'s degree in Graphic Design or related field', '70000.00', '2023-04-01', 5),
(11, 'Data Analyst', 'Looking for a skilled data analyst to analyze and interpret complex data sets', 'Develop data models and visualizations', 'Bachelor\'s degree in Mathematics, Statistics or related field', '80000.00', '2023-03-31', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Applications`
--
ALTER TABLE `Applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `candidate_id` (`candidate_id`),
  ADD KEY `job_id` (`job_id`);

--
-- Indexes for table `Candidates`
--
ALTER TABLE `Candidates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Employers`
--
ALTER TABLE `Employers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `JobDescriptions`
--
ALTER TABLE `JobDescriptions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employer_id` (`employer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Candidates`
--
ALTER TABLE `Candidates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `Employers`
--
ALTER TABLE `Employers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Applications`
--
ALTER TABLE `Applications`
  ADD CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `Candidates` (`id`),
  ADD CONSTRAINT `applications_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `JobDescriptions` (`id`);

--
-- Constraints for table `JobDescriptions`
--
ALTER TABLE `JobDescriptions`
  ADD CONSTRAINT `jobdescriptions_ibfk_1` FOREIGN KEY (`employer_id`) REFERENCES `Employers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
