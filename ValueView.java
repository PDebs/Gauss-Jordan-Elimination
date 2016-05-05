import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ValueView extends JFrame {

	String text = "Please fill out the Matrix";
	int amtVar;
	int amtEq;
	MatrixView mView;
	
	public ValueView(int amtVar, int amtEq){
		this.amtVar = amtVar;
		this.amtEq = amtEq;
	}
	
	public void initialize(){
		this.setSize(1000, 800);
		this.setLayout(new GridLayout(3, 1));
		mView = new MatrixView(amtVar, amtEq);
		JTextField instructions = new JTextField(text);
		this.add(instructions);
		mView.initialize();
		this.add(mView);
		JButton submit = new JButton("Submit");
		submit.addActionListener(new getAnswerController(this));
		this.add(submit);
	}
	
}
