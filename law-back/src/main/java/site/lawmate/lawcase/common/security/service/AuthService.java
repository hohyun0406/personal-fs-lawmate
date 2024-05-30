package site.lawmate.lawcase.common.security.service;

import site.lawmate.lawcase.common.component.Messenger;
import site.lawmate.lawcase.user.model.UserDto;

public interface AuthService {
    Messenger login(UserDto userDto);
    String createToken(UserDto userDto);
}


