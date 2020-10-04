package javase.test.file.createfile;

public class BalanceData {
	
	/**委托编号*/
	public String entrustNo;
		
	/**案件编号*/
	public String caseNo;
	
	/**客户编号*/
	public String custId;
	
	/**行内客户号*/
	public String bankCustomerId;
	
	/**客户姓名*/
	public String custName;
	
	/**性别 (M:男,F:女) 说明：生成文件时显示中文**/
	public String gender;
	
	/**	证件类别(
	//"I|身份证",	"S|军人军官证",	"H|港澳台居民通行证",	"P|中国护照",	"Z|暂住证",	"C|武警警官证",	
	//"T|临时身份证",	"R|户口簿",	"X|中国居民其他证",	"M|军人士兵证",	"N|军人文职干部证",	"Y|军人其它证件",	
	//"A|武警士兵证",	"B|武警文职干部证","D|武警其它证件",	"F|外国护照",	"G|外国公民其它证件",	"Q|对私临时证件",	"O|其它个人证件")
	 */
	public String idType;
	
	/**证件号码*/
	public String idNo;
	
	/**微信账户逻辑卡号*/
	public String wxLogicalCardNo;
	
	/**手Q账户逻辑卡号*/
	public String phQLogicalCardNo;

	/**微信账户扣款卡号*/
	public String wxDDBankAcctNo;
	
	/**手Q账户扣款卡号*/
	public String phQDDBankAcctNo;
	
	/**手Q账户逾期金额    说明：欠款总额（本金+利息+罚息+费用） 单位:分 */
	public String phQEntrustAmt;
	
	/**微信账户逾期金额   说明：欠款总额（本金+利息+罚息+费用） 单位:分*/
	public String wxEntrustAmt;
	
	/**逾期总金额   手Q账户逾期金额+微信账户逾期金额*/
	public String entrustAmt;
	
	/**微信账户欠款本金总金额 说明：（本金）*/
	public String wxPrincipalAmt;	
	
	/**手Q账户欠款本金总金额 说明：（本金）*/
	public String phQPrincipalAmt;
	
	/**微信账户利息罚息费用总金额  说明：利息+罚息+费用*/
	public String wxOtherAmt;
	
	/**手Q账户利息罚息费用总金额  说明：利息+罚息+费用*/
	public String phQOtherAmt;
	
	/**手Q账户逾期阶段(M1,M2,M3,M4,M5,M6+)*/
	public String phQOverDue;
	
	/**微信账户逾期阶段(M1,M2,M3,M4,M5,M6+)*/ 
	public String wxOverDue;
	
	/**账单日 说明：即还款日*/
	public String acctDate;
	
	/**批量日期  格式：yyyyMMdd*/
	public String batchDate;
	
	/**批量当日还款额    微信当日还款额+手Q当日还款额*/
	public String batchDatePayAmt;
	
	/**微信当日还款额*/
	public String wxBatchDatePayAmt;
	
	/**手Q当日还款额*/
	public String phQBatchDatePayAmt;
	
	/**案件状态：已分配在催(Colling)、已退回(Back)、已结案(Close)、暂停催收(Stop)、过期(Expire)*/
	public String status;
	
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
		return F(entrustNo) + "，" + F(caseNo) + "，" + F(custId) + "，" + F(bankCustomerId) + "，" + F(custName)
				+ "，" + F(gender) + "，" + F(idType) + "，" + F(idNo)+ "，" + F(wxLogicalCardNo)+ "，" + F(phQLogicalCardNo)
				+ "，" + F(wxDDBankAcctNo)+ "，" + F(phQDDBankAcctNo) + "，" + F(phQEntrustAmt) + "，" + F(wxEntrustAmt)
				+ "，" + F(entrustAmt) + "，" + F(wxPrincipalAmt) + "，" + F(phQPrincipalAmt)+ "，" + F(wxOtherAmt)
				+ "，" + F(phQOtherAmt)+ "，" + F(phQOverDue) + "，" + F(wxOverDue) + "，" + F(acctDate) + "，" + F(batchDate)
				+ "，" + F(batchDatePayAmt)+ "，" + F(wxBatchDatePayAmt) + "，" + F(phQBatchDatePayAmt) + "，" + F(status)
				+ "，" + F(reserved01) + "，" + F(reserved02) + "，" + F(reserved03) + "，" + F(reserved04) + "，" + F(reserved05)
				+ "，" + F(reserved06) + "，" + F(reserved07) + "，" + F(reserved08) + "，" + F(reserved09) + "，" + F(reserved10);
	}	
	
	public static BalanceData parseToModel(String str) throws Exception{
		BalanceData data = new BalanceData();
		String arr[] = str.split("，");		
		if(arr.length != 37){			
			throw new Exception("传入文件数据格式有误!");
		}
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = arr[i].trim(); 
		} 
		data.entrustNo = arr[0];
		data.caseNo = arr[1];
		data.custId = arr[2];
		data.bankCustomerId = arr[3];
		data.custName =arr[4];
		data.gender =arr[5];
		data.idType = arr[6];
		data.idNo = arr[7];
		data.wxLogicalCardNo = arr[8];
		data.phQLogicalCardNo = arr[9];
		data.wxDDBankAcctNo = arr[10];
		data.phQDDBankAcctNo = arr[11];
		data.phQEntrustAmt = arr[12];
		data.wxEntrustAmt = arr[13];	
		data.entrustAmt = arr[14];
		data.wxPrincipalAmt = arr[15];
		data.phQPrincipalAmt = arr[16];
		data.wxOtherAmt = arr[17];	
		data.phQOtherAmt = arr[18];	
		data.phQOverDue = arr[19];	
		data.wxOverDue = arr[20];	
		data.acctDate = arr[21];	
		data.batchDate = arr[22];	
		data.batchDatePayAmt = arr[23];	
		data.wxBatchDatePayAmt = arr[24];
		data.phQBatchDatePayAmt = arr[25];
		data.status = arr[26];	
		data.reserved01 = arr[27];
		data.reserved02 = arr[28];
		data.reserved03 = arr[29];
		data.reserved04 = arr[30];
		data.reserved05 = arr[31];
		data.reserved06 = arr[32];
		data.reserved07 = arr[33];
		data.reserved08 = arr[34];
		data.reserved09 = arr[35];
		data.reserved10 = arr[36];
		return data;
	}

	@Override
	public String toString() {
		return "BanlanceData [entrustNo=" + entrustNo + ", caseNo=" + caseNo + ", custId=" + custId + ", bankCustomerId=" + bankCustomerId + ", custName=" + custName + ", gender=" + gender + ", idType=" + idType + ", idNo=" + idNo
				+ ", wxLogicalCardNo=" + wxLogicalCardNo + ", phQLogicalCardNo=" + phQLogicalCardNo + ", wxDDBankAcctNo=" + wxDDBankAcctNo + ", phQDDBankAcctNo=" + phQDDBankAcctNo + ", phQEntrustAmt=" + phQEntrustAmt + ", wxEntrustAmt="
				+ wxEntrustAmt + ", entrustAmt=" + entrustAmt + ", wxPrincipalAmt=" + wxPrincipalAmt + ", phQPrincipalAmt=" + phQPrincipalAmt + ", wxOtherAmt=" + wxOtherAmt
				+ ", phQOtherAmt=" + phQOtherAmt + ", phQOverDue=" + phQOverDue + ", wxOverDue=" + wxOverDue + ", acctDate=" + acctDate
				+ ", batchDate=" + batchDate + ", batchDatePayAmt=" + batchDatePayAmt
			    + ", wxBatchDatePayAmt=" + wxBatchDatePayAmt  + ", phQBatchDatePayAmt=" + phQBatchDatePayAmt + ", status=" + status
			    + ", reserved01=" + reserved01 + ", reserved02=" + reserved02 + ", reserved03=" + reserved03  + ", reserved04=" + reserved04 
			    + ", reserved05=" + reserved05  + ", reserved06=" + reserved06  + ", reserved07=" + reserved07  + ", reserved08=" + reserved08
			    + ", reserved09=" + reserved09  + ", reserved10=" + reserved10 + "]";
	}
	
}
