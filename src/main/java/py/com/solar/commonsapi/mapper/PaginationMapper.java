package py.com.solar.commonsapi.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import py.com.solar.commonsapi.models.pagination.PageResponse;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface PaginationMapper<T> {

    default PageResponse<T> toPageResponse(Page<T> page) {
        if (Objects.isNull(page)) {
            return null;
        }

        return new PageResponse<T>(page.getContent(),
                page.getPageable().getPageSize(),
                page.getPageable().getPageNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.isEmpty(), page.isFirst(), page.isLast());
    }

}