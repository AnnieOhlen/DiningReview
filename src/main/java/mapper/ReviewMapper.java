package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.DiningReview.dto.ReviewDto;
import com.example.DiningReview.model.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target = "reviewId", ignore = true) // Ignore reviewId during conversion (auto-generated).
    Review toEntity(ReviewDto reviewDto);

    ReviewDto toDto(Review review);
}