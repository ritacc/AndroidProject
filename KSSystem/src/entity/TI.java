package entity;

 
// ,"<br /><br /></p>","",""));
public class TI {
	public int ID;
	
	public int subjectType ;
	//?��ĳ�ݳ���110����/Сʱ���ٶ��ڳ��е�·��ʻ����һ��������׷β���������뱻Ⱥ�����¡���������
	public String IssueSubject ;
	
	public String EIssueSubject ;

	/**
     *  0:�ж���	1: ��ѡ��		2: ��ѡ��
     */
	public String IssueType_ID ;
	//"A,B,D"
	public String Answer ;
	
	/**
	 * <p>A.?��Ƽ�ʻ<br />B.?���ټ�ʻ<br />C.?ƣ�ͼ�ʻ<br /> D.?��������
	 */
	public String IssueResult ;
	
	//��ǩ���
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
