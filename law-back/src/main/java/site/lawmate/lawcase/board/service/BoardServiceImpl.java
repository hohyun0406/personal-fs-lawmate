package site.lawmate.lawcase.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import site.lawmate.lawcase.board.model.BoardDto;
import site.lawmate.lawcase.board.repository.BoardRepository;
import site.lawmate.lawcase.common.component.Messenger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final BoardRepository repository;

    public List<BoardDto> findAll() {
        return repository.findAll().stream().map(i->entityToDto(i)).collect(Collectors.toList());
    }


}
