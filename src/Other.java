import java.util.Date;

public class Other extends Product {

	private static String type = "Other";
	
	public Other(String productName, int numberOfProduct, double unitPurchasePrice,
			double unitSalePrice) {
		super(productName,numberOfProduct,unitPurchasePrice,unitSalePrice,type);
		// TODO Auto-generated constructor stub
	}
	public Other(OtherBuilder otherBuilder) {
		
		super(otherBuilder.productName,otherBuilder.numberOfProduct,otherBuilder.unitPurchasePrice,otherBuilder.unitSalePrice,type);
	}
	public static class OtherBuilder{
			private String productName;
			private int numberOfProduct;
			private double unitPurchasePrice, unitSalePrice;
			
			
			public OtherBuilder productName(String productName) {
				this.productName=productName;
				return this;
			}
			public OtherBuilder numberOfProduct(int numberOfProduct) {
				this.numberOfProduct=numberOfProduct;
				return this;
			}
			public OtherBuilder entryDate(Date entryDate) {
				return this;
			}
			public OtherBuilder unitPurchasePrice(double unitPurchasePrice) {
				this.unitPurchasePrice=unitPurchasePrice;
				return this;
			}
			public OtherBuilder unitSalePrice(double unitSalePrice) {
				this.unitSalePrice=unitSalePrice;
				return this;
			}

			public Other build() {	
	
				Other pr = new Other(this);
				return pr;
			}
			
			
		}
}
