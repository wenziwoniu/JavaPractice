package javase.test.file.createfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ProduceFile {
	
private final static String SIGN_KEY = "aa@#@#TSEWEWW#$&**ijme419iew23FF";
	
	//生成委案数据文件，及签名文件
	private static void makeEntrustFile(String dataFileName,String keyFileName)throws Exception{			

		//创建委案数据，并写委案文件
		BufferedWriter output = new BufferedWriter(new FileWriter(dataFileName));
		for (int i = 0; i < 10; i++) {
			EntrustData data = new EntrustData();
			data.entrustNo = "entrustNo";
			data.batchDate = "batchDate";
			data.planStartDate = "planStartDate";
			data.planEndDate = "planEndDate";
			data.actualEndDate = "actualEndDate";
			data.caseNo = "caseNo";
			data.custId = "custId";
			data.bankCustomerId = "bankCustomerId";
			data.custName = "custName";
			data.gender = "gender";
			data.idType = "idType";
			data.idNo = "idNo";
			data.wxLogicalCardNo = "wxLogicalCardNo";
			data.phQLogicalCardNo = "phQLogicalCardNo";
			data.wxDDBankAcctNo = "wxDDBankAcctNo";
			data.phQDDBankAcctNo = "phQDDBankAcctNo";	
			data.phQEntrustAmt = "phQEntrustAmt";
			data.wxEntrustAmt = "wxEntrustAmt";
			data.entrustAmt = "entrustAmt";
			data.phQOverDue =  "phQOverDue";		
			data.wxOverDue =  "wxOverDue";
			data.acctDate =  "acctDate";
			data.phQPhone =  "phQPhone";
			data.wxPhone = "wxPhone";
			data.email = "email";
			data.postCode =  "postCode";
			data.contactName =  "contactName";
			data.contactUnitName =  "contactUnitName";
			data.contactUnitAddress =  "contactUnitAddress";
			data.contactHomeAddress =  "contactHomeAddress";
			data.contactUnitPhone =  "contactUnitPhone";
			data.contactHomePhone =  "contactHomePhone";
			data.contactPhone =  "contactPhone";
			data.relationship =  "relationship";
			data.relativesOfficePhone =  "relativesOfficePhone";
			data.relativesHomePhone =  "relativesHomePhone";
			data.pbcDegree =  "pbcDegree";
			data.pbcAddress =  "pbcAddress";
			data.pbcUnitName =  "pbcUnitName";
			data.pbcUnitAddress =  "pbcUnitAddress";	
			data.pbcPosition =  "pbcPosition";	
			data.pbcHomeAddress =  "pbcHomeAddress";	
			data.pbcUnitPhone = "pbcUnitPhone";	
			data.pbcHomePhone =  "pbcHomePhone";	
			data.pbcPhone =  "pbcPhone";	
			data.pbcContactAddress =  "pbcContactAddress";	
			data.pbcRelativesName =  "pbcRelativesName";	
			data.pbcRelativesPhone =  "pbcRelativesPhone";	
			data.policeOldName =  "policeOldName";	
			data.policeWorkPlace = "policeWorkPlace";	
			data.policeAddress =  "policeAddress";	
			data.policeNativePlace =  "policeNativePlace";	
			data.policeMaritalStatus =  "policeMaritalStatus";	
			data.policeCrimeInfo = "policeCrimeInfo";	
			data.policeIssueOffice =  "policeIssueOffice";	
			data.reserved01 = "reserved01";
			data.reserved02 = "reserved02";
			data.reserved03 = "reserved03";
			data.reserved04 = "reserved04";
			data.reserved05 = "reserved05";
			data.reserved06 = "reserved06";
			data.reserved07 = "reserved07";
			data.reserved08 = "reserved08";
			data.reserved09 = "reserved09";
			data.reserved10 = "reserved10";
			
			output.write(data.bulidToString());
			output.newLine();
		}
		output.close();

		// 生成文件md5
		String fileMd5 = FileHandle.getFileMd5(dataFileName);
		// 生成文件签名
		String key = FileHandle.getStrMd5(fileMd5 + SIGN_KEY);
		
		// 写签名文件
		FileHandle.writeKeyToFile(keyFileName, key);
	}
	
	//生成余额数据文件，及签名文件
	private static void makeBalanceFile(String dataFileName,String keyFileName)throws Exception{			

		//创建委托数据，并写委托文件
		BufferedWriter output = new BufferedWriter(new FileWriter(dataFileName));
		for (int i = 0; i < 10; i++) {
			BalanceData data = new BalanceData();
			data.entrustNo = "entrustNo";
			data.caseNo = "caseNo";
			data.custId = "custId";
			data.bankCustomerId = "bankCustomerId";
			data.custName = "custName";
			data.gender = "gender";
			data.idType = "idType";
			data.idNo = "idNo";
			data.wxLogicalCardNo = "wxLogicalCardNo";
			data.phQLogicalCardNo = "phQLogicalCardNo";
			data.wxDDBankAcctNo = "wxDDBankAcctNo";
			data.phQDDBankAcctNo = "phQDDBankAcctNo";
			data.phQEntrustAmt = "phQEntrustAmt";
			data.wxEntrustAmt = "wxEntrustAmt";	
			data.entrustAmt = "entrustAmt";
			data.wxPrincipalAmt = "wxPrincipalAmt";
			data.phQPrincipalAmt = "phQPrincipalAmt";
			data.wxOtherAmt = "wxOtherAmt";
			data.phQOtherAmt = "phQOtherAmt";
			data.phQOverDue = "phQOverDue";
			data.wxOverDue = "wxOverDue";
			data.acctDate = "acctDate";
			data.batchDate = "batchDate";
			data.batchDatePayAmt = "batchDatePayAmt";	
			data.wxBatchDatePayAmt = "wxBatchDatePayAmt";
			data.phQBatchDatePayAmt = "phQBatchDatePayAmt";
			data.status = "status";	
			data.reserved01 = "reserved01";
			data.reserved02 = "reserved02";
			data.reserved03 = "reserved03";
			data.reserved04 = "reserved04";
			data.reserved05 = "reserved05";
			data.reserved06 = "reserved06";
			data.reserved07 = "reserved07";
			data.reserved08 = "reserved08";
			data.reserved09 = "reserved09";
			data.reserved10 = "reserved10";
			
			output.write(data.bulidToString());
			output.newLine();
		}
		output.close();

		// 生成文件md5
		String fileMd5 = FileHandle.getFileMd5(dataFileName);
		
		// 生成文件签名
		String key = FileHandle.getStrMd5(fileMd5 + SIGN_KEY);
		
		// 写签名文件
		FileHandle.writeKeyToFile(keyFileName, key);
	}
	
	
	public static boolean createDir(String destDirName) {  
        File dir = new File(destDirName);  
        if (dir.exists()) {
            return true;  
        }  
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }  
        //创建目录  
        if (dir.mkdirs()) {
            return true;  
        } else {
            return false;  
        }  
    }  
	
	private static String getBatchDate(){
//		Date day = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");			
//		return sdf.format(day);
		return "20140831";
	}
	
	public static void main(String[] args) throws Exception {

		String wordDir = "E:\\tmp\\" + "COLLECTION_FILE_" + getBatchDate();
		
		createDir(wordDir);
		
		String entrustDataFileName = wordDir + "\\ENTRUST_FILE_" + getBatchDate();
		String entrustKeyFileName = entrustDataFileName + ".verfiy";
		
		String banlanceDataFileName = wordDir+ "\\BALANCE_FILE_" + getBatchDate();
		String banlanceKeyFileName = banlanceDataFileName + ".verfiy";
		
		//生成委案文件
		makeEntrustFile(entrustDataFileName,entrustKeyFileName);
		
		//生成余额文件
		makeBalanceFile(banlanceDataFileName,banlanceKeyFileName);
		
		//压缩文件
		ZipUtils.compress(wordDir,wordDir + ".zip");  
		
	}

}
