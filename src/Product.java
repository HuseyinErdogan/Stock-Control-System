import java.util.Date;

public abstract class Product {

	private String productName;
	private int numberOfProduct;
	private Date entryDate;
	private double unitPurchasePrice, unitSalePrice;
	private String productType;

	public Product(String productType) {
		this.productType=productType;
	}
	
	public Product(String productName, int numberOfProduct, double unitPurchasePrice, double unitSalePrice, String productType) {
		this.productName = productName;
		this.numberOfProduct = numberOfProduct;
		this.entryDate = new Date();
		this.unitPurchasePrice = unitPurchasePrice;
		this.unitSalePrice = unitSalePrice;
		this.productType=productType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void addProduct(int number) {
		setNumberOfProduct(this.numberOfProduct+number);
		setEntryDate(new Date());		
	}
	public void deleteProduct(int number) {
		setNumberOfProduct(this.numberOfProduct-number);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getNumberOfProduct() {
		return numberOfProduct;
	}

	public void setNumberOfProduct(int numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public double getUnitPurchasePrice() {
		return unitPurchasePrice;
	}

	public void setUnitPurchasePrice(double unitPurchasePrice) {
		this.unitPurchasePrice = unitPurchasePrice;
	}

	public double getUnitSalePrice() {
		return unitSalePrice;
	}

	public void setUnitSalePrice(double unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}
	
}
