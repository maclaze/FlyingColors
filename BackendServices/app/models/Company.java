package models;
import javax.persistence.*;

import play.db.ebean.*;
@Entity
public class Company extends Model {
	@Id
	Long id;
	String name;
	String ceo;
	public static Finder<Long, Company> find =
			new Finder<Long, Company>(Long.class, Company.class);
	
	
	public Company() {
		super();
	}
	
	@Override
	public  String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
	
	public Company(String name) {
		super();
		this.name = name; 
		//this.ceo=ceo;
	}
	
	public static Company create(String name) {
		Company serve = new Company(name);
		serve.save();
		return serve;
	}

}
