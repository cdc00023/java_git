package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.awt.print.Pageable;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page;
    private int size;
    private String type;
    private String keyword;
    private ProcessHandle PageRequest;

    public PageRequestDTO(){
        this.page = 1;
        this.size = 10;
    }
    public Pageable getPageable(SpringDataWebProperties.Sort sort){
        return PageRequest.of(page -1, size, sort);
    }

}
