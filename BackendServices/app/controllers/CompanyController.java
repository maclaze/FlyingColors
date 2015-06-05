package controllers;

import play.mvc.Controller;

import com.fasterxml.jackson.databind.JsonNode;


public class CompanyController extends Controller {

	@BodyParser.Of(BodyParser.Json.class)
	public static Result CreateControlType() {	

		JsonNode json = request().body().asJson();
		System.out.println(json);
		if (json==null) {
			return badRequest("Missing json ");
		}
		
		String type = json.findPath("name").textValue();
		if(name == null) {
			return badRequest("Missing parameter [name]");
		} 
		else {
			Company comp = Company.create(name);
			return ok(service.toString());
		}
}
	public static Result getCompanyName(Long id) {
		Company name = Company.find.byId(id); ;
		
		return ok(name.toString());
	}
    }

	
