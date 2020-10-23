import java.util.Date;

public class Food extends Product {

	private static String type = "Food";
	
	public Food(String productName, int numberOfProduct, double unitPurchasePrice,
			double unitSalePrice) {
		super(productName,numberOfProduct,unitPurchasePrice,unitSalePrice,type);
		// TODO Auto-generated constructor stub
	}
	public Food(FoodBuilder foodBuilder) {
		
		super(foodBuilder.productName,foodBuilder.numberOfProduct,foodBuilder.unitPurchasePrice,foodBuilder.unitSalePrice,type);
	}
	public static class FoodBuilder{
			private String productName;
			private int numberOfProduct;
			private double unitPurchasePrice, unitSalePrice;
			
			
			public FoodBuilder productName(String productName) {
				this.productName=productName;
				return this;
			}
			public FoodBuilder numberOfProduct(int numberOfProduct) {
				this.numberOfProduct=numberOfProduct;
				return this;
			}
			public FoodBuilder entryDate(Date entryDate) {
				return this;
			}
			public FoodBuilder unitPurchasePrice(double unitPurchasePrice) {
				this.unitPurchasePrice=unitPurchasePrice;
				return this;
			}
			public FoodBuilder unitSalePrice(double unitSalePrice) {
				this.unitSalePrice=unitSalePrice;
				return this;
			}

			public Food build() {	
				Food pr = new Food(this);
				return pr;
			}
			
			
		}

}