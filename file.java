package test_file3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Vector;

public class file {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream e = null;
		FileOutputStream e1 = null;
		int r;
		try {
			File t = new File("D:\\th\\t.txt");
			e = new FileInputStream(t);
			File t1 = new File("D:\\th\\t1.txt");
			e1 = new FileOutputStream(t1);
			r = e.read();
			while(r!=-1) {
				e1.write((char)r);
				r = e.read();	
			}	
		}catch(Exception e4) {
			System.out.println(e4.getMessage());
		}
		finally {
			try {
				e.close();
				e1.close();
			}catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
