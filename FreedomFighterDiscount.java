
public class FreedomFighterDiscount implements IDiscountStrategy {

	@Override
	public int getTotal(Registration reg) {
		// it will return the discount amount calculated for a specific student.
		double discount = reg.getTotal() * 0.25;
		int Discount = (int) discount;
		return Discount;
	}

}
