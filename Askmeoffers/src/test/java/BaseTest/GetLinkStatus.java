package BaseTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;


public class GetLinkStatus {

static int invalidLink;
	
	public static void verifyLink(String linkString) throws IOException {
			
		try {
		URL url = new URL(linkString);
				
		//Open Http Connection
		HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
		
		//Define TimeOut
		urlConnect.setConnectTimeout(50000);
		
		//Hit url
		urlConnect.connect();
		
		if(urlConnect.getResponseCode()==200) {
		}else {
			System.out.println(linkString + " : " + urlConnect.getResponseMessage() + " : " + urlConnect.HTTP_NOT_FOUND);
			invalidLink++;
		}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		public static void getInvalidLinkCount() {
			System.out.println("Total Invalid Links:" + invalidLink);
		}
}
