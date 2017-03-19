import java.io.*;
public class GenerateTxt {

	public static void writeToTxtByFileWriter(File file, String content){
		BufferedWriter bw = null;
		try {
		FileWriter fw = new FileWriter(file, true);
		bw = new BufferedWriter(fw);
		bw.write(content);
		} catch (IOException e) {
		e.printStackTrace();
		}finally{
		try {
		bw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		}
	public static void main(String[] args) {
		String lujing = "C:\\Users\\shimlong\\Desktop\\scenicWS.txt";
		  File file = new File(lujing);
		  if (!file.getParentFile().exists()) {
		   file.getParentFile().mkdirs();
		  }
		  try {
		   file.createNewFile();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  writeToTxtByFileWriter(file,"Just Test!!!!");
	}

}
