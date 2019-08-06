import java.util.ArrayList;


public class PolynomialTerm {
	int coefficient;
	ArrayList<Variable> variableList = new ArrayList<Variable>();
	
	public PolynomialTerm(int coefficient, ArrayList<Variable> variableList) {
		super();
		this.coefficient = coefficient;
		this.variableList = variableList;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public ArrayList<Variable> getVariableList() {
		return variableList;
	}

	public void setVariableList(ArrayList<Variable> variableList) {
		this.variableList = variableList;
	}
	
}
