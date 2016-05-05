import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void test() {
		ArrayList<Row> rows = new ArrayList<Row>();
		for (int i = 0; i < 4; i++){
			rows.add(new Row(new ArrayList<Float>()));
			for (int j = 0; j < 5; j++){
				rows.get(i).vals.add((float) (i+j));
			}
		}
		
		ArrayList<Row> rowsSolved = new ArrayList<Row>();
		for (int i = 0; i < 4; i++){
			rowsSolved.add(new Row(new ArrayList<Float>()));
			for (int j = 0; j < 5; j++){
				if (i == j){
					rowsSolved.get(i).vals.add((float) 1);
				}
				rowsSolved.get(i).vals.add((float) 0);
			}
		}
		
		Matrix m = new Matrix(rows);
		Matrix solved = new Matrix(rowsSolved);
		assertEquals(m.rows.size(), 4);
		m.gaussJordanElimination();
		assertTrue(solved.isSolved());
		assertTrue(m.equals(solved));
	}

}
