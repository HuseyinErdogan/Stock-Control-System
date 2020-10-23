
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MenuPage {

	private JFrame frame;
	private JRadioButton rbtnAdmin;
	private JRadioButton rbtnEmployee;
	private JRadioButton rbtnDisplayAllS;
	private JRadioButton rbtnSearch;
	private TakeOrder TO;
	private Administration Admin;

	public MenuPage() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 102));
		frame.setBounds(100, 100, 450, 286);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // specify one of several options for the close button,
																// Exit the application
		frame.getContentPane().setLayout(null);

		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setBounds(123, 30, 46, 14);
		frame.getContentPane().add(lblMenu);

		rbtnAdmin = new JRadioButton("ADMINISTRATION");
		rbtnAdmin.setBounds(60, 51, 150, 23);
		rbtnAdmin.setSelected(true);
		rbtnAdmin.setOpaque(false);
		frame.getContentPane().add(rbtnAdmin);

		rbtnEmployee = new JRadioButton("EMPLOYEE ENTRANCE");
		rbtnEmployee.setBounds(60, 77, 323, 23);
		rbtnEmployee.setOpaque(false);
		frame.getContentPane().add(rbtnEmployee);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rbtnAdmin);
		btnG.add(rbtnEmployee);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnAdmin.isSelected()) {
					adminPassword();
				} 
				else if (rbtnEmployee.isSelected()) {
					TO = new TakeOrder(frame,Management.getManagement());
					TO.getFrame().setVisible(true);
					frame.setVisible(false);

				} else if (rbtnDisplayAllS.isSelected()) {

				} else if (rbtnSearch.isSelected()) {

				} else {

				}
			}
		});
		btnOk.setBounds(218, 193, 89, 23);
		frame.getContentPane().add(btnOk);

	}

	public void adminPassword() {

		final JFrame fram= new JFrame();
		fram.setTitle("Admin Enterance Screen");
		fram.getContentPane().setBackground(new Color(255, 255, 102));
		fram.setBounds(100, 100, 450, 286);
		fram.getContentPane().setLayout(null);
		fram.setVisible(true);
		JLabel lblUserName = new JLabel("Username: ");
		lblUserName.setBounds(55, 31, 78, 14);
		fram.getContentPane().add(lblUserName);
		
		final JTextField txtUserName = new JTextField();
		txtUserName.setBounds(143, 28, 86, 20);
		txtUserName.setColumns(10);
		fram.getContentPane().add(txtUserName);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(55, 65, 78, 14);
		fram.getContentPane().add(lblPassword);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(143, 59, 86, 20);
		fram.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener()  //create an instance of the listener
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				if(txtUserName.getText().equals("admin") &&
						passwordField.getText().equals("admin"))
				{
					try {
						fram.setVisible(false);
						Admin = new Administration(Management.getManagement(),frame);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Admin.getAdminFrame().setVisible(true);
					frame.setVisible(false);
				}
				else
				{
					txtUserName.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(fram, "Wrong password or user name. \n Default username: admin \n Default password: admin");
				}
			}
		});
		btnLogIn.setBounds(140, 105, 89, 23);
		fram.getContentPane().add(btnLogIn);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
