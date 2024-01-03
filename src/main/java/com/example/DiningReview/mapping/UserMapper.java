package com.example.DiningReview.mapping;

import com.example.DiningReview.dto.UserDto;
import com.example.DiningReview.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", ignore = true) // Ignore id during conversion (auto-generated).

    UserDto modelToDto(User user);

    User dtoToModel(UserDto userDto);

    List<UserDto> modelToDtoList(List<User> users);

    List<User> dtoToModelList(List<UserDto> userDtos);
}
