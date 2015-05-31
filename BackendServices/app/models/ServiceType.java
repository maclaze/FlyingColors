package models;

import javax.persistence.*;

import play.db.ebean.*;

import com.avaje.ebean.*;

@Entity
public class ServiceType extends Model {
	@Id
	Long id;
	String type;
	
	public ServiceType() {
		super();
	}

	public ServiceType(String type) {
		super();
		this.type = type;
	}
	
	public static ServiceType create(String type) {
		ServiceType service = new ServiceType(type);
		service.save();
		return service;
	}
}
