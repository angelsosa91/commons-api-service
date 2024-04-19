package py.com.solar.commonsapi.models.pagination;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Schema(name = "PageResponse")
public class PageResponse<T> {

    @Schema(description = "Contenido de la página actual")
    private List<T> content;

    @Schema(description = "Número de elementos en la página actual")
    private Integer size;

    @Schema(description = "Número de página actual")
    private Integer page;

    @Schema(description = "Número total de páginas")
    private Integer totalPages;

    @Schema(description = "Número total de elementos")
    private Long totalElements;

    @Schema(description = "Indica si la página actual está vacía")
    private boolean empty;

    @Schema(description = "Indica si la página actual es la primera")
    private boolean first;

    @Schema(description = "Indica si la página actual es la última")
    private boolean last;

}