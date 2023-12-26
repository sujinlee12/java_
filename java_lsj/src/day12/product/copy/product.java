package day12.product.copy;

public abstract class product {

	
		String brand, code, name;
		
		public product(String brand, String code, String name) {
			this.brand = brand;
			this.code = code;
			this.name =name;
		}
		
		public abstract void print();
		
}
