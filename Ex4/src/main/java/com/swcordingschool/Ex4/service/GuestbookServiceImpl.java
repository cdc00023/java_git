package com.swcordingschool.Ex4.service;

import com.swcordingschool.Ex4.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.swcordingschool.Ex4.dto.GuestbookDTO;
import com.swcordingschool.Ex4.dto.PageRequestDTO;
import com.swcordingschool.Ex4.dto.PageResultDTO;
import com.swcordingschool.Ex4.entity.Guestbook;
import com.swcordingschool.Ex4.repository.GuestbookRepository;


import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);
        Guestbook entity = dtoToEntity(dto);
        log.info(entity);

        repository.save(entity);

        return null;
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
        Page<Guestbook> result = repository.findAll(pageable);
        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }
    @Override
    public GuestbookDTO read(Long gno) {
        Optional<Guestbook> result = repository.findById(gno);
        return result.isPresent()? entityToDto(result.get()): null;
    }

}