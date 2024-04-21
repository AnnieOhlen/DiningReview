package com.example.diningreview.mapping;

import com.example.diningreview.dto.UserDto;
import com.example.diningreview.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",  nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto modelToDto(User user);

    User dtoToModel(UserDto userDto);

    List<UserDto> modelToDtoList(List<User> users);

    List<User> dtoToModelList(List<UserDto> userDtos);
}
