package py.com.solar.commonsapi.models.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PageResponse<T> {

    private List<T> content;
    private Integer size;
    private Integer page;
    private Integer totalPages;
    private Long totalElements;
    private boolean empty;
    private boolean first;
    private boolean last;

}