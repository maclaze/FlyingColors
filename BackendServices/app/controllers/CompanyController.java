package controllers;

import play.mvc.Controller;

import com.fasterxml.jackson.databind.JsonNode;


public class CompanyController extends Controller {

	@BodyParser.Of(BodyParser.Json.class)
	public static Result createcontrolType() {		
		JsonNode json = request().body().asJson();
		System.out.println(json);
		if (json==null) {
			return badRequest("Missing json ");
		}
		
		String type = json.findPath("name").textValue();
		if(type == null) {
			return badRequest("Missing parameter [name]");
		} else {
			Company service = Company.create(name);
			return ok(.toString());
		}
	}

	
	}

	
