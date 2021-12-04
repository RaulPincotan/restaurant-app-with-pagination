package tema7.restaurant.service;

import lombok.Builder;
import lombok.Value;
import tema7.restaurant.domain.model.PageInfo;

import java.util.List;

@Value
@Builder
public class CollectionResponse<T> {
    List<T> content;
    PageInfo pageInfo;
}
