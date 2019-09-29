package com.marinaskevin.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marinaskevin.dojooverflow.models.Answer;
import com.marinaskevin.dojooverflow.models.Question;
import com.marinaskevin.dojooverflow.models.Tag;
import com.marinaskevin.dojooverflow.services.AnswerService;
import com.marinaskevin.dojooverflow.services.QuestionService;
import com.marinaskevin.dojooverflow.services.TagService;

@Controller
public class DojoOverflowController {
	public final QuestionService questionService;
	public final AnswerService answerService;
	public final TagService tagService;

	public DojoOverflowController(QuestionService questionService, AnswerService answerService, TagService tagService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}

	@RequestMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "/dojo-overflow/dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "/dojo-overflow/new_question.jsp";
	}
	
	@RequestMapping(value="/questions", method=RequestMethod.POST)
	public String createQuestion(@RequestParam("question") String questionString, @RequestParam("tags") String tagInput) {
		Question question = new Question();
		question.setQuestion(questionString);
		String[] tagString = tagInput.split(",");
		List<Tag> tags = new ArrayList<Tag>();
		for(int i = 0; i<tagString.length; i++)
		{
			String newTag = tagString[i].trim();
			Tag tag = tagService.findTagMatch(newTag);
			if(tag == null) {
				tag = new Tag(newTag);
				tagService.createTag(tag);
			}
			tags.add(tag);
		}
		question.setTags(tags);
		questionService.createQuestion(question);
		return "redirect:/questions/"+question.getId();
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Integer id, Model model) {
		Question question = questionService.findQuestion(id);
		List<Answer> answers = answerService.questionAnswers(id);
		model.addAttribute("question", question);
		model.addAttribute("answers",answers);
		return "/dojo-overflow/show_question.jsp";
	}

	@RequestMapping(value="/answers", method=RequestMethod.POST)
	public String createAnswer(@RequestParam("answer") String answerString, @RequestParam("id") Integer id) {
		Question question = questionService.findQuestion(id);
		Answer answer = new Answer(answerString,question);
		answerService.createAnswer(answer);
		question.getAnswers().add(answer);
		return "redirect:/questions/"+question.getId();
	}
}
