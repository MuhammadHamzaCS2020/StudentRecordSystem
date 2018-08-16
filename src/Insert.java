import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Insert implements StudentInterface, ActionListener{
	private String[] names={"First Name: ","Last Name: ","Reg No: ","Year: ","Department: ","Emainl: ",
			"Home Phone No: ","Work Phone No: ","        "};
	private JButton submit;
	private final int SIZE=8;
	private MyTextField[] fields=new MyTextField[SIZE];
	private Students student;

	Insert(){
		JFrame frame=new JFrame("Insertion of New Record");
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(9,2));
		for(int i=0; i<SIZE; i++){
			panel.add(new Label(names[i]));
			fields[i]=new MyTextField(20);
			fields[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//customer.setDescription(ActiveField[1].getText()); //Description=ActiveField[1].getText();
				}
			});
			panel.add(fields[i]);
		}
		panel.add(new Label(names[SIZE]));
		submit=new JButton("Submit");
		submit.addActionListener(this);
		panel.add(submit);
		frame.add(panel);
		//frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(300,350); 
		frame.setVisible( true ); 
	}

	public void actionPerformed(ActionEvent arg0) {
		if(!(fields[0].getText().isEmpty()) && !(fields[1].getText().isEmpty()) && !(fields[2].getText().isEmpty()) && 
				!(fields[3].getText().isEmpty()) && !(fields[4].getText().isEmpty()) && !(fields[5].getText().isEmpty()) && 
				!(fields[6].getText().isEmpty()) && !(fields[7].getText().isEmpty())){
			DirectoryOfStudent temp=new DirectoryOfStudent();
			temp.SetData(fields[0].getText(), fields[1].getText(), fields[2].getText(), fields[4].getText(),
					fields[3].getText(), fields[5].getText(), fields[6].getText(), fields[7].getText());
			try {
				student=Students.getSingltonObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			student.Insert(temp);
		}
		else{
			JOptionPane.showMessageDialog(null,"Please Fill the Empty Fields They are requaird for Registration");
		}
	}

	public boolean Functionality(int key) {

		return false;
	}
	public boolean Functionality(DirectoryOfStudent temp) {
		// TODO Auto-generated method stub
		return false;
	}

}
