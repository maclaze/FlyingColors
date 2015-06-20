package controllers;
import models.Answer;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;



public class AnswerController extends Controller {
	@BodyParser.Of(BodyParser.Json.class)
	public static Result createAnswer() {	

		JsonNode json = request().body().asJson();
		System.out.println(json);
		if (json==null) {
			return badRequest("Missing json ");
		}
		
		String op1 = json.findPath("op1").textValue();
		String op2 = json.findPath("op2").textValue();
		String op3 = json.findPath("op3").textValue();
		String op4 = json.findPath("op4").textValue();
		String answ = json.findPath("answ").textValue();
		
		if(op1 == null || op2 == null || op3 == null || op4 == null || answ==null) {
			return badRequest("Missing parameter [option]");
		} 
		else {
			Answer ans = Answer.create_options(op1,op2,op3,op4,answ);
			return ok(ans.toString());
		}
}
	public static Result getAnswer(Long id) {
		Answer ans = Answer.find.byId(id);
		return ok(ans.toString());
	}
}
