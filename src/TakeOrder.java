
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class TakeOrder {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtCountryCode;
	private JTextField txtCityCode;
	private JTextField txtPhoneNumber;
	private JComboBox cbxEmployeesName; 
    private JComboBox cbxTableNumbers;
    private JRadioButton rbtnGenderFemale;
    private JRadioButton rbtnGenderMale;
    private JFrame superF;
    private TakeOrder2 to2;
	
	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String[] employeeNames(Management mng) {
		String[] temp = new String[mng.getAdmin().getEmployees().size()];
		
		int i = 0;
		for (Employee emp : mng.getAdmin().getEmployees()) {
			temp[i]= emp.getName();
			i++;
		}
		return temp;
	}
	public String[] tableNumbers(Management mng) {
		String[] temp = new String[mng.getTables().size()];
		int i = 0;
		for (Table t : mng.getTables().values()) {
			temp[i]= Integer.toString(t.getTableNumber());
			i++;
		}
		return temp;
	}

	public TakeOrder(final JFrame superF, final Management mng) 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 102));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				superF.setVisible(true);
				try {
					this.finalize();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		frame.setTitle("Take Order");
		frame.setBounds(100, 100, 328, 329);
		frame.getContentPane().setLayout(null);
		
		

		JLabel lblNames = new JLabel("Employee Names :");
		lblNames.setBounds(33, 27, 110, 20);
		frame.getContentPane().add(lblNames);
		
		cbxEmployeesName = new JComboBox();
		cbxEmployeesName.setModel(new DefaultComboBoxModel(employeeNames(mng)));
		cbxEmployeesName.setBounds(140, 27, 86, 20);
		frame.getContentPane().add(cbxEmployeesName);

		JLabel lblSurname = new JLabel("Table Number :");
		lblSurname.setBounds(33, 55, 110, 20);
		frame.getContentPane().add(lblSurname);
		
		cbxTableNumbers = new JComboBox();
		cbxTableNumbers.setModel(new DefaultComboBoxModel(tableNumbers(mng)));
		cbxTableNumbers.setBounds(140, 55, 86, 20);
		frame.getContentPane().add(cbxTableNumbers);
		
		JButton btnAdd = new JButton("Take Order");
		
		btnAdd.setBounds(99, 110, 110, 20);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				to2 = new TakeOrder2(frame,mng,cbxEmployeesName.getSelectedItem().toString(),Integer.parseInt(cbxTableNumbers.getSelectedItem().toString()));
				to2.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
	}


	
}
