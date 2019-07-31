package com.ddup.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;

    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;

    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer count, Integer page, Integer size) {

        this.page = page;

        Integer totalPage;
        if(count % size == 0) {
            totalPage = count/size;
        } else {
            totalPage = count/size+1;
        }

        pages.add(page);
        for (int i=1; i<4; i++) {
            if(page-i > 0){
                pages.add(0,page-i);
            }
            if(page+i <= totalPage){
                pages.add(page+i);
            }
        }

        if(page == 1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }

        if(page == totalPage){
            showNext = false;
        }else {
            showNext = true;
        }

        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        if(pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }
    }
}
