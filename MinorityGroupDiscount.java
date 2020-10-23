
public class MinorityGroupDiscount implements IDiscountStrategy {

	@Override
	public int getTotal(Registration reg) {

		double discount = reg.getTotal() * 0.10;
		int Discount = (int) discount;
		return Discount;

	}

}
