package javase.test.file.createfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseFile {
	
	private final static String SIGN_KEY = "aa@#@#TSEWEWW#$&**ijme419iew23FF";  //huadao 
//	private final static String SIGN_KEY = "bb@#@#902w34rlgwe4234240234jfa9e";  //huatuo
//	private final static String SIGN_KEY = "cc@#@#EFA23EFW9902342240234jfatt";  //yinfutong
	
	
	public static List<EntrustData> parseEntrustDataFile(String dataFileName) throws Exception{
		
		List<EntrustData> arr = new ArrayList<EntrustData>();
		
		BufferedReader br = new BufferedReader(new FileReader(dataFileName));
		String s = br.readLine();
		while (s != null) {
			if ("".equals(s.trim()) == false) {
				EntrustData data = EntrustData.parseToModel(s);
				arr.add(data);
			}
			s = br.readLine();
		}
		br.close();
		return arr;
	}
	
	public static List<BalanceData> parseBanlanceDataFile(String dataFileName) throws Exception{
		
		List<BalanceData> arr = new ArrayList<BalanceData>();
		
		BufferedReader br = new BufferedReader(new FileReader(dataFileName));
		String s = br.readLine();
		while (s != null) {
			if ("".equals(s.trim()) == false) {
				BalanceData data = BalanceData.parseToModel(s);
				arr.add(data);
			}
			s = br.readLine();
		}
		br.close();
		return arr;
	}
	
	private static String getBatchDate(){
//		Date day = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");			
//		return sdf.format(day);
		return "20250420";
	}

	public static void main(String[] args) throws Exception {

		String srcZip = "e:\\tmp\\" + "COLLECTION_FILE_" + getBatchDate() + ".zip";
		String zipDir = "e:\\tmp\\unzip";
		String workDir = zipDir + "\\" + "COLLECTION_FILE_" + getBatchDate();
		
		//解压
		ZipUtils.decompress(srcZip , zipDir);  	
		
		
		String dstEntrustDataFileName = workDir  + "\\ENTRUST_FILE_" + getBatchDate();
		String dstEntrustKeyFileName = dstEntrustDataFileName + ".verfiy";
		
		String dstBanlanceDataFileName = workDir+ "\\BALANCE_FILE_" + getBatchDate();
		String dstBanlanceKeyFileName = dstBanlanceDataFileName + ".verfiy";
		boolean isOk = false;
		//委案文件验签
		isOk = FileHandle.verifyFile(dstEntrustDataFileName,dstEntrustKeyFileName,SIGN_KEY);
		if(!isOk){
			System.out.println("签名不正确，文件不可信");
			return ;
		}
		
		//余额文件验签
		isOk = FileHandle.verifyFile(dstBanlanceDataFileName,dstBanlanceKeyFileName,SIGN_KEY);
		if(!isOk){
			System.out.println("签名不正确，文件不可信");
			return ;
		}
		
		//读取委案文件内容
		List<EntrustData> arrEntrust = parseEntrustDataFile(dstEntrustDataFileName);
		if(arrEntrust != null && arrEntrust.size() > 0){
			for(EntrustData data : arrEntrust){
				System.out.println("entrust:" + data.toString());
			}
		}
		
		//读取委案文件内容
		List<BalanceData> arrBanlance = parseBanlanceDataFile(dstBanlanceDataFileName);
		if(arrBanlance != null && arrBanlance.size() > 0){
			for(BalanceData data : arrBanlance){
				System.out.println("banlance:" + data.toString());
			}
		}
	}
	
}
