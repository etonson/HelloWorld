package sqltoexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SqltoExcel {

	public static void main(String[] args) {
		// use for excel-----------
		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");
		// Create row object
		XSSFRow row;
		Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
		// -----------
		String userName = "sa";
		String userPwd = "Aa123456";
		String query = "SELECT * FROM dbo.lottory_winning";
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Example";
		try {
			Class.forName(driverName);
			System.out.println("載入驅動成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("載入驅動失敗！");
		}
		try {
			Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("連線成功！");
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			empinfo.put("1", new Object[] { "中獎號碼", "您的號碼", "對獎日期", "結果" });
			int i = 2;
			while (rs.next()) {
				empinfo.put(String.valueOf(i), new Object[] { rs.getString("lottory_winning_number"),
						rs.getString("user_number"), rs.getString("result_time"), rs.getString("result") });
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("連線失敗！");
		}

		Set<String> keyid = empinfo.keySet();
		int rowid = 0;

		for (String key : keyid) {
			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}
		// Write the workbook in file system
		try {
			FileOutputStream out = new FileOutputStream(new File("D:\\writeExcel\\Writesheet.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Writesheet.xlsx written successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("excel失敗");
		}
	}

}
