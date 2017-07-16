import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.xml.soap.Text;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountCreation extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JTextField passwordTextField;
	private JTextField confirmPasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCreation frame = new AccountCreation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountCreation() {
		setTitle("Account Creation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel emailVar = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailVar, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailVar, 10, SpringLayout.WEST, contentPane);
		contentPane.add(emailVar);
		
		emailTextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailTextField, 6, SpringLayout.SOUTH, emailVar);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailTextField, 0, SpringLayout.WEST, emailVar);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);

		
		JLabel passwordVar = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordVar, 17, SpringLayout.SOUTH, emailTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordVar, 10, SpringLayout.WEST, contentPane);
		contentPane.add(passwordVar);
		
		// the JPasswordField() masks the password
		passwordTextField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordTextField, 6, SpringLayout.SOUTH, passwordVar);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordTextField, 0, SpringLayout.WEST, emailVar);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		
		JLabel confirmPasswordVar = new JLabel("Confirm Password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, confirmPasswordVar, 22, SpringLayout.SOUTH, passwordTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, confirmPasswordVar, 0, SpringLayout.WEST, emailVar);
		contentPane.add(confirmPasswordVar);
		
		confirmPasswordTextField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, confirmPasswordTextField, 6, SpringLayout.SOUTH, confirmPasswordVar);
		sl_contentPane.putConstraint(SpringLayout.WEST, confirmPasswordTextField, 0, SpringLayout.WEST, emailVar);
		contentPane.add(confirmPasswordTextField);
		confirmPasswordTextField.setColumns(10);
		
		JRadioButton studentRadio = new JRadioButton("Student");
		sl_contentPane.putConstraint(SpringLayout.NORTH, studentRadio, 19, SpringLayout.SOUTH, confirmPasswordTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, studentRadio, 10, SpringLayout.WEST, contentPane);
		contentPane.add(studentRadio);
		studentRadio.setSelected(true);
		
		JRadioButton volunteerRadio = new JRadioButton("Volunteer");
		sl_contentPane.putConstraint(SpringLayout.NORTH, volunteerRadio, 0, SpringLayout.NORTH, studentRadio);
		sl_contentPane.putConstraint(SpringLayout.WEST, volunteerRadio, 6, SpringLayout.EAST, studentRadio);
		contentPane.add(volunteerRadio);
		volunteerRadio.setSelected(false);
		
		// group the buttons
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(volunteerRadio);
		buttons.add(studentRadio);
		
		// register listeners for the buttons ?

		
		
		JButton finishButton = new JButton("Finish");
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this gets the string value from the field
				String emailText = emailTextField.getText();
				String pwText = passwordTextField.getText();
				String confirmPwText = confirmPasswordTextField.getText();
				
				// handle email text
				if(!emailText.contains("@") || !emailText.contains(".com")){
					System.out.println("Not a valid email!");
				} else {
					System.out.println("Valid Email!");
				}
				
				// handle radio button
				if(studentRadio.isSelected()){
					volunteerRadio.setSelected(false);
				} else{
					studentRadio.setEnabled(false);
				}
				
				// check to see the two passwords match
				if(pwText.equals(confirmPwText)){
					// happy
					System.out.println("Passwords Match. Proceed!");
					// add functionality to convert to JSON and push to AWS db
				} else {
					// sad
					System.out.println("Passwords do no match, please update!");
				}
			}
		});
		finishButton.setForeground(Color.BLUE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, finishButton, -5, SpringLayout.NORTH, passwordVar);
		sl_contentPane.putConstraint(SpringLayout.EAST, finishButton, -95, SpringLayout.EAST, contentPane);
		contentPane.add(finishButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.RED);
		sl_contentPane.putConstraint(SpringLayout.NORTH, cancelButton, 6, SpringLayout.SOUTH, finishButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, cancelButton, 0, SpringLayout.WEST, finishButton);
		contentPane.add(cancelButton);
	}
}
