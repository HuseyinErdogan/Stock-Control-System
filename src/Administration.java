import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import javax.swing.JToolBar;
import javax.swing.JRadioButton;

public class Administration{
	private JFrame adminFrame;

	JPanel addEmployeePanel = new JPanel();
	JPanel deleteEmployeePanel = new JPanel();
	JPanel stockDisplayPanel= new JPanel();
	JPanel stockAddPanel = new JPanel();
	JPanel incomeExpensePanel = new JPanel();
	JPanel stockDeletePanel = new JPanel();
	JPanel stockDeletePanel2 = new JPanel();
	JLabel numberOfProductLabel ;
	
	
	private JTextField empNameText;
	private JTextField salaryText;
	private JTextField productNameTxt;
	private JTextField numberOfProductTxt;
	private JTextField unitPurchasePriceTxt;
	private JTextField unitSalePriceTxt;
	public static JTextField deleteProductTxt;
	
	
	private JTable incomeTable;
	private JTable ExpenseTable;

	JButton showIncomeButton = new JButton("Show Income-Expense");
	JScrollPane incomeScrollPane = new JScrollPane();
	JScrollPane ExpenseScrollPane = new JScrollPane();
	
	MaskFormatter mf ;
	JFormattedTextField formattedTextField ;
	
	
	private boolean displayFlag=false;
	private boolean deleteFlag=false;
	private boolean sliderFlag=false;

	int valueTemp=0;
	
	public static JScrollPane scrollPaneFood;
	public static JScrollPane scrollPaneDrink;
	public static JScrollPane scrollPaneOther;
	
	JComboBox deleteComboBox = new JComboBox();
	JButton addProductButton = new JButton("Add Product");
	
	String productName= new String();
	String productType= new String();
	
	
	JSlider slider;

	JButton deleteProductButton = new JButton("Delete Product");


	
	private JTable foodTable;
	private JTable drinkTable;
	private JTable otherTable;


	

/*
	 * @throws ParseException 
	 */
	public Administration(final Management mng,final JFrame frame) throws ParseException {
		
		
		
		adminFrame=new JFrame();
		
		adminFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frame.setVisible(true);
				try {
					this.finalize();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		adminFrame.setTitle("Administrator");
		adminFrame.setBounds(100, 100, 1000, 600);

		adminFrame.getContentPane().setLayout(null);
		
		

		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(30, 20, 1330, 47);
		
		
		
		JButton addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.setBounds(20, 38, 85, 21);
		toolBar.add(addEmployeeButton);
		
		JButton deleteEmployeeButton = new JButton("Delete Employee");
		deleteEmployeeButton.setBounds(115, 38, 85, 21);
		toolBar.add(deleteEmployeeButton);
		
		JButton stockDisplayButton = new JButton("Stock Display");
		stockDisplayButton.setBounds(210, 38, 85, 21);
		toolBar.add(stockDisplayButton);

		
		JButton stockDeleteButton = new JButton("Stock Delete");
		stockDeleteButton.setBounds(329, 38, 85, 21);
		toolBar.add(stockDeleteButton);
		
		JButton stockAddButton = new JButton("Stock Add");
		stockAddButton.setBounds(424, 38, 85, 21);
		toolBar.add(stockAddButton);
		
		JButton incomeExpenseButton = new JButton("Income-Expense");
		incomeExpenseButton.setBounds(424, 38, 85, 21);
		toolBar.add(incomeExpenseButton);
		
		
		adminFrame.getContentPane().add(toolBar);
		
		//PANELS*******************************************
		
		addEmployeePanel.setBackground((new Color(255, 255, 102)));

		
		
		addEmployeePanel.setBounds(30, 69, 1330, 700);
		adminFrame.getContentPane().add(addEmployeePanel);
		addEmployeePanel.setVisible(false);
		addEmployeePanel.setLayout(null);
		
		
		
		
		deleteEmployeePanel.setBackground(new Color(255, 255, 102));

		
		
		deleteEmployeePanel.setBounds(30, 69, 1330, 700);
		adminFrame.getContentPane().add(deleteEmployeePanel);
		deleteEmployeePanel.setVisible(false);
		deleteEmployeePanel.setLayout(null);
		

		

		resetStockDisplay();
		
		
		stockAddPanel.setBackground((new Color(255, 255, 102)));

		
		stockAddPanel.setBounds(30, 69, 1330, 700);
		adminFrame.getContentPane().add(stockAddPanel);
		stockAddPanel.setVisible(false);
		stockAddPanel.setLayout(null);
		
		
		stockDeletePanel.setBackground(new Color(255, 255, 102));

		
		stockDeletePanel.setBounds(30, 69, 1330, 700);
		adminFrame.getContentPane().add(stockDeletePanel);
		stockDeletePanel.setVisible(false);
		stockDeletePanel.setLayout(null);
		
		incomeExpensePanel.setBackground(new Color(255, 255, 102));
		incomeExpensePanel.setBounds(30, 69, 1330, 700);
		adminFrame.getContentPane().add(incomeExpensePanel);
		incomeExpensePanel.setVisible(false);
		incomeExpensePanel.setLayout(null);
		
		//_-----------------------------------------------
		// ADD EMPLOYEE *************************************************************
		
		
		
		
		empNameText = new JTextField();
		empNameText.setBounds(134, 49, 114, 20);
		addEmployeePanel.add(empNameText);
		empNameText.setColumns(10);
		
		salaryText = new JTextField();
		salaryText.setBounds(134, 100, 114, 20);
		addEmployeePanel.add(salaryText);
		salaryText.setColumns(10);
		
		JButton addEmpbtn = new JButton("Confirm");
		addEmpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mng.getAdmin().employeeAdd(empNameText.getText(), Integer.parseInt(salaryText.getText()));

			}
		});
		addEmpbtn.setBounds(81, 155, 89, 23);
		addEmployeePanel.add(addEmpbtn);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBackground(new Color(255, 255, 102));
		lblNewLabel.setBounds(31, 48, 78, 20);
		addEmployeePanel.add(lblNewLabel);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSalary.setBounds(31, 100, 78, 20);
		addEmployeePanel.add(lblSalary);
		
		

		

		

		
		

		

		
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockDisplayPanel.setVisible(false);
				deleteEmployeePanel.setVisible(false);
				stockAddPanel.setVisible(false);
				stockDeletePanel.setVisible(false);
				incomeExpensePanel.setVisible(false);
				addEmployeePanel.setVisible(true);
			}
		});
		
		// DELETE EMPLOYEEE *****************************
		
		
		deleteEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				addEmployeePanel.setVisible(false);
				stockDisplayPanel.setVisible(false);
				stockAddPanel.setVisible(false); 
				incomeExpensePanel.setVisible(false);
				stockDeletePanel.setVisible(false);
				
				JLabel lblNew2 = new JLabel("Employee Name");
				lblNew2.setBackground(new Color(255, 255, 102));

				lblNew2.setBounds(48, 50, 100, 20);
				deleteEmployeePanel.add(lblNew2);
				
				
				JButton Delete = new JButton("Delete");
				if (!mng.getAdmin().getEmployees().isEmpty()) {
					String[] emp1 = new String[mng.getAdmin().getEmployees().size()];
					int i=0;
					for (Employee em : mng.getAdmin().getEmployees()) {
						emp1[i]=em.getName();
						i++;
					}
					
					deleteComboBox.setModel(new DefaultComboBoxModel(emp1));
					deleteComboBox.setBounds(48, 75, 130, 23);
					deleteEmployeePanel.add(deleteComboBox);
					
					
					Delete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mng.getAdmin().employeeDelete(deleteComboBox.getSelectedItem().toString());
							deleteEmployeePanel.setVisible(false);
						}
					});
				}

				Delete.setBounds(200, 75, 130, 23);
				deleteEmployeePanel.add(Delete);
				deleteEmployeePanel.setVisible(true);
				
			}
		});

		//*****************************************************
		//STOCK DISPLAY **************************************************
		


		
		
		resetStockDisplay();
		

		


		stockDisplayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				displayFlag=true;

				deleteEmployeePanel.setVisible(false);
				addEmployeePanel.setVisible(false);
				stockAddPanel.setVisible(false);	
				stockDeletePanel.setVisible(false);
				incomeExpensePanel.setVisible(false);
				

				

				
				foodTable = new JTable();
				drinkTable = new JTable();
				otherTable = new JTable();
				
				foodTable.setEnabled(false);
				drinkTable.setEnabled(false);
				otherTable.setEnabled(false);
				
				
				
				
				foodTable.setModel(new DefaultTableModel(
						mng.getAdmin().getStock().getFoodString(),
					new String[] {
						"Product Name", "Number Of Product", "Entry Date"
					}
				));

				foodTable.setBounds(10, 36,280, 300);
				
				drinkTable.setModel(new DefaultTableModel(
						mng.getAdmin().getStock().getDrinkString(),
					new String[] {
						"Product Name", "Number Of Product", "Entry Date"
					}
				));
				drinkTable.setBounds(310, 36,280, 300);
				
				otherTable.setModel(new DefaultTableModel(
						mng.getAdmin().getStock().getOtherString(),
					new String[] {
						"Product Name", "Number Of Product", "Entry Date"
					}
				));
				otherTable.setBounds(610, 36,280, 300);
				
				
				
				
				
				
				resetTables(foodTable, drinkTable, otherTable);

				adminFrame.getContentPane().add(stockDisplayPanel);
				stockDisplayPanel.setVisible(true);
				
				

			}
			
		});
		
		//STOCK ADD ***********************
		
		final JRadioButton foodButton = new JRadioButton("Food");
		foodButton.setBounds(103, 237, 103, 21);
		foodButton.setOpaque(false);
		stockAddPanel.add(foodButton);
		
		final JRadioButton drinkButton = new JRadioButton("Drink");
		drinkButton.setBounds(216, 237, 103, 21);
		drinkButton.setOpaque(false);
		stockAddPanel.add(drinkButton);
		
		final JRadioButton otherButton = new JRadioButton("Other");
		otherButton.setBounds(329, 237, 103, 21);
		otherButton.setOpaque(false);
		stockAddPanel.add(otherButton);
		
		ButtonGroup products = new ButtonGroup();
		products.add(foodButton);
		products.add(drinkButton);
		products.add(otherButton);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setBounds(103, 74, 81, 13);
		stockAddPanel.add(lblNewLabel_1);
		
		productNameTxt = new JTextField();
		productNameTxt.setBounds(223, 71, 96, 19);
		stockAddPanel.add(productNameTxt);
		productNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Number of Product");
		lblNewLabel_2.setBounds(103, 117, 116, 13);
		stockAddPanel.add(lblNewLabel_2);
		
		numberOfProductTxt = new JTextField();
		numberOfProductTxt.setBounds(223, 114, 96, 19);
		stockAddPanel.add(numberOfProductTxt);
		numberOfProductTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Unit Purchase Price");
		lblNewLabel_3.setBounds(103, 158, 115, 13);
		stockAddPanel.add(lblNewLabel_3);
		
		unitPurchasePriceTxt = new JTextField();
		unitPurchasePriceTxt.setBounds(223, 155, 96, 19);
		stockAddPanel.add(unitPurchasePriceTxt);
		unitPurchasePriceTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unit Sale Price");
		lblNewLabel_4.setBounds(103, 201, 103, 13);
		stockAddPanel.add(lblNewLabel_4);
		
		unitSalePriceTxt = new JTextField();
		unitSalePriceTxt.setBounds(223, 198, 96, 19);
		stockAddPanel.add(unitSalePriceTxt);
		unitSalePriceTxt.setColumns(10);
		
		
		addProductButton.setBounds(192, 294, 127, 21);
		stockAddPanel.add(addProductButton);
		

		
		
		
		stockAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (displayFlag) {
					resetScroll();
				}
				

		
				deleteEmployeePanel.setVisible(false);
				addEmployeePanel.setVisible(false);
				stockDisplayPanel.setVisible(false);
				incomeExpensePanel.setVisible(false);
				stockDeletePanel.setVisible(false);
				
				
				addProductButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (foodButton.isSelected()) {
							
							
							if (mng.getAdmin().newOrExistStock(productNameTxt.getText().toString().toLowerCase(), "Food", Integer.parseInt(numberOfProductTxt.getText().toString()))) {
								mng.getAdmin().stockAdd(productNameTxt.getText().toString().toLowerCase(), "Food", Integer.parseInt(numberOfProductTxt.getText().toString()));
							}
							else {
								Product pr = ProductFactory.getProduct(productNameTxt.getText().toString().toLowerCase(),Integer.parseInt(numberOfProductTxt.getText().toString()),
										Double.parseDouble(unitPurchasePriceTxt.getText().toString()),Double.parseDouble(unitSalePriceTxt.getText().toString()),"Food");
								mng.getAdmin().addNewProduct(pr, "Food");
							}
					

						}
						else if (drinkButton.isSelected()) {
							if (mng.getAdmin().newOrExistStock(productNameTxt.getText().toString().toLowerCase(), "Drink", Integer.parseInt(numberOfProductTxt.getText().toString()))) {
								mng.getAdmin().stockAdd(productNameTxt.getText().toString().toLowerCase(), "Drink", Integer.parseInt(numberOfProductTxt.getText().toString()));
							}
							else {
								Product pr = ProductFactory.getProduct(productNameTxt.getText().toString().toLowerCase(),Integer.parseInt(numberOfProductTxt.getText().toString()),
										Double.parseDouble(unitPurchasePriceTxt.getText().toString()),Double.parseDouble(unitSalePriceTxt.getText().toString()),"Drink");
								mng.getAdmin().addNewProduct(pr, "Drink");
							}
						}
						else if (otherButton.isSelected()) {
							if (mng.getAdmin().newOrExistStock(productNameTxt.getText().toString().toLowerCase(), "Other", Integer.parseInt(numberOfProductTxt.getText().toString()))) {
								mng.getAdmin().stockAdd(productNameTxt.getText().toString().toLowerCase(), "Other", Integer.parseInt(numberOfProductTxt.getText().toString()));
							}
							else {
								Product pr = ProductFactory.getProduct(productNameTxt.getText().toString().toLowerCase(),Integer.parseInt(numberOfProductTxt.getText().toString()),
										Double.parseDouble(unitPurchasePriceTxt.getText().toString()),Double.parseDouble(unitSalePriceTxt.getText().toString()),"Other");
								mng.getAdmin().addNewProduct(pr, "Other");
							}
						}
						else {
							JOptionPane.showMessageDialog(frame, "Please choose product type");
						}					
						
					}
				});
				
				
				
				stockAddPanel.setVisible(true);
				
			}
		});
		
		//*************************************************
		//STOCK DELETE ****************************************************

		//Stock delete iþlemi stockDisplayden sonra uygulanýrsa çalýþmayabiliyor.!!!
		
		stockDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayFlag) {
					resetScroll();
					deleteProductTxt = new JTextField();
				}
				if (deleteFlag) {
					resetStockDelete();
	
				}
				
				numberOfProductLabel = new JLabel("Number Of Product");
				
				
				
				
				
				stockAddPanel.setVisible(false);
				stockDisplayPanel.setVisible(false);
				addEmployeePanel.setVisible(false);
				deleteEmployeePanel.setVisible(false);
				incomeExpensePanel.setVisible(false);
				

				
				JLabel lblNewLabel = new JLabel("Product Name");
				lblNewLabel.setBounds(251, 105, 94, 13);
				stockDeletePanel.add(lblNewLabel);
				

				deleteProductTxt = new JTextField();
				deleteProductTxt.setBounds(393, 102, 96, 19);
				
				stockDeletePanel.add(deleteProductTxt);
				deleteProductTxt.setColumns(10);
				

				
				stockDeletePanel2.setBounds(155, 195, 622, 336);
				stockDeletePanel.add(stockDeletePanel2);
				stockDeletePanel2.setVisible(false);
				stockDeletePanel2.setLayout(null);
				slider = new JSlider();
				slider.setBounds(222, 53, 200, 22);	
				JButton findProductButton = new JButton("Find Product");
				findProductButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						

						numberOfProductLabel.setBounds(50, 53, 150, 22);
						stockDeletePanel2.add(numberOfProductLabel);
						
						
						deleteProductButton.setBounds(137, 130, 157, 21);
						stockDeletePanel2.add(deleteProductButton);
						
						

						slider.setMinimum(0);
						stockDeletePanel2.add(slider);

						if (mng.getAdmin().getStock().getFood().containsKey(deleteProductTxt.getText().toString().toLowerCase())) {
							productName=deleteProductTxt.getText().toString().toLowerCase();
							productType="Food";
							
							slider.setMaximum(mng.getAdmin().getStock().getFood().get(productName).getNumberOfProduct());
	
							
							slider.setToolTipText("How many "+ productName+"s do you want to delete.");
							
							slider.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									deleteFlag=true;
									valueTemp=slider.getValue();
									numberOfProductLabel.setText("Number Of Product: "+valueTemp);
								}
							});
							
							
							stockDeletePanel2.setVisible(true);
							sliderFlag = false;
							deleteProductButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {

									deleteFlag=true;
									if (!sliderFlag && slider.getValue()==mng.getAdmin().getStock().getFood().get(productName).getNumberOfProduct()) {
										mng.getAdmin().getStock().getFood().remove(productName);		
									
									}
									else if(!sliderFlag) {
										mng.getAdmin().getStock().getFood().get(productName).
										setNumberOfProduct(mng.getAdmin().getStock().getFood().get(productName).getNumberOfProduct()-valueTemp);
									}
									sliderFlag=true;
									
									stockDeletePanel.setVisible(false);
									resetStockDelete();
								}
							});

						}
						else if (mng.getAdmin().getStock().getDrink().get(deleteProductTxt.getText().toString().toLowerCase())!=null) {
							productName=deleteProductTxt.getText().toString().toLowerCase();
							productType="Drink";
							
							slider.setMaximum(mng.getAdmin().getStock().getDrink().get(productName).getNumberOfProduct());
							slider.setToolTipText("How many "+ productName+"s do you want to delete.");
							slider.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									deleteFlag=true;
									valueTemp=slider.getValue();
									numberOfProductLabel.setText("Number Of Product: "+valueTemp);
								}
							});
							
							stockDeletePanel2.setVisible(true);
							sliderFlag = false;
							deleteProductButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									deleteFlag=true;
									if (!sliderFlag && slider.getValue()==mng.getAdmin().getStock().getDrink().get(productName).getNumberOfProduct()) {
										mng.getAdmin().getStock().getDrink().remove(productName);								
									}
									else if(!sliderFlag){
										mng.getAdmin().getStock().getDrink().get(productName).
										setNumberOfProduct(mng.getAdmin().getStock().getDrink().get(productName).getNumberOfProduct()-valueTemp);
									}
									sliderFlag=true;
									stockDeletePanel.setVisible(false);
									resetStockDelete();
								}
							});

						}
						else if (mng.getAdmin().getStock().getOther().get(deleteProductTxt.getText().toString().toLowerCase())!=null) {
							productName=deleteProductTxt.getText().toString().toLowerCase();
							productType="Other";
							
							slider.setMaximum(mng.getAdmin().getStock().getOther().get(productName).getNumberOfProduct());
							slider.setToolTipText("How many "+ productName+"s do you want to delete.");
							slider.addChangeListener(new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									deleteFlag=true;
									valueTemp=slider.getValue();
									numberOfProductLabel.setText("Number Of Product: "+valueTemp);
								}
							});
							
							stockDeletePanel2.setVisible(true);
							sliderFlag = false;
							deleteProductButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									deleteFlag=true;
									if (!sliderFlag && slider.getValue()==mng.getAdmin().getStock().getOther().get(productName).getNumberOfProduct()) {
										mng.getAdmin().getStock().getOther().remove(productName);								
									}
									else if(!sliderFlag) {
										mng.getAdmin().getStock().getOther().get(productName).
										setNumberOfProduct(mng.getAdmin().getStock().getOther().get(productName).getNumberOfProduct()-valueTemp);
									}
									sliderFlag = true;
									stockDeletePanel.setVisible(false);
									resetStockDelete();
								}
							});

						}
						else {
							JOptionPane.showMessageDialog(frame, "Invalid product name!");
						}

						
					}
				});

				findProductButton.setBounds(290, 172, 157, 21);
				stockDeletePanel.add(findProductButton);
				
				deleteProductTxt.resetKeyboardActions();
				
				stockDeletePanel.setVisible(true);
				
			}
		});
		
		
		//**********************************************************************
		//INCOME Expense --------
		

		
		
		incomeExpenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockAddPanel.setVisible(false);
				stockDisplayPanel.setVisible(false);
				addEmployeePanel.setVisible(false);
				deleteEmployeePanel.setVisible(false);
				stockDeletePanel.setVisible(false);
				
				incomeExpenseReset();
				
				
				
				try {
					mf = new MaskFormatter("## / ## / 20## - ## / ## / 20##");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				formattedTextField = new JFormattedTextField(mf);
				
				JLabel lblNewLabel1 = new JLabel("Please enter date interval");
				lblNewLabel1.setBounds(39, 59, 170, 13);
				incomeExpensePanel.add(lblNewLabel1);
				


				formattedTextField.setBounds(195, 57, 164, 16);
				incomeExpensePanel.add(formattedTextField);
				
				JLabel dateLabel = new JLabel("    DD / MM / YYYY   -   DD / MM / YYYY");
				dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
				dateLabel.setBounds(195, 45, 164, 13);
				incomeExpensePanel.add(dateLabel);
				
				
				showIncomeButton.setBounds(399, 55, 180, 21);
				incomeExpensePanel.add(showIncomeButton);
				
				
				
				
				
				
				
				
				showIncomeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String dt[]=formattedTextField.getText().toString().split(" - ");
						
						String dt1[] = dt[0].split(" / ");
						String dt2[] = dt[1].split(" / ");
						
						
						
						String date1= dt1[0]+"-"+dt1[1]+"-"+dt1[2];
						String date2= dt2[0]+"-"+dt2[1]+"-"+dt2[2];

						
						
						
						int count=0;
						for (Map.Entry<String, Double> element : mng.getAdmin().getDailyIncome().entrySet()) {
							if (isInInterval(date1,date2,element.getKey())) {
								count++;
							}
							
						}
						String[][] incomeResult = new String[count][2];
						String[][] ExpenseResult = new String[count][2];
						count=0;
						for (Map.Entry<String, Double> element : mng.getAdmin().getDailyIncome().entrySet()) {
							if (isInInterval(date1,date2,element.getKey())) {
								incomeResult[count][0]=element.getKey();
								incomeResult[count][1]=Double.toString(element.getValue());
								count++;
							}		
						}

						count=0;
						for (Map.Entry<String, Double> element : mng.getAdmin().getDailyExpense().entrySet()) {
							if (isInInterval(date1,date2,element.getKey())) {
								ExpenseResult[count][0]=element.getKey();
								ExpenseResult[count][1]=Double.toString(element.getValue());
								count++;
							}		

						}

						
						
						incomeTable = new JTable();
						incomeTable.setModel(new DefaultTableModel(
							incomeResult,
							new String[] {
								"Date", "Daily Income"
							}
						));
						incomeTable.setBounds(922, 38, 245, 262);

						
						ExpenseTable = new JTable();
						ExpenseTable.setModel(new DefaultTableModel(
							ExpenseResult,
							new String[] {
								"Date","Daily Expense"
							}
						));
						ExpenseTable.setBounds(922, 337, 245, 184);

						
						
						
						incomeScrollPane.setBounds(39, 105, 244, 260);		
						ExpenseScrollPane.setBounds(323, 105, 244, 260);
						incomeScrollPane.setViewportView(incomeTable);
						ExpenseScrollPane.setViewportView(ExpenseTable);
						
						incomeExpensePanel.add(incomeScrollPane);
						incomeExpensePanel.add(ExpenseScrollPane);
					}
				});
				
				incomeExpensePanel.setVisible(true);
				
			}
		});
		
		
		
		
		
		
		

		
	}
	
	
	
	
	//************************************************************************
	
	
	Boolean isInInterval(String date1, String date2, String temp) {
		Boolean flag = false;
		int[] date1Arr = new int[3];
		int[] date2Arr = new int[3];
		int[] tempDate = new int[3];
		for (int i = 0; i < date1Arr.length; i++) {
			String[] tp = date1.split("-");
			date1Arr[i]=Integer.parseInt(tp[i]);
			
			String[] tp2 = date2.split("-");
			date2Arr[i]=Integer.parseInt(tp2[i]);
		}
		
		
		String[] tempDateSt = temp.split("-");
		for (int i = 0; i < tempDate.length; i++) {
			tempDate[i] = Integer.parseInt(tempDateSt[i]);
		}
		
		if (date1Arr[2]==date2Arr[2] && date1Arr[2] ==tempDate[2]) {
			
			if (date1Arr[1]==tempDate[1] && tempDate[1]==date2Arr[1]) {
				
				if (date1Arr[0]<=tempDate[0] && tempDate[0]<=date2Arr[0]) {
					flag=true;
				}
				
			}
			
			
			else if (date1Arr[1]<=tempDate[1] && tempDate[1]<=date2Arr[1]) {
				
				if (date1Arr[1]==tempDate[1] && date1Arr[0]<=tempDate[0]) {
					flag=true;
				}
				else if(tempDate[1]==date2Arr[1] && tempDate[0]<=date2Arr[0]){
					flag=true;
				}
				else if(date1Arr[1]<tempDate[1] && tempDate[1]<date2Arr[1]){
					flag=true;
				}
			}
			
			
		}
		
		
		else if (date1Arr[2]<tempDate[2] && tempDate[2]<date2Arr[2]) {
			
			flag=true;
			
		}
		else if (date1Arr[2]==tempDate[2]) {
			if (date1Arr[1]<tempDate[1]) {
				flag=true;
			}
			else if (date1Arr[1]==tempDate[1]) {
				if (date1Arr[0]<tempDate[0]) {
					flag=true;
				}				
			}
		}
		else if (date2Arr[2]==tempDate[2]) {
			if (tempDate[1]<date2Arr[1]) {
				flag=true;
			}
			else if (date2Arr[1]==tempDate[1]) {
				if (tempDate[0]<date2Arr[0]) {
					flag=true;
				}				
			}
		}
		
		else {
			JOptionPane.showMessageDialog(adminFrame, "Invalid date entered!");
		}
		
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	void resetStockDisplay() {
		
		stockDisplayPanel=new JPanel();
		
		stockDisplayPanel.setBackground(new Color(255, 255, 102));

		
		stockDisplayPanel.setBounds(30, 69, 1330, 700);
		adminFrame.getContentPane().add(stockDisplayPanel);
		stockDisplayPanel.setVisible(false);
		stockDisplayPanel.setLayout(null);
		
		
		JLabel lblFoodStock = new JLabel("Food Stock");
		lblFoodStock.setBackground(new Color(255, 255, 102));
		lblFoodStock.setBounds(105, 10, 96, 19);
		stockDisplayPanel.add(lblFoodStock);
		

		
		
		JLabel lblDrinkStock = new JLabel("Drink Stock");
		lblDrinkStock.setBackground(new Color(255, 255, 102));
		lblDrinkStock.setBounds(400, 10, 96, 19);
		stockDisplayPanel.add(lblDrinkStock);
		

		
		JLabel lblOtherStock = new JLabel("Other Stock");
		lblOtherStock.setBackground(new Color(255, 255, 102));
		lblOtherStock.setBounds(705, 10, 96, 19);
		stockDisplayPanel.add(lblOtherStock);
		
		
		

	}
	
	void resetTables(JTable foodTable, JTable drinkTable, JTable otherTable) {
		scrollPaneFood = new JScrollPane();
		scrollPaneFood.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneFood.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFood.setBounds(10, 36,280, 300);
		scrollPaneFood.setViewportView(foodTable);
		


		
		scrollPaneDrink = new JScrollPane();
		scrollPaneDrink.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneDrink.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDrink.setBounds(310, 36,280, 300);
		scrollPaneDrink.setViewportView(drinkTable);

		
		scrollPaneOther = new JScrollPane();
		scrollPaneOther.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneOther.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneOther.setBounds(610, 36,280, 300);
		scrollPaneOther.setViewportView(otherTable);
		
		stockDisplayPanel.add(scrollPaneFood);
		stockDisplayPanel.add(scrollPaneDrink);
		stockDisplayPanel.add(scrollPaneOther);
	}
	void resetScroll() {
		scrollPaneFood.remove(foodTable);
		scrollPaneFood.remove(drinkTable);
		scrollPaneFood.remove(otherTable);
		stockDisplayPanel.remove(scrollPaneFood);
		stockDisplayPanel.remove(scrollPaneDrink);
		stockDisplayPanel.remove(scrollPaneOther);
	}
	void resetStockDelete() {
		stockDeletePanel.remove(deleteProductTxt);
		stockDeletePanel.remove(stockDeletePanel2);
		stockDeletePanel2.remove(slider);
		slider=new JSlider();
		numberOfProductLabel.setText("Number Of Product");
	}
	void incomeExpenseReset() {
		incomeExpensePanel.removeAll();
		incomeExpensePanel=new JPanel();
		incomeExpensePanel.setBackground(new Color(255, 255, 102));
		incomeExpensePanel.setBounds(30, 69, 1330, 700);
		adminFrame.getContentPane().add(incomeExpensePanel);
		incomeExpensePanel.setVisible(false);
		incomeExpensePanel.setLayout(null);
	}




	public JFrame getAdminFrame() {
		return adminFrame;
	}




	public void setAdminFrame(JFrame adminFrame) {
		this.adminFrame = adminFrame;
	}
	
	
	
}
