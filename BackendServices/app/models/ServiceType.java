package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity
public class ServiceType extends Model {
	@Id
	Long id;
	String type;
	public static Finder<Long, ServiceType> find = new Finder<Long, ServiceType>(Long.class, ServiceType.class);
	public ServiceType() {
		super();
	}

	@Override
	public String toString() {
		return "ServiceType [id=" + id + ", type=" + type + "]";
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
