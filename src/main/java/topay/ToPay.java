package topay;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ToPay {
	public int toPayNonCC(String InformationStr) {
		try {
			String url = "https://paydev.1177pay.com.tw/1177payment/paypage/payment";
			URL postUrl = new URL(url);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) postUrl.openConnection();
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpUrlConnection.setRequestProperty("charset", "utf-8");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			DataOutputStream dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream());
			dataOutputStream.writeChars(InformationStr);
			InputStream inputStream = httpUrlConnection.getInputStream();
			httpUrlConnection.getResponseCode();
			System.out.println("code:   " + httpUrlConnection.getResponseCode());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String stringLine;
			while ((stringLine = bufferedReader.readLine()) != null) {
				System.out.println(stringLine);
			}

		} catch (Exception e) {
			System.out.println("connect error");
		}

		return 0;
	}

	public static void main(String[] args) {
		ToPay t1 = new ToPay();
		int o = t1.toPayNonCC(
				"amount=1500&checksum=206a5fc49ff53af75280502bff82480cc63ef44f16151fa8526269042c87d180&merchantnumber=118030&ordernumber=54613351&paytitle=練習&timestamp=20220509141915RYEGS53726");
		System.out.println(o);
	}
}
