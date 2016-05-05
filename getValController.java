import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class getValController implements ActionListener {

	JTextField varField;
	JTextField eqField;
	BeginView view;
	
	public getValController(JTextField varField, JTextField eqField, BeginView view) {
		this.varField = varField;
		this.eqField = eqField;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int amtVar = Integer.parseInt(varField.getText());
		int amtEq = Integer.parseInt(eqField.getText());
		ValueView view = new ValueView(amtVar+1, amtEq);
		view.initialize();
		this.view.setVisible(false);
		view.setVisible(true);
		
	}

}
