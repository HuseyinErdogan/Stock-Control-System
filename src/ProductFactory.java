
public class ProductFactory {
	
	private static ProductFactory pF = new ProductFactory();
	public static ProductFactory getProductFactory() {
		return pF;
	}
	public static Product getProduct(String productName, int numberOfProduct, double unitPurchasePrice,
			double unitSalePrice, String productType) {
		if (productType==null) {
			return null;
		}
		if (productType.equalsIgnoreCase("food")) {
			return new Food(productName, numberOfProduct, unitPurchasePrice,
					unitSalePrice);
		}
		else if (productType.equalsIgnoreCase("drink")) {
			System.out.println("******");
			return new Drink (productName, numberOfProduct, unitPurchasePrice,
					unitSalePrice);
		}
		else if (productType.equalsIgnoreCase("other")) {
			return new Other(productName, numberOfProduct, unitPurchasePrice,
					unitSalePrice);
		}
		return null;
	}
}
