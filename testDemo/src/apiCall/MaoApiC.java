package apiCall;
import java.net.*;
import java.io.*;
public class MaoApiC {

	/**
	 * @param args
	 */
	

	/**
	 * @param urlAll
	 *            :����ӿ�
	 * @param httpArg
	 *            :����
	 * @return ���ؽ��
	 */
	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // ����apikey��HTTP header
	        connection.setRequestProperty("apikey",  "030e547389b78b54befb182fad713926");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public static void main(String[] args) {
		String httpUrl = "http://apis.baidu.com/xiaogg/citylocation/citylocation";
		//String httpArg = "city=%E5%8C%97%E4%BA%AC";
		String city="����";
		String httpArg;
		String jsonResult=null;
		try {
			httpArg = "city="+new String(city.getBytes("utf-8"));
			jsonResult = request(httpUrl, httpArg);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonResult);
		
	}

}
