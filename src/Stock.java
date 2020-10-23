import java.util.HashMap;
import java.util.Map;

public class Stock {

	HashMap<String, Food> food ;
	HashMap<String, Drink> drink ;
	HashMap<String, Other> other;

	public Stock() {
		this.food = new HashMap<String, Food>();
		this.drink = new HashMap<String, Drink>();
		this.other  = new HashMap<String, Other>();
	}
	

	public HashMap<String, Food> getFood() {
		return food;
	}

	public void setFood(HashMap<String, Food> food) {
		this.food = food;
	}

	public HashMap<String, Drink> getDrink() {
		return drink;
	}

	public void setDrink(HashMap<String, Drink> drink) {
		this.drink = drink;
	}

	public HashMap<String, Other> getOther() {
		return other;
	}

	public void setOther(HashMap<String, Other> other) {
		this.other = other;
	}
	public String[][] getFoodString(){
		
		
		String[][] temp = new String[food.size()][3];
		int i = 0;
		for (Map.Entry<String, Food> element : food.entrySet()) {
			String[] temp2= new String[3];
			temp2[0]=element.getValue().getProductName();
			temp2[1]=Integer.toString(element.getValue().getNumberOfProduct());
			temp2[2]=element.getValue().getEntryDate().toString();
			
			for (int j = 0; j < 3; j++) {
				temp[i][j]=temp2[j];
			}
			i++;
		}
		
		return temp;
		
	}
	public String[][] getDrinkString(){
		
		String[][] temp = new String[drink.size()][3];
		int i = 0;
		for (Map.Entry<String, Drink> element : drink.entrySet()) {
			String[] temp2= new String[3];
			temp2[0]=element.getValue().getProductName();
			temp2[1]=Integer.toString(element.getValue().getNumberOfProduct());
			temp2[2]=element.getValue().getEntryDate().toString();
			
			for (int j = 0; j < 3; j++) {
				temp[i][j]=temp2[j];
			}
			i++;
		}
		
		return temp;
		
	}
	public String[][] getOtherString(){
		
		String[][] temp = new String[other.size()][3];
		int i = 0;
		for (Map.Entry<String, Other> element : other.entrySet()) {
			String[] temp2= new String[3];
			temp2[0]=element.getValue().getProductName();
			temp2[1]=Integer.toString(element.getValue().getNumberOfProduct());
			temp2[2]=element.getValue().getEntryDate().toString();
			
			for (int j = 0; j < 3; j++) {
				temp[i][j]=temp2[j];
			}
			i++;
		}
		
		return temp;
		
	}

}
