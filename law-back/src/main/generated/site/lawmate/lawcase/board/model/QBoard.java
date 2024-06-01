package site.lawmate.lawcase.board.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 892853551L;

    public static final QBoard board = new QBoard("board");

    public final StringPath 공포번호 = createString("공포번호");

    public final NumberPath<Integer> 공포일자 = createNumber("공포일자", Integer.class);

    public final NumberPath<Integer> 법령ID = createNumber("법령ID", Integer.class);

    public final StringPath 법령구분명 = createString("법령구분명");

    public final StringPath 법령명한글 = createString("법령명한글");

    public final StringPath 법령상세링크 = createString("법령상세링크");

    public final StringPath 법령약칭명 = createString("법령약칭명");

    public final NumberPath<Integer> 법령일련번호 = createNumber("법령일련번호", Integer.class);

    public final StringPath 소관부처명 = createString("소관부처명");

    public final StringPath 소관부처코드 = createString("소관부처코드");

    public final NumberPath<Integer> 시행일자 = createNumber("시행일자", Integer.class);

    public final StringPath 제개정구분명 = createString("제개정구분명");

    public final StringPath 현행연혁코드 = createString("현행연혁코드");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

