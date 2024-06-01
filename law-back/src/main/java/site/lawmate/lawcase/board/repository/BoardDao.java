package site.lawmate.lawcase.board.repository;

import site.lawmate.lawcase.board.model.BoardDto;

import java.util.List;

public interface BoardDao {
    List<?> find민사법();
    List<?> find형사법();
    List<?> find법률();

}
