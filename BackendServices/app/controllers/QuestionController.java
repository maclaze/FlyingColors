package controllers;

import models.Question;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

public class QuestionController extends Controller {
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result createQuestion() {	

		JsonNode json = request().body().asJson();
		System.out.println(json);
		if (json==null) {
			return badRequest("Missing json ");
		}
		
		String des = json.findPath("des").textValue();   // key: value (in JSON	)
		if(des == null) {
			return badRequest("Missing parameter [description]");
		} 
		else {
			Question que = Question.create(des);
			return ok(que.toString());
		}
}
	public static Result getQuestion(Long id) {
		Question que = Question.find.byId(id);
		return ok(que.toString());
	}
}


