package site.lawmate.lawcase.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import site.lawmate.lawcase.board.repository.BoardRepository;
import site.lawmate.lawcase.board.service.BoardServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BoardRouter {
    private final BoardRepository repository;
    private final BoardServiceImpl service;
    public List<?> excute(String q){
        return switch (q){
            case "1" -> repository.findBy법령명한글("대한민국헌법");
            case "2" -> repository.find민사법();
            case "3" -> repository.find형사법();
            case "4" -> repository.find법률();
            default -> null;
        };
    }
}
