package com.paypal.payments.mapper;

import com.paypal.payments.dto.UserDto;
import com.paypal.payments.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {
    Mapper MAPPER = Mappers.getMapper(Mapper.class);

    User mapDtoToUser(UserDto userDto);

    UserDto mapUserToDto(User user);
}
