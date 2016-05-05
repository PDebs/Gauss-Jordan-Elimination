import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RowTest {

	@Test
	public void test() {
		ArrayList<Float> list = new ArrayList<Float>();
		for(int i = 0; i < 5; i++){
		list.add((float) i);
		}
		
		Row r = new Row(list);
	}

}
