
public class Variable {
	char varName;
	int degree;
	
	public Variable(char varName, int degree) {
		super();
		this.varName = varName;
		this.degree = degree;
	}

	public char getVarName() {
		return varName;
	}

	public void setVarName(char varName) {
		this.varName = varName;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
	
}
