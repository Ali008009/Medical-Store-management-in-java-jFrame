import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLoginEmail;
	private JTextField tfLoginPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtpnLogin.setEditable(false);
		txtpnLogin.setText("Enter your credential to Login");
		txtpnLogin.setBounds(280, 46, 241, 51);
		contentPane.add(txtpnLogin);
		
		JTextPane txtpnWelcomeBack = new JTextPane();
		txtpnWelcomeBack.setEditable(false);
		txtpnWelcomeBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnWelcomeBack.setText("Welcome Back");
		txtpnWelcomeBack.setBounds(251, 11, 252, 57);
		contentPane.add(txtpnWelcomeBack);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEditable(false);
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnEmail.setText("email");
		txtpnEmail.setBounds(240, 84, 82, 40);
		contentPane.add(txtpnEmail);
		
		tfLoginEmail = new JTextField();
		tfLoginEmail.setBounds(250, 126, 289, 51);
		contentPane.add(tfLoginEmail);
		tfLoginEmail.setColumns(10);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnPassword.setText("Password");
		txtpnPassword.setEditable(false);
		txtpnPassword.setBounds(240, 188, 76, 32);
		contentPane.add(txtpnPassword);
		
		tfLoginPassword = new JTextField();
		tfLoginPassword.setBounds(251, 231, 289, 57);
		contentPane.add(tfLoginPassword);
		tfLoginPassword.setColumns(10);
		
		JButton btnSubmitLogin = new JButton("Login");
		btnSubmitLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email1=tfLoginEmail.getText();
				String password1=tfLoginPassword.getText();
				if(email1.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Email is Missing...");
					return;
				}
				if(password1.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Password is Missing....");
					return;
				}
				else {
				
				FileReader fr = null;
				BufferedReader br=null;
				try {
					fr = new FileReader(GlobalVariables.data1);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 br=new BufferedReader(fr);
				 String line;
				 int flag=0;
				 
				 try {
					while((line=br.readLine())!=null) {
						 
						String[] arr=line.split(",");
						if(arr[1].equals(email1)  && arr[2].equals(password1)) {
							
							flag=1;
						}
						
					 }
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				 if(flag==1) {
					 JOptionPane.showMessageDialog(null, "***Welcome to Home Screen***");
					 System.exit(0);
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "***Check your email and password again ***\n        "
					 		+ "    or you dont have Account...");
				 }
				
			}
				}
		});
		btnSubmitLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmitLogin.setBackground(new Color(0, 128, 255));
		btnSubmitLogin.setBounds(254, 299, 252, 51);
		contentPane.add(btnSubmitLogin);
		
		JTextPane txtpnOr = new JTextPane();
		txtpnOr.setEditable(false);
		txtpnOr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnOr.setText("Or");
		txtpnOr.setBounds(378, 361, 49, 32);
		contentPane.add(txtpnOr);
		
		JTextPane txtpnDontHaveAn = new JTextPane();
		txtpnDontHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnDontHaveAn.setEditable(false);
		txtpnDontHaveAn.setText("Don't have an account?");
		txtpnDontHaveAn.setBounds(254, 392, 173, 39);
		contentPane.add(txtpnDontHaveAn);
		
		JButton btnMoveToSignUp = new JButton("Sign Up");
		btnMoveToSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						SignUp signUp=new SignUp();
					 signUp.setVisible(true);
					 
				}
				});
				dispose();
			}
		});
		btnMoveToSignUp.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnMoveToSignUp.setBackground(new Color(0, 128, 255));
		btnMoveToSignUp.setBounds(437, 392, 108, 23);
		contentPane.add(btnMoveToSignUp);
	}
}
