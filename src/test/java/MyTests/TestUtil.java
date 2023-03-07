package MyTests;

import com.excel.lib.util.*;
import java.util.ArrayList;


public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("./src/test/java/MyTests/HalfEbay.xlsx");		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int rowCnt = 2; rowCnt<= reader.getRowCount("Register"); rowCnt++) {
			
			String favname= reader.getCellData("Register", "favname", rowCnt);
			String fullname= reader.getCellData("Register", "fullname", rowCnt);
			String email= reader.getCellData("Register", "email", rowCnt);
			String contact= reader.getCellData("Register", "contact", rowCnt);
			
			
			Object ob[] = {favname,fullname,email,contact};
			myData.add(ob);
		}
		return myData;
	}
    
}
