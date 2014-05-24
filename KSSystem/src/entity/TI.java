package entity;

 
// ,"<br /><br /></p>","",""));
public class TI {
	public int ID;
	
	public int subjectType ;
	//?林某驾车以110公里/小时的速度在城市道路行驶，与一辆机动车追尾后弃车逃离被群众拦下。经鉴定，
	public String IssueSubject ;
	
	public String EIssueSubject ;

	/**
     *  0:判断题	1: 单选题		2: 多选择
     */
	public String IssueType_ID ;
	//"A,B,D"
	public String Answer ;
	
	/**
	 * <p>A.?醉酒驾驶<br />B.?超速驾驶<br />C.?疲劳驾驶<br /> D.?肇事逃逸
	 */
	public String IssueResult ;
	
	//回签结果
	public String EIssueResult ;
	
	public String ImagePath ;
	
	public TI(int _ID,int _subjectType,String _IssueSubject,String _EIssueSubject,String _IssueType_ID,		
			String _Answer,String _IssueResult,String _EIssueResult,String _ImagePath)
	{
		ID=_ID;
		subjectType=_subjectType;
		IssueSubject=_IssueSubject;
		EIssueSubject=_EIssueSubject;
		IssueType_ID=_IssueType_ID;
		Answer=_Answer;
		IssueResult=_IssueResult;
		EIssueResult=_EIssueResult;
		ImagePath=_ImagePath;
	}
	public TI()
	{
		
	}
}
