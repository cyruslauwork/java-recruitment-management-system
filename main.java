package rms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DropMode; 
//import javax.swing.SwingConstants; 


public class main {
	RecruitmentSystem rms = new RecruitmentSystem();

	private JFrame frame;
	private JTextField start;
	private JTextField end;
	private JTextField case5_key;
	private JTextField case6key;
	private JTextField case7key;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1311, 781);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 0, 1001, 742);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setTabSize(12);
		scrollPane.setViewportView(textArea);
//case 1		
		JButton btnCase1 = new JButton("1 - Display all registered job applicants / candidates");
		btnCase1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				rms.displayAllCandidates();
				textArea.setText(rms.case1);
				rms.case1 = "";
			}
		});
		btnCase1.setBounds(10, 27, 274, 23);
		frame.getContentPane().add(btnCase1);
//case2		
		JButton btnCase2 = new JButton("2 - Display all registered employers");
		btnCase2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				rms.displayAllEmployers();
				textArea.setText(rms.case2);
				rms.case2 = "";
			}
		});
		btnCase2.setBounds(10, 60, 274, 23);
		frame.getContentPane().add(btnCase2);
//case3		
		JLabel lblNewLabel = new JLabel(" Start Date (yyyy-MM-dd)");
		lblNewLabel.setBounds(20, 143, 173, 15);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblNewLabel2 = new JLabel(" End Date (yyyy-MM-dd)");
		lblNewLabel2.setBounds(20, 192, 173, 15);
		frame.getContentPane().add(lblNewLabel2);
		lblNewLabel2.setVisible(false);
		
		start = new JTextField();
		start.setBounds(10, 161, 206, 21);
		frame.getContentPane().add(start);
		start.setColumns(10);
		start.setVisible(false);
		
		JButton btnGo4 = new JButton("Go");
		btnGo4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {textArea.setText("");
			rms.displayJobDescriptionsInRange(java.sql.Date.valueOf(start.getText()),
					java.sql.Date.valueOf(end.getText()));
			textArea.setText(rms.case3);
			rms.case3 = "";
			}
		});
		btnGo4.setBounds(214, 205, 70, 23);
		frame.getContentPane().add(btnGo4);
		btnGo4.setVisible(false);
		
		end = new JTextField();
		end.setColumns(10);
		end.setBounds(10, 206, 206, 21);
		frame.getContentPane().add(end);
		end.setVisible(false);
		
		
		
		JButton btnCase3 = new JButton("3 - Display all job descriptions in the system within a specific date range");
		btnCase3.setText("<html><center>"+"3 - Display all job descriptions in the system"+"<br>"+" within a specific date range"+"</center></html>");
		btnCase3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				lblNewLabel2.setVisible(true);
				start.setVisible(true);
				end.setVisible(true);
				btnGo4.setVisible(true);
				
			}
		});
		btnCase3.setBounds(10, 93, 274, 48);
		frame.getContentPane().add(btnCase3);
		

//case4		
		JButton btnCase4 = new JButton("4 - Post a job description in the system (by employer)");
		btnCase4.setText("<html><center>"+"4 - Post a job description in the system "+"<br>"+"(by employer)"+"</center></html>");
		btnCase4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewJD AddNewJD = new AddNewJD();
				AddNewJD.SignUpForm();
			}
		});
		btnCase4.setBounds(10, 238, 274, 40);
		frame.getContentPane().add(btnCase4);
		

//case5 
		
		case5_key = new JTextField();
		case5_key.setColumns(10);
		case5_key.setBounds(10, 360, 206, 21);
		frame.getContentPane().add(case5_key);
		case5_key.setVisible(false);
		
		JLabel lblSearchCriterion = new JLabel("search criterion:");
		lblSearchCriterion.setBounds(20, 346, 173, 15);
		frame.getContentPane().add(lblSearchCriterion);
		lblSearchCriterion.setVisible(false);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rms.countMatchingJobDescriptions(case5_key.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(rms.case5);
				rms.case5 = "";
			}
		});
		btnGo.setBounds(214, 359, 70, 23);
		frame.getContentPane().add(btnGo);
		btnGo.setVisible(false);
		
		JButton btnCase5 = new JButton("5 - Count the number of job descriptions that match a specific search criterion");
		btnCase5.setText("<html><center>"+"5 - Count the number of job descriptions that"+"<br>"+" match a specific search criterion"+"</center></html>");
		btnCase5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				case5_key.setVisible(true);
				lblSearchCriterion.setVisible(true);
				btnGo.setVisible(true);

			}
		});
		btnCase5.setBounds(10, 288, 274, 48);
		frame.getContentPane().add(btnCase5);
		


//case6 	
		case6key = new JTextField();
		case6key.setColumns(10);
		case6key.setBounds(10, 459, 206, 21);
		frame.getContentPane().add(case6key);
		case6key.setVisible(false);
				
		JLabel lblSearchCriterion2 = new JLabel("Applicant ID:");
		lblSearchCriterion2.setBounds(10, 445, 93, 15);
		frame.getContentPane().add(lblSearchCriterion2);
		lblSearchCriterion2.setVisible(false);
		
		JButton btnGo2 = new JButton("Go");
		btnGo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rms.getJobApplicationHistory(String.valueOf(case6key.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(rms.case6);
				rms.case5 = "";
			}
		});
		btnGo2.setBounds(214, 458, 70, 23);
		frame.getContentPane().add(btnGo2);
		btnGo2.setVisible(false);
		
		JButton btnCase6 = new JButton("6 - Display the job application history of an applicant");
		btnCase6.setText("<html><center>"+"6 - Display the job application history"+"<br>"+" of an applicant"+"</center></html>");
		btnCase6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				case6key.setVisible(true);
				lblSearchCriterion2.setVisible(true);
				btnGo2.setVisible(true);
				
				
			}
		});
		btnCase6.setBounds(10, 391, 274, 40);
		frame.getContentPane().add(btnCase6);
		
		
//case7 		
		
		case7key = new JTextField();
		case7key.setBounds(10, 548, 206, 21);
		frame.getContentPane().add(case7key);
		case7key.setColumns(10);
		case7key.setVisible(false);;
		
		JButton btnGo3 = new JButton("Go");
		btnGo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Success!");
			}
		});
		btnGo3.setBounds(214, 547, 70, 23);
		frame.getContentPane().add(btnGo3);
		btnGo3.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("New System Date (yyyy-MM-dd):");
		lblNewLabel_1.setBounds(10, 523, 264, 15);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JButton btnCase7 = new JButton("7 - Adjust the system date");
		btnCase7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				case7key.setVisible(true);
				lblNewLabel_1.setVisible(true);
				btnGo3.setVisible(true);
				
			}
		});
		btnCase7.setBounds(10, 490, 274, 23);
		frame.getContentPane().add(btnCase7);
		

//case8
		JButton btnCase8 = new JButton("8 - Match candidates to open requisitions");
		btnCase8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				rms.displayJobsMatchingResults();
				textArea.setText(rms.case8);
				rms.case2 = "";
				
			}
		});
		btnCase8.setBounds(10, 579, 274, 23);
		frame.getContentPane().add(btnCase8);
		
		
//case9
		JButton btnCase9 = new JButton("Quit");
		btnCase9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCase9.setBounds(10, 709, 87, 23);
		frame.getContentPane().add(btnCase9);
		

		
		
	}
}
