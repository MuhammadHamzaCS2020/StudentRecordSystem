import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Update implements StudentInterface, ActionListener{
	final int SIZE=8;
	private JButton[] buttons=new JButton[SIZE];
	private String[] names ={"First Name","Last Name","Reg NO","Department","E-mail","Work Phone","Home Phone","All Fields"};

	Update(){
		JFrame frame=new JFrame("Updation Form");
		JPanel panel=new JPanel(new GridLayout(SIZE,1));
		Border border = BorderFactory.createTitledBorder("Perform Action");
		panel.setBorder(border);

		for(int i=0; i<SIZE; i++){
			buttons[i]=new JButton(names[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		frame.add(panel);
		//frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(150,300); 
		frame.setVisible( true ); 
	}
	public boolean Functionality(DirectoryOfStudent temp) {

		return false;
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==buttons[0]){
			new UpDateFirstName();
			System.err.println("gfdsggwrfdfdsgf");
		}
		else if(arg0.getSource()==buttons[1]){
			new UpDateLastName();
		}
		else if(arg0.getSource()==buttons[2]){
			new UpDateRegNo();
		}
		else if(arg0.getSource()==buttons[3]){
			new UpDateDepartment();	
		}
		else if(arg0.getSource()==buttons[4]){
			new UpDateEmail();
		}
		else if(arg0.getSource()==buttons[5]){
			new UpDateWorkPhone();
		}
		else if(arg0.getSource()==buttons[6]){
			new UpDateHomePhone();
		}
		else if(arg0.getSource()==buttons[7]){

		}
		else if(arg0.getSource()==buttons[8]){

		}
	}

}
