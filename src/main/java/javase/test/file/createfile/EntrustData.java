package javase.test.file.createfile;

public class EntrustData {
	
	/**委托编号*/
	public String entrustNo;
	
	/**批量日期 格式：yyyyMMdd*/
	public String batchDate;
	
	/**计划开始日期*/
	public String planStartDate;
		
	/**计划结束日期 */
	public String planEndDate;
	
	/**实际结束日期   案件提前退回日期*/
	public String actualEndDate;
		
	/**案件号*/
	public String caseNo;
	
	/**信贷产品部客户编号*/
	public String custId;
	
	/**行内客户号*/
	public String bankCustomerId;
	
	/**客户姓名*/
	public String custName;
	
	/**性别 (M:男,F:女)  说明：生成文件时显示中文*/
	public String gender;

	/**证件类别(
	//"I|身份证",	"S|军人军官证",	"H|港澳台居民通行证",	"P|中国护照",	"Z|暂住证",	"C|武警警官证",	
	//"T|临时身份证",	"R|户口簿",	"X|中国居民其他证",	"M|军人士兵证",	"N|军人文职干部证",	"Y|军人其它证件",	
	//"A|武警士兵证",	"B|武警文职干部证","D|武警其它证件",	"F|外国护照",	"G|外国公民其它证件",	"Q|对私临时证件",	"O|其它个人证件")
	  说明：生成文件时显示中文 */
	public String idType;
	
	/**证件号码    说明：全码，无掩码*/
	public String idNo;
	
	/**微信账户逻辑卡号*/
	public String wxLogicalCardNo;
	
	/**手Q账户逻辑卡号*/
	public String phQLogicalCardNo;
	
	/**微信账户扣款卡号*/
	public String wxDDBankAcctNo;
		
	/**手Q账户扣款卡号*/
	public String phQDDBankAcctNo;
	
	/**手Q账户委托金额  说明：手Q账户欠款总额（本金+利息+罚息+费用） 单位：分*/
	public String phQEntrustAmt;;
	
	/**微信账户委托金额  说明：微信账户欠款总额（本金+利息+罚息+费用） 单位：分*/
	public String wxEntrustAmt;
	
	/**委托总金额      手Q账户委托金额+微信账户委托金额*/
	public String entrustAmt;
	
	/**手Q账户逾期阶段(M1,M2,M3,M4,M5,M6+)*/
	public String phQOverDue;
	
	/**微信账户逾期阶段(M1,M2,M3,M4,M5,M6+)*/ 
	public String wxOverDue;
	
	/**账单日 说明：即还款日*/
	public String acctDate;
	
	/**手Q端客户手机 说明：（如果客户有多个手Q端手机号码，手机号码间用“|”分隔）*/
	public String phQPhone;
	
	/**微信端客户手机 说明：（如果客户有多个微信端手机号码，手机号码间用“|”分隔）*/
	public String wxPhone;
	
	/**EMAIL地址*/
	public String email;
	
	/**客户邮编*/
	public String postCode;
	
	/**联系人姓名*/
	public String contactName;
	
	/**联系人单位名称*/
	public String contactUnitName;
	
	/**联系人单位地址*/
	public String contactUnitAddress;
	
	/**联系人家庭地址*/
	public String contactHomeAddress;
	
	/**联系人单位电话*/
	public String contactUnitPhone;
	
	/**联系人家庭电话*/
	public String contactHomePhone;
	
	/**联系人手机*/
	public String contactPhone;
	
	/**亲属关系*/
	public String relationship;

	/**属办公电话*/
	public String relativesOfficePhone;
	
	/**亲属家电*/
	public String relativesHomePhone;
	
	/**人行学历 (A:博士及以上 , B:硕士 ,C :本科 ,D:大专 , E:中专及技校,F:高中,G:初中及以下) 说明：生成文件时显示中文*/
	public String pbcDegree;
	
	/**人行登记住址*/
	public String pbcAddress;
	
	/**人行登记客户单位名称*/
	public String pbcUnitName;
	
	/**人行登记客户单位地址*/
	public String pbcUnitAddress;
	
	/**人行登记客户职务*/
	public String pbcPosition;
	
	/**人行登记客户家庭地址*/
	public String pbcHomeAddress;
	
	/**人行登记客户单位电话*/
	public String pbcUnitPhone;
	
	/**人行登记客户家庭电话*/
	public String pbcHomePhone;
	
	/**人行登记手机*/
	public String pbcPhone;
	
	/**人行登记客户通讯地址*/
	public String pbcContactAddress;
	
	/**人行登记亲属姓名*/
	public String pbcRelativesName;
	
	/**人行登记亲属手机*/
	public String pbcRelativesPhone;
	
	/**户籍曾用名*/
	public String policeOldName;
	
	/**户籍服务住所*/
	public String policeWorkPlace;
	
	/**户籍住址*/
	public String policeAddress;
	
	/**户籍籍贯*/
	public String policeNativePlace;
	
	/**户籍婚姻状况*/
	public String policeMaritalStatus;
	
	/**户籍违法犯罪信息*/
	public String policeCrimeInfo;
	
	/**户籍身份证签发机构*/
	public String policeIssueOffice;
	
	/**预留字段1*/
	public String reserved01;
	
	/**预留字段2*/
	public String reserved02;
	
	/**预留字段3*/
	public String reserved03;
	
	/**预留字段4*/
	public String reserved04;
	
	/**预留字段5*/
	public String reserved05;
	
	/**预留字段6*/
	public String reserved06;
	
	/**预留字段7*/
	public String reserved07;
	
	/**预留字段8*/
	public String reserved08;
	
	/**预留字段9*/
	public String reserved09;
	
	/**预留字段10*/
	public String reserved10;
	
	private boolean isBlank(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	private String F(String str){
		return isBlank(str)?"  ":str.replaceAll("，", ",");
	}
	
	public String bulidToString() {
		return F(entrustNo) + "，" + F(batchDate) + "，" + F(planStartDate) + "，" + F(planEndDate) + "，" + F(actualEndDate)
				+ "，" + F(caseNo) + "，" + F(custId) + "，" + F(bankCustomerId) + "，" + F(custName) + "，" + F(gender)
				+ "，" + F(idType)+ "，" + F(idNo)+ "，" + F(wxLogicalCardNo)+ "，" + F(phQLogicalCardNo)+ "，" + F(wxDDBankAcctNo)
				+ "，" + F(phQDDBankAcctNo) + "，" + F(phQEntrustAmt) + "，" + F(wxEntrustAmt) + "，" + F(entrustAmt) + "，" + F(phQOverDue)
				+ "，" + F(wxOverDue) + "，" + F(acctDate) + "，" + F(phQPhone) + "，" + F(wxPhone) + "，" + F(email) + "，" + F(postCode)
				+ "，" + F(contactName) + "，" + F(contactUnitName) + "，" + F(contactUnitAddress) + "，" + F(contactHomeAddress)
				+ "，" + F(contactUnitPhone) + "，" + F(contactHomePhone) + "，" + F(contactPhone) + "，" + F(relationship)
				+ "，" + F(relativesOfficePhone) + "，" + F(relativesHomePhone) + "，" + F(pbcDegree)+ "，" + F(pbcAddress)
				+ "，" + F(pbcUnitName) + "，" + F(pbcUnitAddress) + "，"	+ F(pbcPosition) + "，" + F(pbcHomeAddress) + "，" + F(pbcUnitPhone)
				+ "，" + F(pbcHomePhone) + "，" + F(pbcPhone)+ "，" + F(pbcContactAddress) + "，" + F(pbcRelativesName)
				+ "，" + F(pbcRelativesPhone) + "，"	+ F(policeOldName) + "，" + F(policeWorkPlace) + "，" + F(policeAddress)
				+ "，" + F(policeNativePlace) + "，" + F(policeMaritalStatus) + "，" + F(policeCrimeInfo) + "，" + F(policeIssueOffice)
				+ "，" + F(reserved01) + "，" + F(reserved02) + "，" + F(reserved03) + "，" + F(reserved04) + "，" + F(reserved05)
				+ "，" + F(reserved06) + "，" + F(reserved07) + "，" + F(reserved08) + "，" + F(reserved09) + "，" + F(reserved10);
	}	
	public static EntrustData parseToModel(String str) throws Exception{
		EntrustData data = new EntrustData();
		String arr[] = str.split("，");		
		if(arr.length != 65){			
			throw new Exception("传入文件数据格式有误!");
		}
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = arr[i].trim(); 
		} 
		data.entrustNo = arr[0];
		data.batchDate = arr[1];
		data.planStartDate = arr[2];
		data.planEndDate = arr[3];
		data.actualEndDate = arr[4];
		data.caseNo =arr[5];
		data.custId =arr[6];
		data.bankCustomerId = arr[7];
		data.custName = arr[8];
		data.gender = arr[9];
		data.idType = arr[10];
		data.idNo = arr[11];
		data.wxLogicalCardNo = arr[12];
		data.phQLogicalCardNo = arr[13];
		data.wxDDBankAcctNo = arr[14];
		data.phQDDBankAcctNo = arr[15];		
		data.phQEntrustAmt = arr[16];
		data.wxEntrustAmt = arr[17];
		data.entrustAmt = arr[18];
		data.phQOverDue =  arr[19];		
		data.wxOverDue =  arr[20];
		data.acctDate =  arr[21];
		data.phQPhone =  arr[22];
		data.wxPhone =  arr[23];
		data.email =  arr[24];
		data.postCode =  arr[25];
		data.contactName =  arr[26];
		data.contactUnitName =  arr[27];
		data.contactUnitAddress =  arr[28];
		data.contactHomeAddress =  arr[29];
		data.contactUnitPhone =  arr[30];
		data.contactHomePhone =  arr[31];
		data.contactPhone =  arr[32];
		data.relationship =  arr[33];
		data.relativesOfficePhone =  arr[34];
		data.relativesHomePhone =  arr[35];
		data.pbcDegree =  arr[36];
		data.pbcAddress =  arr[37];
		data.pbcUnitName =  arr[38];
		data.pbcUnitAddress =  arr[39];	
		data.pbcPosition =  arr[40];	
		data.pbcHomeAddress =  arr[41];	
		data.pbcUnitPhone =  arr[42];	
		data.pbcHomePhone =  arr[43];	
		data.pbcPhone =  arr[44];	
		data.pbcContactAddress =  arr[45];	
		data.pbcRelativesName =  arr[46];	
		data.pbcRelativesPhone =  arr[47];	
		data.policeOldName =  arr[48];	
		data.policeWorkPlace =  arr[49];	
		data.policeAddress =  arr[50];	
		data.policeNativePlace =  arr[51];	
		data.policeMaritalStatus =  arr[52];	
		data.policeCrimeInfo =  arr[53];	
		data.policeIssueOffice =  arr[54];	
		data.reserved01 = arr[55];
		data.reserved02 = arr[56];
		data.reserved03 = arr[57];
		data.reserved04 = arr[58];
		data.reserved05 = arr[59];
		data.reserved06 = arr[60];
		data.reserved07 = arr[61];
		data.reserved08 = arr[62];
		data.reserved09 = arr[63];
		data.reserved10 = arr[64];
		return data;
	}


	@Override
	public String toString() {
		return "EntrustData [entrustNo=" + entrustNo + ", batchDate=" + batchDate + ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", actualEndDate=" + actualEndDate + ", caseNo=" + caseNo + ", custId=" + custId + ", bankCustomerId=" + bankCustomerId + ", custName=" + custName + ", gender=" + gender
				+ ", idType=" + idType + ", idNo=" + idNo + ", wxLogicalCardNo=" + wxLogicalCardNo + ", phQLogicalCardNo=" + phQLogicalCardNo + ", wxDDBankAcctNo=" + wxDDBankAcctNo + ", phQDDBankAcctNo=" + phQDDBankAcctNo
				+ ", phQEntrustAmt=" + phQEntrustAmt + ", wxEntrustAmt=" + wxEntrustAmt + ", entrustAmt=" + entrustAmt + ", phQOverDue=" + phQOverDue + ", wxOverDue=" + wxOverDue + ", acctDate=" + acctDate + ", phQPhone="
				+ phQPhone + ", wxPhone=" + wxPhone + ", email=" + email + ", postCode=" + postCode + ", contactName=" + contactName + ", contactUnitName="
				+ contactUnitName + ", contactUnitAddress=" + contactUnitAddress + ", contactHomeAddress=" + contactHomeAddress + ", contactUnitPhone=" + contactUnitPhone + ", contactHomePhone=" + contactHomePhone
				+ ", contactPhone=" + contactPhone + ", relationship=" + relationship + ", relativesOfficePhone=" + relativesOfficePhone + ", relativesHomePhone=" + relativesHomePhone
				+ ", pbcDegree=" + pbcDegree + ", pbcAddress=" + pbcAddress
				+ ", pbcUnitName=" + pbcUnitName + ", pbcUnitAddress=" + pbcUnitAddress
				+ ", pbcPosition=" + pbcPosition + ", pbcHomeAddress=" + pbcHomeAddress
				+ ", pbcUnitPhone=" + pbcUnitPhone + ", pbcHomePhone=" + pbcHomePhone
				+ ", pbcPhone=" + pbcPhone + ", pbcContactAddress=" + pbcContactAddress
				+ ", pbcRelativesName=" + pbcRelativesName + ", pbcRelativesPhone=" + pbcRelativesPhone
				+ ", policeOldName=" + policeOldName + ", policeWorkPlace=" + policeWorkPlace
				+ ", policeAddress=" + policeAddress + ", policeNativePlace=" + policeNativePlace
				+ ", policeMaritalStatus=" + policeMaritalStatus + ", policeCrimeInfo=" + policeCrimeInfo
				+ ", policeIssueOffice=" + policeIssueOffice + ", reserved01=" + reserved01 
				+ ", reserved02=" + reserved02  + ", reserved03=" + reserved03 
				+ ", reserved04=" + reserved04  + ", reserved05=" + reserved05  
				+ ", reserved06=" + reserved06  + ", reserved07=" + reserved07 
				+ ", reserved08=" + reserved08  + ", reserved09=" + reserved09
				+ ", reserved10=" + reserved10 + "]";
	}


	
	

}
