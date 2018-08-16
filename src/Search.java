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


public class Search implements ActionListener {
	private final int SIZE=2;
	private String[] names={"Enter Last Name: ","          "};
	private JButton submit;
	private MyTextField fields;
	private Students student;
	public Search(String op){

	}
	public Search(){
		JFrame frame=new JFrame("Search Record");
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
		submit.setBackground(Color.green);
		panel.add(submit);
		frame.add(panel);
		//frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(300,100); 
		frame.setVisible( true ); 
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

			int flage = search(student.HashFunction(student.ConvertStringToASCII(fields.getText())),fields.getText());

			if(flage>=0){
				JOptionPane.showMessageDialog(null,student.ArrayStudents[flage].getFirstName()+","+student.ArrayStudents[flage].getLastName()+";"+student.ArrayStudents[flage].getStudentID()+ ";"+
						student.ArrayStudents[flage].getDepartment()+";"+student.ArrayStudents[flage].getYear()+";"+student.ArrayStudents[flage].getEmail()+";"+
						student.ArrayStudents[flage].getFirstPhonNo()+";"+student.ArrayStudents[flage].getSecondPhonNo());
			}
			else {
				JOptionPane.showMessageDialog(null,"Your Last Name is Incorrect...");				
			}
		}
	}

	// This Function Search the Record from the Student Directory...
	public int search(int key,String str){
		try {
			student=Students.getSingltonObject();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int ind=0;
		while(true){
			if((key+(ind*ind))<student.getSIZE()) {
				if( student.ArrayStudents[key+(ind*ind)]==null){
					return -1;
				}
				else if(student.HashFunction(student.ConvertStringToASCII(student.ArrayStudents[key+(ind*ind)].getLastName()))==key && 
						student.ArrayStudents[key+(ind*ind)].getLastName().equals(str)){								
					return key+(ind*ind);
				}
				else{
					if(key==SIZE-1){
						key=0;
					}
					ind++;
				}	
			}
			else {
				return -1;
			}
		}
	}
}
