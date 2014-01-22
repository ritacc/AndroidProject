package DB;

public class DBBase {
	
	public  SqlHelper db=null;
	public DBBase()
	{	
		//CursorFactory factory=null;
		int version=1;
		final	String DBName="ritacc.db";
		db=new SqlHelper(null,DBName,null,version);	
	}
}
