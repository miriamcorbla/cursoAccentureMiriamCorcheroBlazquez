package comunicaciones01.tcpsimple;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ClienteURL {

	public static void main(String[] args) {
		/*try {
			URL url = new URL("http://www.recursosformacion.com/wordpress");
			URLConnection urlcon = url.openConnection();
			
			urlcon.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			InputStream stream = urlcon.getInputStream();
			int i;
			while((i = stream.read()) != -1) {
				System.out.println((char) i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		try {
			URL url = new URL("http://www.recursosformacion.com/wordpress");
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			for(int i = 1; i<=8; i++) {
				System.out.println(huc.getHeaderFieldKey(i) + " = " + huc.getHeaderField(i));
			}
			huc.disconnect();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
