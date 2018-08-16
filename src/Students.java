import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Students {
	DirectoryOfStudent[] ArrayStudents,SortedStudent;
	private int SIZE,Key,PrimeNo;
	private static Students students;
	private StudentInterface studentinterface;


	private Students() throws IOException {       // This is private constructor its means Singleton pattern is apply here... 
		setSIZE(CalculateRecordinFile());         // Call the CalculateRecordinFile and set the SIZE...
		setPrimeNo(getMaxPrimeNo());             // Get the Maximum Prime No and set to PrimeNo of this Class Attribute... 

		ArrayStudents=new DirectoryOfStudent[SIZE];		
		for(int i=0; i<getSIZE(); i++) {
			ArrayStudents[i]=new DirectoryOfStudent();
			ArrayStudents[i]=null;
		}
		this.LoadDataFromFile();
	}
	public static  Students getSingltonObject() throws IOException{
		if(students==null){
			students=new Students();
		}
		return students;
	}

	// This is Initial Function First time Must be call it load the Data from file to Hash Table... 
	public void LoadDataFromFile() throws IOException {
		File TextFile = new File("namal.txt");
		FileReader fr=new FileReader(TextFile);
		BufferedReader fw = new BufferedReader(fr);
		
		String str=null;           // Read From File String 
		String[] SpliterStr=null;  // Split the Above string and Store every filed on the ";"
		String[] str1=null;        // It will store the First and Second Name from Zero index of Splitter String
		while ((str = fw.readLine()) != null) {
			SpliterStr=str.split(";");
			str1=SpliterStr[0].split(",");
			DirectoryOfStudent temp=new DirectoryOfStudent();
			temp.setLastName(str1[0]);
			temp.setFirstName(str1[1]);
			temp.setStudentID(SpliterStr[1]);
			temp.setDepartment(SpliterStr[2]);
			temp.setYear(SpliterStr[3]);
			temp.setEmail(SpliterStr[4]);
			temp.setFirstPhonNo(SpliterStr[5]);
			temp.setSecondPhonNo(SpliterStr[6]);
		    this.Insert(temp);
		}
	}
	
	public boolean Insert(DirectoryOfStudent obj) {
		obj.setKey(this.ConvertStringToASCII(obj.getLastName()));
		int key=this.HashFunction(obj.getKey());
		int ind=0;
		while(true){
			if(key==getSIZE()-1 || (key+(ind*ind))>getSIZE()-1){
				key=0;
			}
			if(ArrayStudents[key+(ind*ind)]==null){
				ArrayStudents[key+(ind*ind)]=obj;
				break;
			}
			else{
				ind++;
			}
		}
		return false;
	}

	// This Function Accept a string and convert it into Integer....
	public int ConvertStringToInt(String str) {
		int sum=0,i=0,temp;
		while(i<str.length()) {
			temp=str.charAt(i)-48;
			sum=sum*10;
			sum+=temp;
			i++;
		}
		//System.out.println(sum);
		return sum;
	}
	// This Function accept the String and Return its ASCII Value...
	public int ConvertStringToASCII(String str) {
		int counter=0;
		for(int i=0; i<str.length(); i++) {
			counter+=(int)str.charAt(i);
		}
		return counter;
	}

	// Hash Function return the Key...
	public int HashFunction(int key) {
		int Hx=key%getPrimeNo();
		setKey(Hx);
		return Hx;
	}

	//  This Function calculate the No of Rows or Record in the File and return it...
	private int CalculateRecordinFile() throws IOException {
		File TextFile = new File("namal.txt");
		FileReader fr=new FileReader(TextFile);
		BufferedReader fw = new BufferedReader(fr);
		String str=null;
		int counter=0;
		while ((str = fw.readLine()) != null) {
			counter++;
		}
		fw.close();
		return counter;
	}

	// This function return the  greatest prime no within size value... 
	private int getMaxPrimeNo() {
		int flage=0;
		for(int i=this.SIZE; i>=1; i--) {
			flage=0;
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					flage=1;
					break;
				}
			}
			if(flage==0) {
				return i;
			}
		}
		return 1;
	}
	public DirectoryOfStudent[] getArrayStudents() {
		return ArrayStudents;
	}
	public void setArrayStudents(DirectoryOfStudent[] arrayStudents) {
		ArrayStudents = arrayStudents;
	}
	public DirectoryOfStudent[] getSortedStudent() {
		return SortedStudent;
	}
	public void setSortedStudent(DirectoryOfStudent[] sortedStudent) {
		SortedStudent = sortedStudent;
	}
	public int getSIZE() {
		return SIZE;
	}
	public void setSIZE(int sIZE) {
		SIZE = 2*sIZE;
	}
	public int getKey() {
		return Key;
	}
	public void setKey(int key) {
		Key = key;
	}
	public int getPrimeNo() {
		return PrimeNo;
	}
	public void setPrimeNo(int primeNo) {
		PrimeNo = primeNo;
	}

}
