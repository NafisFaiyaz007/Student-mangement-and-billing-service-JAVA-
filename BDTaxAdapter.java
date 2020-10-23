
/*
	 * It will return the BD tax fee amount based on the total course fees of a
	 * student. This method calls another method calculateVatAmount(total:int) of
	 * the BDTaxCalculator class to get the tax amount. This third-party tax
	 * calculator returns the tax amount in double but we need it to be an integer
	 * value. So, the adapter class provides a method to convert and returns the tax
	 * amount in integer.
	 */
public class BDTaxAdapter extends BDTaxCalculator implements IExtraFeeCalculator {

	@Override
	public int getExtraAmount(int courseTotal) {
		BDTaxCalculator tax = new BDTaxCalculator();
		double taxDouble = tax.calculateVatAmount(courseTotal);
		int taxInt = (int) taxDouble;
		return taxInt;
	}

}
