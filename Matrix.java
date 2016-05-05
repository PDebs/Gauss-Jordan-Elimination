import java.util.ArrayList;

public class Matrix {

	int amtCol;
	int amtRow;
	ArrayList<Row> rows;
	
	public Matrix(ArrayList<Row> rows){
		this.amtCol = rows.get(0).size();
		this.amtRow = rows.size();
		this.rows = rows;
	}
	
	public void setValue(int row, int col, int val){
		rows.get(row).setVal(col, val);
	}
	
	public void subtractRow(int plus, int minus){
		rows.get(plus).subtractRow(rows.get(plus));
	}
	
	public void multiplyRow(int row, int val){
		rows.get(row).multiplyRow(val);
	}

	public void gaussJordanElimination() {
		System.out.println("Starting to solve");
		leadZeros();
		backZeros();		
	}
	
	public void leadZeros(){
		for (int i = 0; i < rows.size(); i++){
			if (i != rows.size() - 1){
			rows.get(i).createLeadZeros(rows.get(i+1));
			}
		}
	}
	
	public void backZeros(){
		while (!this.isSolved()){
			for (int i = rows.size(); i > 0; i--){
				if (i > 1){
				rows.get(i).clearBack(rows.get(i-1));
				}
			}
		}
	}

	public boolean isSolved() {
		
		for (int i = 0; i < rows.size(); i++){
			for (int j = 0; j < rows.get(0).size(); j++){
				
				if (i == j){
					if (!(rows.get(i).getVal(j) == 1)) 
						return false;
				}
				else
				if (!(rows.get(i).getVal(j) == 0)) 
					return false;
			}
		}
		return true;
	}
	
	public boolean equals(Matrix m){
		if (m.amtCol != amtCol || m.amtRow != amtRow) return false;
		for (int i = 0; i < m.amtRow; i++){
			for (int j = 0; j < m.amtCol; j++){
				if (m.getVal(i, j) != this.getVal(i, j)) return false;
			}
		}
		return true;
	}

	private float getVal(int row, int col) {	
		return rows.get(row).getVal(col);
	}
	
	public String toString(){
		String answer = "";
		for (Row r : rows){
			for (int i = 0; i < r.size(); i++){
				answer = answer + r.getVal(i) + " ";
			}
		}
		return answer;
	}
}
