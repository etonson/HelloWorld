package connsql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LottorySQL {
	private Logger log = LogManager.getFormatterLogger("LogName");

	public boolean lottoryResult(String SixNumber, String UserNumber, String Result) {

//		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Example";
//		String userName = this.user_id;
//		String userPwd = this.password;
		Date now = new Date();
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String ldt = myFmt.format(now);
//        String insert_Str = String.format("INSERT INTO dbo.lottory_winning VALUES ('%s','%s','%s','%s')", SixNumber,UserNumber,ldt,Result);
//		System.out.println(insert_Str);
		String sql = "INSERT INTO dbo.lottory_winning VALUES (?,?,?,?)";
		try (Connection dbConn = DBObject.getConnection(); 
			PreparedStatement ps = dbConn.prepareStatement(sql)) {
			ps.setString(1, SixNumber);
			ps.setString(2, UserNumber);
			ps.setString(3, ldt);
			ps.setString(4, Result);

//			Statement st = dbConn.createStatement();

			ps.executeUpdate();
//			st.executeUpdate(insert_Str);
			log.debug("連線成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("連線失敗!", e);
		}
		return true;
	}

	public String ArrtoStr(int[] UserNumber) {
		String STR;
		String[] StrArr = new String[6];
		for (int i = 0; i <= UserNumber.length - 1; i++) {
			StrArr[i] = Integer.toString(UserNumber[i]);
		}
		STR = String.join("-", StrArr);
		return STR;
	}

	public String ArrlisttoStr(List<Integer> SixNumber) {
		StringBuilder sb = new StringBuilder();
		if (SixNumber.size() > 0) {
			sb.append(SixNumber.get(0));
			for (int i = 1; i <= SixNumber.size() - 1; i++) {
				sb.append("-" + SixNumber.get(i));
			}
		} else {
			sb.append("本期無中獎");
		}
		return sb.toString();
	}

}
