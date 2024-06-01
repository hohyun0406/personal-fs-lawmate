package site.lawmate.lawcase.board.model;

import jakarta.persistence.*;
import lombok.*;


@Entity(name="boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Board {
    private Integer 법령일련번호;
    private String 현행연혁코드;
    private String 법령명한글;
    private String 법령약칭명;
    @Id
    private Integer 법령ID;
    private Integer 공포일자;
    private String 공포번호;
    private String 제개정구분명;
    private String 소관부처코드;
    private String 소관부처명;
    private String 법령구분명;
    private Integer 시행일자;
    private String 법령상세링크;

}
