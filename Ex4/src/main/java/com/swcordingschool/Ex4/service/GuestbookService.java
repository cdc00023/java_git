package com.swcordingschool.Ex4.service;

import com.swcordingschool.Ex4.dto.GuestbookDTO;
import com.swcordingschool.Ex4.dto.PageRequestDTO;
import com.swcordingschool.Ex4.dto.PageResultDTO;
import com.swcordingschool.Ex4.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
    GuestbookDTO read(Long gno);

    default Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity) {
        GuestbookDTO dto = GuestbookDTO.builder()

                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);
}