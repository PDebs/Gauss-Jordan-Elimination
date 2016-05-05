import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BeginView extends JFrame{

	String varText = "Please enter the amount of variables:";
	String eqText = "Please enter the amount of equations";
	
	public void initialize() {
		this.setSize(1000, 800);
		this.setLayout(new GridLayout(3, 2));
		JTextField varTextField = new JTextField(varText);
		JTextField eqTextField = new JTextField(eqText);
		JTextField varField = new JTextField();
		JTextField eqField = new JTextField();
		varTextField.setEnabled(false);
		eqTextField.setEnabled(false);
		varField.setEnabled(true);
		eqField.setEnabled(true);
		this.add(varTextField);
		this.add(varField);
		this.add(eqTextField);
		this.add(eqField);
		JButton submit =  new JButton("Submit");
		submit.addActionListener(new getValController(varField, eqField, this));
		this.add(submit);
		this.setVisible(true);
	}

}
