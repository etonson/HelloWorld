package connsql;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

public class DruidToSql {


	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("D:\\apconf\\datasource.xml");
			Document doc = new SAXBuilder().build(new InputStreamReader(fis, "utf-8"));
			DBObject.init(doc.getRootElement(),null);
			Connection cn = DBObject.getConnection();
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.lottory_winning");
			while (rs.next()) {
				System.out.print(rs.getString("result") + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
