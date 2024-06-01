package site.lawmate.lawcase.board.service;

import site.lawmate.lawcase.board.model.Board;
import site.lawmate.lawcase.board.model.BoardDto;


public interface BoardService  {
    default Board dtoToEntity(BoardDto dto) {
        return Board.builder()
                .법령일련번호(dto.get법령일련번호())
                .현행연혁코드(dto.get현행연혁코드())
                .법령명한글(dto.get법령명한글())
                .법령약칭명(dto.get법령약칭명())
                .법령ID(dto.get법령ID())
                .공포일자(dto.get공포일자())
                .공포번호(dto.get공포번호())
                .제개정구분명(dto.get제개정구분명())
                .소관부처코드(dto.get소관부처코드())
                .소관부처명(dto.get소관부처명())
                .법령구분명(dto.get법령구분명())
                .시행일자(dto.get시행일자())
                .법령상세링크(dto.get법령상세링크())
                .build();
    }

    default BoardDto entityToDto(Board board) {
        return BoardDto.builder()
                .법령일련번호(board.get법령일련번호())
                .현행연혁코드(board.get현행연혁코드())
                .법령명한글(board.get법령명한글())
                .법령약칭명(board.get법령약칭명())
                .법령ID(board.get법령ID())
                .공포일자(board.get공포일자())
                .공포번호(board.get공포번호())
                .제개정구분명(board.get제개정구분명())
                .소관부처코드(board.get소관부처코드())
                .소관부처명(board.get소관부처명())
                .법령구분명(board.get법령구분명())
                .시행일자(board.get시행일자())
                .법령상세링크(board.get법령상세링크())
                .build();
    }
}
