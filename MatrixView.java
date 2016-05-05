import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MatrixView extends JPanel {

	int amtVar;
	int amtEq;
	
	public MatrixView(int amtVar, int amtEq) {
		this.amtEq = amtEq;
		this.amtVar = amtVar;
	}
	
	public void initialize(){
		this.setBounds(200, 800, 600, 600);
		this.setLayout(new GridLayout(amtEq, amtVar));
		for (int i = 0; i < amtVar; i++){
			for (int j= 0; j < amtEq; j++){
				this.add(new JTextField());
			}
		}
	}
	

}
