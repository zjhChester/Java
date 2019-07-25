package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class test {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.zjhwork.xyz");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection huc = null;
		huc=(HttpURLConnection) openConnection;
		BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "utf-8"));
		
		String str = "";
		int len =0;
		while((len=br.read())!=-1)
		{
			str+=(char)len;
		}
		System.out.println(str);
	}
}
