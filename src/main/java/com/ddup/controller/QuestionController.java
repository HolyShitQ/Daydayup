package com.ddup.controller;

import com.ddup.Enums.CommentTypeEnum;
import com.ddup.dto.CommentDTO;
import com.ddup.dto.QuestionDTO;
import com.ddup.service.CommentService;
import com.ddup.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model){

        //获取评论
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);

        //增加阅读数
        questionService.incView(id);
        QuestionDTO questionDTO = questionService.getById(id);

        //查询相关问题
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);

        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
