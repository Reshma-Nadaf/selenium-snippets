package seleMiniProjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DDTPropertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir")+"/PropertiesFolder/"+"config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		
		String url = prop.getProperty("url");
		System.out.println(url);
		System.out.println("username");
	}

}
