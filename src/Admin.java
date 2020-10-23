
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Admin {
	private Stock stock;
	private Queue<Employee> Employees;
	private HashMap<String, Double> dailyIncome;
	private HashMap<String, Double> dailyExpense;
	
	private static Admin admin = new Admin();
	
	
	private Admin() {
		this.stock = new Stock();
		this.dailyIncome = new HashMap<String, Double>();
		this.dailyExpense = new HashMap<String, Double>();
		this.Employees = new LinkedList<Employee>();
	}
	public static Admin getAdmin() {
		return admin;
	}

	public void stockDisplay(String productName,String productType) {
		
		
		if (productType.equalsIgnoreCase("Food")) {
			this.stock.getFood().get(productName);
		}
		else if(productType.equalsIgnoreCase("drink")){
			this.stock.getDrink().get(productName);
		}
		else
			this.stock.getOther().get(productName);
		
		
	}

	public void addNewProduct(Product product,String productType) {
	
		if (productType.equalsIgnoreCase("Food")) {
			this.stock.getFood().put(product.getProductName(), (Food) product);
			
		}
		else if(productType.equalsIgnoreCase("Drink")){
			this.stock.getDrink().put(product.getProductName(), (Drink) product);
		}
		else
			this.stock.getOther().put(product.getProductName(), (Other) product);
		
		ExpenseUpdate(product.getUnitPurchasePrice()*product.getNumberOfProduct());
	}

	public void stockAdd(String productName,String productType, int numberOfProduct) {
		if (productType.equalsIgnoreCase("Food")) {
			this.stock.getFood().get(productName).addProduct(numberOfProduct);
			ExpenseUpdate(numberOfProduct*this.stock.getFood().get(productName).getUnitPurchasePrice());
		}
		else if(productType.equalsIgnoreCase("Drink")){
			this.stock.getDrink().get(productName).addProduct(numberOfProduct);
			ExpenseUpdate(numberOfProduct*this.stock.getDrink().get(productName).getUnitPurchasePrice());
		}
		else {
			this.stock.getOther().get(productName).addProduct(numberOfProduct);
			ExpenseUpdate(numberOfProduct*this.stock.getOther().get(productName).getUnitPurchasePrice());
		}
		
	}
	public Boolean newOrExistStock(String productName,String productType, int numberOfProduct) {
		
		if (productType=="Food") {
			if (this.stock.getFood().containsKey(productName)) {
				stockAdd(productName,productType, numberOfProduct);
				return true;
			}
		}
		else if (productType=="Drink") {
			if (this.stock.getDrink().containsKey(productName)) {
				stockAdd(productName,productType, numberOfProduct);
				return true;
			}
		}
		else if (productType=="Other") {
			if (this.stock.getOther().containsKey(productName)) {
				stockAdd(productName,productType, numberOfProduct);
				return true;
			}
		}
		return false;
		
	}

	public void stockDelete(String productName, String productType, int numberOfProduct) {
		
		if (productType.equalsIgnoreCase("food")) {
			this.stock.getFood().get(productName).deleteProduct(numberOfProduct);
		}
		else if(productType.equalsIgnoreCase("drink")){
			this.stock.getDrink().get(productName).deleteProduct(numberOfProduct);
		}
		else
			this.stock.getOther().get(productName).deleteProduct(numberOfProduct);

	}

	public void employeeAdd(String name, double salary) {
		Employee emp = new Employee(name, salary );
		Employees.add(emp);
	}

	public void employeeDelete(String name) {
	
		for (Iterator<Employee> iterator = Employees.iterator(); iterator.hasNext();) {
		    Employee emp = iterator.next();
		    if(emp.getName().equalsIgnoreCase(name)) {
		        iterator.remove();
		    }
		}
	}

	public void incomeUpdate(double income) {
	    String pattern = "dd-MM-yyyy";
		String dateInString =new SimpleDateFormat(pattern).format(new Date());
		String [] date  = new String[3];
		date = dateInString.split("-");
		@SuppressWarnings("deprecation")
		Date dt = new Date(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));	
		if (this.dailyIncome.containsKey(date[0]+"-"+date[1]+"-"+date[2])) {			
			double oldValue=this.getDailyExpense().get(date[0]+"-"+date[1]+"-"+date[2]);
			this.dailyIncome.replace(date[0]+"-"+date[1]+"-"+date[2], oldValue, oldValue+income);			
		}
		else {
			this.dailyIncome.put(date[0]+"-"+date[1]+"-"+date[2], income);
		}
		
	}
	public void ExpenseUpdate(double Expense) {
	    String pattern = "dd-MM-yyyy";
		String dateInString =new SimpleDateFormat(pattern).format(new Date());
		String [] date  = new String[3];
		date = dateInString.split("-");
		@SuppressWarnings("deprecation")
		Date dt = new Date(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));	

		if (this.dailyExpense.containsKey(date[0]+"-"+date[1]+"-"+date[2])) {	
			double oldValue=this.getDailyExpense().get(date[0]+"-"+date[1]+"-"+date[2]);
			this.dailyExpense.replace(date[0]+"-"+date[1]+"-"+date[2], oldValue, oldValue+Expense);	
		}
		else {
			this.dailyExpense.put(date[0]+"-"+date[1]+"-"+date[2], Expense);
		}
	}
	
	
	public Queue<Employee> getEmployees() {
		return Employees;
	}
	
	
	public void setEmployees(Queue<Employee> employees) {
		Employees = employees;
	}


	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public HashMap<String, Double> getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(HashMap<String, Double> dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	public HashMap<String, Double> getDailyExpense() {
		return dailyExpense;
	}

	public void setDailyExpense(HashMap<String, Double> dailyExpense) {
		this.dailyExpense = dailyExpense;
	}


}
