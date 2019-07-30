
// TODO: Auto-generated Javadoc
/**
 * author : Rahul Vijay
 * created 29 July 2019
 * desc : data structure to represent polynomial
 * The Class PolyStructure.
 */
public class PolyStructure {
	
	/** The coefficient. */
	private int coefficient;
	
	/** The exp. */
	private int exp;
	
	/**
	 * Instantiates a new poly structure.
	 *
	 * @param coefficient the coefficient
	 * @param exp the exp
	 */
	public PolyStructure(int coefficient, int exp) {
		super();
		this.coefficient = coefficient;
		this.exp = exp;
	}

	/**
	 * Gets the coefficient.
	 *
	 * @return the coefficient
	 */
	public int getCoefficient() {
		return coefficient;
	}

	/**
	 * Sets the coefficient.
	 *
	 * @param coefficient the new coefficient
	 */
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	/**
	 * Gets the exp.
	 *
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * Sets the exp.
	 *
	 * @param exp the new exp
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}
	
}
