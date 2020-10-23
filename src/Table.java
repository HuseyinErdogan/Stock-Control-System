
import java.util.Stack;

public class Table {

	private int TableNumber;
	private Stack<String> OrderList;
	private double TotalBill;

	public Table(int TableNumber) {
		this.TableNumber = TableNumber;
		this.OrderList = new Stack<String>();
		this.TotalBill = 0;
	}
	
	

	public void TableReset() {
		OrderList.clear();
		this.TotalBill = 0;
	}
	public void increaseTotalBill(double price) {
		this.TotalBill+=price;
	}	
	
	
	
	
	
	
	
	public Stack<String> getOrderList() {
		return OrderList;
	}

	public void setOrderList(Stack<String> orderList) {
		OrderList = orderList;
	}

	public int getTableNumber() {
		return TableNumber;
	}

	public void setTableNumber(int tableNumber) {
		TableNumber = tableNumber;
	}

	public double getTotalBill() {
		return TotalBill;
	}

	public void setTotalBill(int TotalBill) {
		this.TotalBill = TotalBill;
	}

}