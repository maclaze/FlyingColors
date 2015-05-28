package controllers;

import play.*;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CompanyController extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result sayHello() {
		JsonNode json = request().body().asJson();
		if(json == null) {
			return badRequest("Expecting Json data");
		} else {
			String name = json.findPath("name").textValue();
			if(name == null) {
				return badRequest("Missing parameter [name]");
			} else {
				return ok("Hello " + name);
			}
		}
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result getInfo(Long id) {		
		ObjectNode result = Json.newObject();
		result.put("status", "OK");
		result.put("message", "Information for company id= " + id);
		return ok(result);
	}
}
