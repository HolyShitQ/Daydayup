package com.ddup.service;

import com.ddup.dto.PaginationDTO;
import com.ddup.dto.QuestionDTO;
import com.ddup.mapper.QuestionMapper;
import com.ddup.mapper.UserMapper;
import com.ddup.model.Question;
import com.ddup.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {
        Integer offset = size * (page-1);
        List<Question> questions = questionMapper.list(offset, size);
        ArrayList<QuestionDTO> questionDTOs = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOs.add(questionDTO);
        }

        Integer count = questionMapper.count();
        paginationDTO.setPagination(count, page, size);

        paginationDTO.setQuestions(questionDTOs);

        return paginationDTO;
    }
}
