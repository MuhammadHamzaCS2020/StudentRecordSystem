import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class UpDateLastName implements ActionListener {
	private final int SIZE=2;
	private String[] names={"Enter Last Name: ","New Last Name: ","         "};
	private JButton submit;
	private MyTextField[] fields=new MyTextField[SIZE];
	private Students student;
	UpDateLastName(){
		JFrame frame=new JFrame("UpDate Last Name");
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(SIZE+1,SIZE+1,SIZE,SIZE));

		for(int i=0; i<SIZE;  i++){
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
		submit.setBackground(Color.green);
		panel.add(submit);
		frame.add(panel);
		//frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(300,150); 
		frame.setVisible( true ); 
	}public int updatename(int key){
		Search se=new Search("Up Date Last Name");
		//System.out.println(se.search(key),fields.getText());
		return se.search(key, fields[0].getText());
	}
	public void actionPerformed(ActionEvent arg0) {
		if(fields[0].getText().isEmpty() || fields[1].getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please Fill the Empty Fields They are requaird for Registration");
		}
		else{
			try {
				student=Students.getSingltonObject();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int flage = updatename(student.HashFunction(student.ConvertStringToASCII(fields[0].getText())));
			if(flage>=0){
				
				student.ArrayStudents[flage].setLastName(fields[1].getText());
				JOptionPane.showMessageDialog(null,student.ArrayStudents[flage].getFirstName()+","+student.ArrayStudents[flage].getLastName()+";"+student.ArrayStudents[flage].getStudentID()+ ";"+
						student.ArrayStudents[flage].getDepartment()+";"+student.ArrayStudents[flage].getYear()+";"+student.ArrayStudents[flage].getEmail()+";"+
						student.ArrayStudents[flage].getFirstPhonNo()+";"+student.ArrayStudents[flage].getSecondPhonNo()+"  Last Name is Changed.");
				DirectoryOfStudent temp=student.ArrayStudents[flage];
				student.ArrayStudents[flage]=null;
				student.Insert(temp);
			}
			else {
				JOptionPane.showMessageDialog(null,"Your Last Name is Incorrect...");				
			}
		}
	}
}
