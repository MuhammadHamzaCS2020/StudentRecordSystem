import java.io.IOException;


public class Display {
	// This is Initial Function First time Must be call it load the Data from file to Hash Table... 
	Students student;
	public Display(){
		try {
			this.ShowData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public void  ShowData() throws IOException {
		System.err.println("Display");
		try {
			student=Students.getSingltonObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0; i<student.getSIZE(); i++ ){
			if(student.ArrayStudents[i]!=null){
				System.out.print(i+" ");
				System.out.println(student.ArrayStudents[i].getFirstName()+","+student.ArrayStudents[i].getLastName()+";"+student.ArrayStudents[i].getStudentID()+ ";"+
						student.ArrayStudents[i].getDepartment()+";"+student.ArrayStudents[i].getYear()+";"+student.ArrayStudents[i].getEmail()+";"+
						student.ArrayStudents[i].getFirstPhonNo()+";"+student.ArrayStudents[i].getSecondPhonNo());
			}
		}
	}
	
}
