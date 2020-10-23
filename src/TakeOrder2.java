
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
import java.awt.Font;

public class TakeOrder2 {

	private JFrame frame;

	private JComboBox cbxFoods;
	private JComboBox cbxDrinks;
	private JFrame superF;
	private JLabel lblNumberF;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String[] reachFoods(Management mng) {

		String[] temp = new String[mng.getAdmin().getStock().getFood().size()];
		int i = 0;
		for (Food f : mng.getAdmin().getStock().getFood().values()) {
			temp[i] = f.getProductName();
			i++;
		}
		return temp;

	}

	public String[] reachDrinks(Management mng) {

		String[] temp = new String[mng.getAdmin().getStock().getDrink().size()];
		int i = 0;
		for (Drink d : mng.getAdmin().getStock().getDrink().values()) {
			temp[i] = d.getProductName();
			i++;
		}
		return temp;

	}

	public TakeOrder2(final JFrame superF, final Management mng, String employeeName, final int tableNumber) {
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

		frame.setTitle("STOCKing/Employee/TakeOrder2");
		frame.setBounds(100, 100, 328, 329);
		frame.getContentPane().setLayout(null);

		JLabel lblFoods = new JLabel("FOODS");
		lblFoods.setBounds(60, 27, 110, 20);
		frame.getContentPane().add(lblFoods);

		cbxFoods = new JComboBox();
		cbxFoods.setModel(new DefaultComboBoxModel(reachFoods(mng)));
		cbxFoods.setBounds(33, 45, 110, 20);
		frame.getContentPane().add(cbxFoods);

		JLabel lblDrinks = new JLabel("DRINKS");
		lblDrinks.setBounds(177, 27, 110, 20);
		frame.getContentPane().add(lblDrinks);

		cbxDrinks = new JComboBox();
		cbxDrinks.setModel(new DefaultComboBoxModel(reachDrinks(mng)));
		cbxDrinks.setBounds(150, 45, 110, 20);
		frame.getContentPane().add(cbxDrinks);

		JButton btnMinusF = new JButton("-");
		btnMinusF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMinusF.setBounds(33, 88, 40, 40);
		frame.getContentPane().add(btnMinusF);

		JButton btnPlusF = new JButton("+");
		btnPlusF.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnPlusF.setBounds(103, 88, 40, 40);
		frame.getContentPane().add(btnPlusF);

		lblNumberF = new JLabel("0");
		lblNumberF.setBounds(83, 88, 40, 40);
		frame.getContentPane().add(lblNumberF);

		JButton btnMinusD = new JButton("-");
		btnMinusD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMinusD.setBounds(150, 88, 40, 40);
		frame.getContentPane().add(btnMinusD);

		JButton btnPlusD = new JButton("+");
		btnPlusD.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnPlusD.setBounds(220, 88, 40, 40);
		frame.getContentPane().add(btnPlusD);

		final JLabel lblNumberD = new JLabel("0");
		lblNumberD.setBounds(200, 88, 40, 40);
		frame.getContentPane().add(lblNumberD);

		final JLabel lblFoodPrice = new JLabel("");
		lblFoodPrice.setBounds(20, 144, 125, 30);
		frame.getContentPane().add(lblFoodPrice);

		final JLabel lblDrinkPrice = new JLabel("");
		lblDrinkPrice.setBounds(150, 144, 125, 30);
		frame.getContentPane().add(lblDrinkPrice);

		JButton btnOK = new JButton("Add Order");
		btnOK.setBounds(103, 249, 110, 30);
		frame.getContentPane().add(btnOK);

		final JLabel lblTotalFoodPrice = new JLabel("");
		lblTotalFoodPrice.setBounds(20, 186, 125, 28);
		frame.getContentPane().add(lblTotalFoodPrice);

		final JLabel lblTotalDrinkPrice = new JLabel("");
		lblTotalDrinkPrice.setBounds(150, 185, 125, 29);
		frame.getContentPane().add(lblTotalDrinkPrice);

		
		cbxFoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumberF.setText("0");
				lblTotalFoodPrice.setText("Total Food Price: 0");
				lblFoodPrice.setText("Unit Price: " + mng.getAdmin().getStock().getFood()
						.get(cbxFoods.getSelectedItem().toString()).getUnitSalePrice());
			}
		});
		cbxDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTotalDrinkPrice.setText("Total Drink Price: 0");
				lblDrinkPrice.setText("Unit Price: " + mng.getAdmin().getStock().getDrink()
						.get(cbxDrinks.getSelectedItem().toString()).getUnitSalePrice());
				lblNumberD.setText("0");
			}
		});

		btnPlusF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumberF.setText(Integer.toString(Integer.parseInt(lblNumberF.getText()) + 1));
				lblTotalFoodPrice.setText("Total Food Price: " + (Integer.parseInt(lblNumberF.getText()) * mng.getAdmin()
						.getStock().getFood().get(cbxFoods.getSelectedItem().toString()).getUnitSalePrice()));
				}
		});

		btnMinusF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblNumberF.getText().equals("0")) {

					lblNumberF.setText(Integer.toString(Integer.parseInt(lblNumberF.getText()) - 1));
					lblTotalFoodPrice.setText(
							"Total Food Price: " + (Integer.parseInt(lblNumberF.getText()) * mng.getAdmin().getStock()
									.getFood().get(cbxFoods.getSelectedItem().toString()).getUnitSalePrice()));

				}
			}
		});
		btnPlusD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNumberD.setText(Integer.toString(Integer.parseInt(lblNumberD.getText()) + 1));
				lblTotalDrinkPrice.setText("Total Drink Price: " + (Integer.parseInt(lblNumberD.getText()) * mng.getAdmin()
						.getStock().getDrink().get(cbxDrinks.getSelectedItem().toString()).getUnitSalePrice()));
							}
		});

		btnMinusD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblNumberD.getText().equals("0")) {

					lblNumberD.setText(Integer.toString(Integer.parseInt(lblNumberD.getText()) - 1));
					lblTotalDrinkPrice.setText(
							"Total Drink Price: " + (Integer.parseInt(lblNumberD.getText()) * mng.getAdmin().getStock()
									.getDrink().get(cbxDrinks.getSelectedItem().toString()).getUnitSalePrice()));
					
				}
			}
		});
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input = JOptionPane.showOptionDialog(frame, "Are you sure?", "ALERT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if(input == JOptionPane.OK_OPTION)
				{
					mng.addOrder(tableNumber,
							mng.getAdmin().getStock().getFood().get(cbxFoods.getSelectedItem().toString()),
							Integer.parseInt(lblNumberF.getText()));
					mng.addOrder(tableNumber,
							mng.getAdmin().getStock().getDrink().get(cbxDrinks.getSelectedItem().toString()),
							Integer.parseInt(lblNumberD.getText()));
					JOptionPane.showMessageDialog(frame, "Order has been successfully added");
					frame.setVisible(false);
				   superF.setVisible(true);
				}
				else {
					frame.setVisible(false);
					   superF.setVisible(true);
				}
					
			}
		});
	}
}
