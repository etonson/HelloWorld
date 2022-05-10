package connsql;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Servlet implementation class ConfigLoader
 */

public class ConfigLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String conf;
	public Logger logger;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		conf = config.getInitParameter("configPath");
		System.out.println(conf);
		// 取得log4j.propertie設定擋
		try (FileInputStream fis = new FileInputStream(conf + "log4j2.xml")) {
			ConfigurationSource source = new ConfigurationSource(fis);
			Configurator.initialize(null, source);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 取得druid.xml組態黨
		try (FileInputStream fis = new FileInputStream(conf + "datasource.xml");
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");) {
			Document doc = new SAXBuilder().build(new InputStreamReader(fis, "UTF-8"));
			Element test = doc.getRootElement();
			DBObject.init(test, null);
			logger.info("Druid datasource loaded!");

		} catch (Throwable e) {

			logger.error("載入設定時發生錯誤", e);
			throw new ServletException();
		}
	}

}