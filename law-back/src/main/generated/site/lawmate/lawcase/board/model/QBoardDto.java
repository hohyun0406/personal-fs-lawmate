package site.lawmate.lawcase.board.model;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * site.lawmate.lawcase.board.model.QBoardDto is a Querydsl Projection type for BoardDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardDto extends ConstructorExpression<BoardDto> {

    private static final long serialVersionUID = 267742768L;

    public QBoardDto(com.querydsl.core.types.Expression<Integer> 법령일련번호, com.querydsl.core.types.Expression<String> 현행연혁코드, com.querydsl.core.types.Expression<String> 법령명한글, com.querydsl.core.types.Expression<String> 법령약칭명, com.querydsl.core.types.Expression<Integer> 법령ID, com.querydsl.core.types.Expression<Integer> 공포일자, com.querydsl.core.types.Expression<String> 공포번호, com.querydsl.core.types.Expression<String> 제개정구분명, com.querydsl.core.types.Expression<String> 소관부처코드, com.querydsl.core.types.Expression<String> 소관부처명, com.querydsl.core.types.Expression<String> 법령구분명, com.querydsl.core.types.Expression<Integer> 시행일자, com.querydsl.core.types.Expression<String> 법령상세링크) {
        super(BoardDto.class, new Class<?>[]{int.class, String.class, String.class, String.class, int.class, int.class, String.class, String.class, String.class, String.class, String.class, int.class, String.class}, 법령일련번호, 현행연혁코드, 법령명한글, 법령약칭명, 법령ID, 공포일자, 공포번호, 제개정구분명, 소관부처코드, 소관부처명, 법령구분명, 시행일자, 법령상세링크);
    }

}

