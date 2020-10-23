
public class DevelopmentFeeCalculator implements IExtraFeeCalculator {
	@Override
	public int getExtraAmount(int courseTotal) {

		double DevelopmentfeeDouble = courseTotal * 0.10;
		int DevelopmentFee = (int) DevelopmentfeeDouble;
		return DevelopmentFee;

	}
}
