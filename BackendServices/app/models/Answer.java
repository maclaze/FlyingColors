package models;

import javax.persistence.*;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Answer extends Model {
	@Id
	Long id;
	String op1;
	String op2;
	String op3;
	String op4;
	String ans;
	
	
	
	public static Finder<Long, Answer> find =
			new Finder<Long, Answer>(Long.class,Answer.class);

	public Answer() {
		super();
	}
	
	@Override
	public  String toString()
	{
	
	return " [id=" + id + ", answer=" + ans + "]";
	}
	
	
	public Answer(String op1,String op2,String op3,String op4,String ans)
	{	super();
		this.op1=op1;
		this.op2=op2;
		this.op3=op3;
		this.op4=op4;
		this.ans=ans;
	}
	
	public static  Answer create_options(String op1,String op2,String op3,String op4,String ans) 
	{
		Answer opt = new Answer(op1,op2,op3,op4,ans);				
		opt.save();
		return opt;
	}
	

}
