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

public class Delete implements ActionListener{
	private final int SIZE=2;
	private String[] names={"Enter Last Name: ","          "};
	private JButton submit;
	private MyTextField fields;
	private Students student;
	Delete(){
		JFrame frame=new JFrame("Delete Record");
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(SIZE,SIZE,SIZE,SIZE));
		panel.add(new Label(names[0]));
		fields=new MyTextField(20);
		fields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//customer.setDescription(ActiveField[1].getText()); //Description=ActiveField[1].getText();
			}
		});
		panel.add(fields);
		panel.add(new Label(names[1]));
		submit=new JButton("Submit");
		submit.addActionListener(this);
		submit.setBackground(Color.red);
		panel.add(submit);
		frame.add(panel);
		//frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(300,100); 
		frame.setVisible( true ); 
	}
	public int delete(int key){
		Search se=new Search("Delete");
		//System.out.println(se.search(key),fields.getText());
		return se.search(key, fields.getText());		
	}
	public void actionPerformed(ActionEvent arg0) {
		if(fields.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please Fill the Empty Fields They are requaird for Registration");
		}
		else{
			try {
				student=Students.getSingltonObject();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int flage = delete(student.HashFunction(student.ConvertStringToASCII(fields.getText())));
			if(flage>=0){
				JOptionPane.showMessageDialog(null,student.ArrayStudents[flage].getFirstName()+","+student.ArrayStudents[flage].getLastName()+";"+student.ArrayStudents[flage].getStudentID()+ ";"+
						student.ArrayStudents[flage].getDepartment()+";"+student.ArrayStudents[flage].getYear()+";"+student.ArrayStudents[flage].getEmail()+";"+
						student.ArrayStudents[flage].getFirstPhonNo()+";"+student.ArrayStudents[flage].getSecondPhonNo()+"  is Delete From the Record...");
				student.ArrayStudents[flage]=null;

			}
			else {
				JOptionPane.showMessageDialog(null,"Your Last Name is Incorrect...");				
			}
		}	
	}

}
