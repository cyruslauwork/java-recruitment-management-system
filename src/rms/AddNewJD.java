package rms;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddNewJD {
	RecruitmentSystem recruitmentSystem = new RecruitmentSystem();
	private JFrame ourFrame = new JFrame("Post a job description in the system (by employer)");
	
	void SignUpForm(){
		
		ourFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ourFrame.setBounds(200, 100, 500, 600);
		
		Container container = ourFrame.getContentPane();
		container.setLayout(null);
		
		JLabel logo = new JLabel("Post a job description in the system (by employer)");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(0,5,500,30);
		
		JLabel jt_label = new JLabel("Job Title :");
		jt_label.setBounds(20,30,300,30);
		
		JLabel jd_label = new JLabel("Job Description :");
		jd_label.setBounds(20,90,300,30);
		
		JLabel jr_label = new JLabel("Job Responsibilities :");
		jr_label.setBounds(20,150,300,30);
		
		JLabel jreq_label = new JLabel("Job Requirements :");
		jreq_label.setBounds(20,210,300,30);
		
		JLabel jsal_label = new JLabel("Job Salary :");
		jsal_label.setBounds(20,270,300,30);
		
		JLabel date_label = new JLabel("Enter Post date(yyyy-MM-dd) :");
		date_label.setBounds(20,330,300,30);
		
		
		
		JTextField jt = new JTextField();
		jt.setBounds(20,60,300,30);
		
		JTextField jd = new JTextField();
		jd.setBounds(20, 120, 300, 30);
		
		JTextField jr = new JTextField();
		jr.setBounds(20, 180, 300, 30);
		
		JTextField jreq = new JTextField();
		jreq.setBounds(20, 240, 300, 30);
		
		JTextField jsal = new JTextField();
		jsal.setBounds(20, 300, 300, 30);
		
		JTextField date = new JTextField();
		date.setBounds(20, 360, 300, 30);
		

		
		JButton subBtn  = new JButton("Subscribe");
		subBtn.setBounds(20,420,100,30);
		subBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobDescription jD = new JobDescription();
				jD.setJobTitle(jt.getText());
				jD.setJobDescription(jd.getText());
				jD.setJobResponsibilities(jr.getText());
				jD.setJobRequirements(jreq.getText());
				jD.setJobSalary(jsal.getText());
				jD.setPostDate(date.getText());
				recruitmentSystem.postJobDescription(jD);

			}
		});
		
		container.add(logo);
		container.add(jt_label);
		container.add(jd_label);
		container.add(jr_label);
		container.add(jreq_label);
		container.add(jsal_label);
		container.add(date_label);
		container.add(jt);
		container.add(jd);
		container.add(jr);
		container.add(jreq);
		container.add(jsal);
		container.add(date);
		container.add(subBtn);
		ourFrame.setVisible(true);
		
	}

}
