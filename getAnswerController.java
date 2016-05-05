import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class getAnswerController implements ActionListener {

	Matrix matrix;
	ValueView view;
	
	public getAnswerController(ValueView v){
		this.view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		createMatrix();
		AnswerView answer = new AnswerView();
		answer.initialize(matrix);
		answer.setVisible(true);
		view.setVisible(false);
		
	}

	private void createMatrix(){
		ArrayList<Row> rows = new ArrayList<Row>();

		for (int i = 0; i < view.mView.amtEq; i++){
			rows.set(i, new Row(new ArrayList<Float>()));
			for (int j = 0; j < view.mView.amtVar; j++){
				JTextField valField = (JTextField) view.mView.getComponent(i+j);
				int val = Integer.parseInt(valField.getText());
				rows.get(i).setVal(val, val);
				
			}
		}
		matrix = new Matrix(rows);
	}
}
