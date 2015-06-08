package controllers;
import models.Company;

import com.fasterxml.jackson.databind.JsonNode;
import models.ServiceType;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;


public class CompanyController extends Controller {

	@BodyParser.Of(BodyParser.Json.class)
	public static Result CreateControlType() {	

		JsonNode json = request().body().asJson();
		System.out.println(json);
		if (json==null) {
			return badRequest("Missing json ");
		}
		
		String name = json.findPath("name").textValue();
		if(name == null) {
			return badRequest("Missing parameter [name]");
		} 
		else {
			Company comp = Company.create(name);
			return ok(comp.toString());
		}
}
	public static Result getCompanyName(Long id) {
		Company nam = Company.find.byId(id); 
		
		return ok(nam.toString());
	}
    }

	

		
		
		
		 
