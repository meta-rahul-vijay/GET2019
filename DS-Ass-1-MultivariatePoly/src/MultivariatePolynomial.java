import java.util.ArrayList;


public class MultivariatePolynomial {
	ArrayList<PolynomialTerm> variableTermList = new ArrayList<PolynomialTerm>();

	public MultivariatePolynomial(ArrayList<PolynomialTerm> variableTermList) {
		super();
		this.variableTermList = variableTermList;
	}

	public ArrayList<PolynomialTerm> getVariableTermList() {
		return variableTermList;
	}

	public void setVariableTermList(ArrayList<PolynomialTerm> variableTermList) {
		this.variableTermList = variableTermList;
	}

	public int getDegree() {
		if(this.variableTermList == null){
			throw new AssertionError();
		}
		ArrayList<PolynomialTerm> termList = this.variableTermList;
		int max = 0;
		for(int i = 0 ; i < termList.size() ; i++){
			int sum = 0;
			ArrayList<Variable> varList = termList.get(i).getVariableList();
			for(int j = 0 ; j < varList.size() ; j++){
				sum += varList.get(i).getDegree();
			}
			if(sum > max){
				max = sum;
			}
		}
		return max;
	}

	public void print() {
		for(int i = 0 ; i < this.getVariableTermList().size() ; i++){
			System.out.print(this.getVariableTermList().get(i).getCoefficient());
			ArrayList<Variable> varList = this.getVariableTermList().get(i).getVariableList();
			for(int j = 0 ; j < varList.size() ; j++){
				System.out.print(varList.get(j).getVarName() + "^" + varList.get(j).getDegree());
			}
			if(i == this.getVariableTermList().size() - 1)
				break;
			System.out.print(" + ");
		}
	}
	@Override
	public String toString(){
		String str = "";
		for(int i = 0 ; i < this.getVariableTermList().size() ; i++){
			str += this.getVariableTermList().get(i).getCoefficient();
			ArrayList<Variable> varList = this.getVariableTermList().get(i).getVariableList();
			for(int j = 0 ; j < varList.size() ; j++){
				str += varList.get(j).getVarName() + "^" + varList.get(j).getDegree();
			}
			if(i == this.getVariableTermList().size() - 1)
				break;
			str += " + ";
		}
		return str;
	}
}
