package chapter04.exercise12;

/**
 * @author tungpt
 * @version 1.0
 * @created 27-Sep-2023 10:48:24 AM
 */
public abstract class Xe {

	private double registrationTax;
	private double VAT;

	public Xe(){
		this(0.0, 0.0);
	}

	/**
	 * 
	 * @param regiregistrationTax
	 * @param VAT
	 */
	public Xe(double regiregistrationTax, double VAT){
		setRegistrationTax(regiregistrationTax);
		setVAT(VAT);
	}

	public double getRegistrationTax(){
		return registrationTax;
	}

	public double getVAT(){
		return VAT;
	}

	/**
	 * 
	 * @param newVal
	 */
	private void setRegistrationTax(double newVal){
		registrationTax = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	private void setVAT(double newVal){
		VAT = newVal;
	}

	@Override
	public String toString(){
		return "";
	}
}//end Xe