package models;
import javax.persistence.*;

import java.util.List;

import javax.persistence.CascadeType;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
@Entity
public class Question extends Model{
@Id
Long id;
String desc;

@OneToOne(cascade = CascadeType.ALL)
List<Answer> ans;

	public static Finder<Long, Question> find =
			new Finder<Long, Question>(Long.class,Question.class);
	
	public Question() {
		super();
	}

	@Override
	public  String toString()
	{
	
	
	return " [id=" + id + ", que=" + desc + "]";
	}
	
	public Question(String desc)
	{
		this.desc=desc;
		
	}
	
	public static Question create(String desc) 
	{
		Question que = new Question(desc);				
		que.save();
		return que;
	}
}
