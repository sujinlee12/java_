package day12.product.copy;

public class Notebook extends product {

	double cpu; // GHz
	int ram;
	
	public Notebook(String brand, String codem String name, double cpu, int ram) {
		super(brand, code, name);
		this.cpu =cpu;
		this.ram = ram;
	}

	@Override
	public void print() {
		System.out.println("-------------------");
		System.out.println("브랜드 : "+ brand);
		System.out.println("제품명 : "+ name );
		System.out.println("제품코드 : "+ code);
		System.out.println("CPU : "+ cpu + "GHz");
		System.out.println("램 : "+ cpu + "GHz");
}
