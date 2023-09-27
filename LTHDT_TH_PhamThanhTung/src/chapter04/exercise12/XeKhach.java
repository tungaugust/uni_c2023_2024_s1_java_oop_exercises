package chapter04.exercise12;

/**
 * @author tungpt
 * @version 1.0
 * @created 27-Sep-2023 10:48:24 AM
 */
public class XeKhach extends Xe {

	private int seats;

	public XeKhach(){
		this(4);
	}

	/**
	 * 
	 * @param seats
	 */
	public XeKhach(int seats){
		super(0.2, 0.1);
		setSeats(seats);
	}

	public int getSeats(){
		return seats;
	}

	public double getSpecialConsumptionTax(){
		if (this.seats >= 5) {
			return 0.3;
		}
		return 0.5;
	}

	/**
	 * 
	 * @param seats
	 */
	public void setSeats(int seats){
		this.seats = seats;
	}

	@Override
	public String toString(){
		return "";
	}
}//end XeKhach