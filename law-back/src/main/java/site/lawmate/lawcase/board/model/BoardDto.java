package site.lawmate.lawcase.board.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
@Data
@Builder
@Getter
@Setter
public class BoardDto {
    private Integer 법령일련번호;
    private String 현행연혁코드;
    private String 법령명한글;
    private String 법령약칭명;
    private Integer 법령ID;
    private Integer 공포일자;
    private String 공포번호;
    private String 제개정구분명;
    private String 소관부처코드;
    private String 소관부처명;
    private String 법령구분명;
    private Integer 시행일자;
    private String 법령상세링크;

    @QueryProjection
    public BoardDto(Integer 법령일련번호, String 현행연혁코드, String 법령명한글, String 법령약칭명, Integer 법령ID, Integer 공포일자, String 공포번호, String 제개정구분명, String 소관부처코드, String 소관부처명, String 법령구분명, Integer 시행일자, String 법령상세링크) {
        this.법령일련번호 = 법령일련번호;
        this.현행연혁코드 = 현행연혁코드;
        this.법령명한글 = 법령명한글;
        this.법령약칭명 = 법령약칭명;
        this.법령ID = 법령ID;
        this.공포일자 = 공포일자;
        this.공포번호 = 공포번호;
        this.제개정구분명 = 제개정구분명;
        this.소관부처코드 = 소관부처코드;
        this.소관부처명 = 소관부처명;
        this.법령구분명 = 법령구분명;
        this.시행일자 = 시행일자;
        this.법령상세링크 = 법령상세링크;
    }
}
