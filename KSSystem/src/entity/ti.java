package entity;

import android.R.string;

public class TI {
	public int ID;
	
	public int subjectType ;
	
	public String IssueSubject ;
	
	public String EIssueSubject ;
	
	public String IssueType_ID ;
	
	public String Answer ;
	
	public String IssueResult ;
	
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
}
