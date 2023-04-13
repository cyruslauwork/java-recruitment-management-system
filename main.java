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
import javax.swing.SwingConstants;

public class main {
	RecruitmentSystem rms = new RecruitmentSystem();

	private JFrame frame;
	private JTextField start;
	private JTextField end;

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
		
		
		JLabel lblNewLabel = new JLabel(" Start Date (yyyy-MM-dd)");
		lblNewLabel.setBounds(20, 164, 173, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel(" End Date (yyyy-MM-dd)");
		lblNewLabel2.setBounds(20, 220, 173, 15);
		frame.getContentPane().add(lblNewLabel2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 0, 1092, 742);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
//case 1		
		JButton btnCase1 = new JButton("Case1");
		btnCase1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				rms.displayAllCandidates();
				textArea.setText(rms.case1);
				rms.case1 = "";
			}
		});
		btnCase1.setBounds(10, 65, 87, 23);
		frame.getContentPane().add(btnCase1);
//case2		
		JButton btnCase2 = new JButton("Case2");
		btnCase2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				rms.displayAllEmployers();
				textArea.setText(rms.case2);
				rms.case2 = "";
			}
		});
		btnCase2.setBounds(10, 98, 87, 23);
		frame.getContentPane().add(btnCase2);
//case3		
		JButton btnCase3 = new JButton("Case3");
		btnCase3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				rms.displayJobDescriptionsInRange(java.sql.Date.valueOf(start.getText()),
						java.sql.Date.valueOf(end.getText()));
				textArea.setText(rms.case3);
				rms.case3 = "";
			}
		});
		btnCase3.setBounds(10, 131, 87, 23);
		frame.getContentPane().add(btnCase3);
		
		start = new JTextField();
		start.setBounds(10, 189, 183, 21);
		frame.getContentPane().add(start);
		start.setColumns(10);
		
		end = new JTextField();
		end.setColumns(10);
		end.setBounds(10, 245, 183, 21);
		frame.getContentPane().add(end);
//case4		
		JButton btnCase4 = new JButton("Case4");
		btnCase4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewJD AddNewJD = new AddNewJD();
				AddNewJD.SignUpForm();
			}
		});
		btnCase4.setBounds(10, 276, 87, 23);
		frame.getContentPane().add(btnCase4);
		

//case5 
		JButton btnCase5 = new JButton("Case5");
		btnCase5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					rms.countMatchingJobDescriptions("a");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(rms.case5);
				rms.case5 = "";
			}
		});
		btnCase5.setBounds(10, 309, 87, 23);
		frame.getContentPane().add(btnCase5);
//case6 		

		
		
		
	}
}
