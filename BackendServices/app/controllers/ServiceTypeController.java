package controllers;
import models.ServiceType;

import com.fasterxml.jackson.databind.JsonNode;
import models.ServiceType;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;

public class ServiceTypeController extends Controller{
	// sample request type: run it from terminal
	//curl -H "Content-Type: application/json" -X POST -d '{"type":"xyz"}' http://localhost:9000/service/create

	@BodyParser.Of(BodyParser.Json.class)
	public static Result createServiceType() {	
		
		JsonNode json = request().body().asJson();
		System.out.println(json);
		if (json==null) {
			return badRequest("Missing json ");
		}
		String type = json.findPath("type").textValue();
		if(type == null) {
			return badRequest("Missing parameter [name]");
		} else {
			ServiceType service = ServiceType.create(type);
			return ok(service.toString());
		}
	}
	
	public static Result getServiceType(Long id) {
		ServiceType serv = ServiceType.find.byId(id);
		return ok(serv.toString());
	}
	
	
}
