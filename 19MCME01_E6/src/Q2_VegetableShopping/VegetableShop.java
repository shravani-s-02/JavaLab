package Q2_VegetableShopping;

public class VegetableShop {
	String[] veg_list = new String[5];
	double[] veg_costs = new double[5];
	int[] veg_quants = new int[5];
	
	void setVegetables(int vegNum, String vegName, int vegQuant) {
		veg_list[vegNum] = vegName;
		veg_quants[vegNum] = vegQuant;
	}
	
	private void checkVeg (String veg) throws NoItemException{
		for(int i = 0; i < 5; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				return;
			}
		}
		
		throw new NoItemException();
	}
	
	public void listVeg () {
		for(int i = 0; i < 5; i++) {
			System.out.print("\nVegetable " + (i+1) +":" + veg_list[i] );
		}
	}
	
	public void addVeg (String veg, int qty) {
		int vegNum = 0;
		
		for(int i = 0; i < 5; i++) {
			if(veg == veg_list[i]) {
				vegNum = i;
				break;
			}
		}
		
		veg_quants[vegNum] += qty;
		
	}
	
	public void setPrice (String veg, double price) {
		for(int i = 0; i < 5; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				veg_costs[i] = price;
			}
		}
	}
	
	public double getPrice (String veg) {
		try {
			checkVeg(veg);
		}catch(NoItemException e) {
			System.out.print(e.getClass().getName() + "\n");
			return -1;
		}
		
		int vegNum = 0;
		for(int i = 0; i < 5; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				vegNum = i;
				break;
			}
		}
		
		return veg_costs[vegNum];
	}
	
	public double buyItem (String veg, int qty) throws NoStockException{
		int vegNum = 0;
		
		for(int i = 0; i < 5; i++) {
			if(veg_list[i].equalsIgnoreCase(veg)) {
				vegNum = i;
				break;
			}
		}
		
		if(veg_quants[vegNum] < qty ) {
			throw new NoStockException();
		}
		
		addVeg(veg, -qty);
		double price = getPrice(veg)*qty;
		System.out.print("\nCost of purchase:" + price +"\n");
		return price;
	}
}
	