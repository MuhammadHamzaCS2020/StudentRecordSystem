import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StudentGUI implements ActionListener {
	private final int SIZE=5;
	private Students student;
	private JButton[] buttons=new JButton[SIZE];
	private String[] discription={"Insert Record: ","Update Record: ","Search ecord: ","Delete Rocord: ","Display All Records: "};
	private String[] names ={"Insert","Update","Search","Delete","Display"};
	public StudentGUI() throws IOException {
		student=Students.getSingltonObject();
		JFrame frame=new JFrame("Student Directory");
		JPanel panel=new JPanel(new GridLayout(SIZE,2));
		Border border = BorderFactory.createTitledBorder("Perform Action");
		panel.setBorder(border);

		for(int i=0; i<SIZE; i++){
			buttons[i]=new JButton(names[i]);
			buttons[i].addActionListener(this);
			panel.add(new Label(discription[i]));
			panel.add(buttons[i]);
		}
		frame.add(panel);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(300, 300); 
		frame.setVisible( true ); 
	}
	public void actionPerformed(ActionEvent click) {

		if(click.getSource()==buttons[0]){
			new Insert();
		}
		else if(click.getSource()==buttons[1]){
			new Update();
		}
		else if(click.getSource()==buttons[2]){
			new Search();
		}
		else if(click.getSource()==buttons[3]){
			new Delete();
		}
		else if(click.getSource()==buttons[4]){
			new Display();
		}
		else{
			System.out.println("10");
		}
	}
}