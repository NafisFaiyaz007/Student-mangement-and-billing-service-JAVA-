
public class AcademicExcellenceDiscount implements IDiscountStrategy {

	@Override
	public int getTotal(Registration reg) {
		double discount = reg.getTotal() * 0.20;
		int Discount = (int) discount;
		return Discount;

	}

}
