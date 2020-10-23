import java.util.Date;

public class Drink extends Product {

	private static String type = "Drink";
	
	public Drink(String productName, int numberOfProduct, double unitPurchasePrice,
			double unitSalePrice) {
		super(productName,numberOfProduct,unitPurchasePrice,unitSalePrice,type);
		// TODO Auto-generated constructor stub
	}
	public Drink(drinkBuilder drinkBuilder) {
		
		super(drinkBuilder.productName,drinkBuilder.numberOfProduct,drinkBuilder.unitPurchasePrice,drinkBuilder.unitSalePrice,type);
	}
	public static class drinkBuilder{
			private String productName;
			private int numberOfProduct;
			private double unitPurchasePrice, unitSalePrice;
			
			
			public drinkBuilder productName(String productName) {
				this.productName=productName;
				return this;
			}
			public drinkBuilder numberOfProduct(int numberOfProduct) {
				this.numberOfProduct=numberOfProduct;
				return this;
			}
			public drinkBuilder entryDate(Date entryDate) {
				return this;
			}
			public drinkBuilder unitPurchasePrice(double unitPurchasePrice) {
				this.unitPurchasePrice=unitPurchasePrice;
				return this;
			}
			public drinkBuilder unitSalePrice(double unitSalePrice) {
				this.unitSalePrice=unitSalePrice;
				return this;
			}

			public Drink build() {	
	
				Drink pr = new Drink(this);
				return pr;
			}
			
			
		}

}
