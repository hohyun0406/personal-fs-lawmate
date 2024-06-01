package site.lawmate.lawcase.board.repository;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.lawmate.lawcase.board.model.QBoard;
import site.lawmate.lawcase.board.model.QBoardDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {
    private final JPAQueryFactory queryFactory;
    private final QBoard board = QBoard.board;
    @Override
    public List<?> find민사법() {
        return queryFactory
                .selectFrom(board)
                .where(board.법령명한글.in("민법", "상법", "민사소송법"))
                .fetch();
    }

    @Override
    public List<?> find형사법() {
        return queryFactory
                .selectFrom(board)
                .where(board.법령명한글.in("형법", "형사소송법"))
                .fetch();
    }

    @Override
    public List<?> find법률() {
        return queryFactory
                .selectFrom(board)
                .where(board.법령구분명.in("법률"))
                .fetch();
    }
}
