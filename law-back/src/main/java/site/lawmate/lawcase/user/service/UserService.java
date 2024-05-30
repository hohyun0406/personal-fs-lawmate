package site.lawmate.lawcase.user.service;

import site.lawmate.lawcase.common.component.Messenger;
import site.lawmate.lawcase.common.service.CommandService;
import site.lawmate.lawcase.common.service.QueryService;
import site.lawmate.lawcase.user.model.User;
import site.lawmate.lawcase.user.model.UserDto;

public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    default User dtoToEntity(UserDto dto){
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .name(dto.getName())
                .phone(dto.getPhone())
                .build();
    }
    default UserDto entityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .build();
    }

    Messenger login(UserDto userDto);
}
