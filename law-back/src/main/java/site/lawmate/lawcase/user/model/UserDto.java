package site.lawmate.lawcase.user.model;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
@Data
@Builder
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String token;
}
