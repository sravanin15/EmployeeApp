package service.serviceImplement;

public class MyException extends Exception{
	String str,str1;
	int id;
	public MyException(String string,int empid,String string1) {
		str=string;
		id=empid;
		str1=string1;
	}
	public String toString(){ 
		return (str+id+str1) ;
	   }
}
