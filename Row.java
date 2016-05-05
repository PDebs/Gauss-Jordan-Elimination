import java.awt.List;
import java.util.ArrayList;

public class Row {
	
	/** the vals of the variables. */
	ArrayList<Float> vals;
	/** the constant of the row. */
	float constant;
	/**
	 * The constructor of a row.
	 * @param vals the values to be added.
	 * @param constant the constant to be added.
	 */
	public Row(ArrayList<Float> vals, float constant){
		this.vals = vals;
		this.constant = constant;
	}
	/**
	 * Sets the value at the designated index.
	 * @param index the index to be set.
	 * @param val the value to be added.
	 */
	public void setVal(int index, int val){
		vals.set(index, (float) val);
	}
	/**
	 * Returns the size of the List of values.
	 * @return
	 */
	public int size(){
		return vals.size();
	}
	/**
	 * Sets the List of values.
	 * @param vals the values to be set.
	 */
	public void setRow(ArrayList<Float> vals){
		this.vals = vals;
	}
	/**
	 * Gets the value at the designated index.
	 * @param index the index to be looked at.
	 * @return returns the value at the designated index.
	 */
	public float getVal(int index){
		return vals.get(index);
	}
	/**
	 * Subtracts the constants of two rows.
	 * @param r the subtrahend row.
	 */
	public void subtractConstants(Row r){
		if (r.size() != size()) System.err.println("Rows not same lenght");
		float tempConstant = this.constant;
		this.constant = tempConstant - r.constant;
	}
	/**
	 * Multiplies the constants of two rows.
	 * @param r the values being multiplied.
	 */
	public void multiplyConstant(float t){
		float tempConstant = this.constant;
		this.constant = tempConstant * t;
	}
	/**
	 * Subtracts two rows.
	 * @param r the subtrahend row.
	 */
	public void subtractRow(Row r){
		if (r.size() != size()) System.err.println("Rows not same lenght");
		for (int i = 0; i < size(); i++){
			vals.set(i, vals.get(i) - r.getVal(i));
		}
		this.subtractConstants(r);
	}
	/**
	 * Multiplies two rows.
	 * @param r the rows being multiplied.
	 */
	public void multiplyRow(float t){
		for (int i = 0; i < size(); i++){
			vals.set(i, vals.get(i)* t);
		}
		this.multiplyConstant(t);
	}
	/**
	 * Algebraically Reduces a row such that the first non-zero value is one.
	 */
	public void reduceRow(){
		float temp = 1/vals.get(getLeadPos());
		this.multiplyRow(temp);
		}

	/**
	 * Gets the lead value of this row.
	 * @return returns the lead value.
	 */
	private int getLeadPos() {
		int index = 0;
		for (int i = 0; i < size(); i++){
			if (vals.get(i) != 0){
				index = i;
				return index;
			}
		}
		return index;
	}
	/**
	 * Gets the last non-zero value of this row
	 * @return returns the last value
	 */
	private int getLastPos() {
		int index = 0;
		for (int i = size(); i > 0; i--){
			if (vals.get(i) != 0){
				index = i;
				return index;
			}
		}
		return index;
	}
	/**
	 * Takes two rows and algebraically turns the lead non-zero value of the row into zero using this row.
	 * @param r the row to have its lead value reduced.
	 */
	public void createLeadZeros(Row r){
		this.reduceRow();
		float tempVal = r.getVal(r.getLeadPos());
		Row tempRow = this;
		tempRow.multiplyRow(tempVal);
		r.subtractRow(tempRow);		
	}
	/**
	 * Takes two rows and algebraically turns the last non-zero value of the row into zero using this row.
	 * @param r the row to have its lead value reduced.
	 */
	public void createBackZeros(Row r){
		Row tempRow = this;
		float tempVal = r.getVal(r.getLastPos());
		tempRow.multiplyRow(tempVal);
		r.subtractRow(tempRow);		
	}
	
	
}
