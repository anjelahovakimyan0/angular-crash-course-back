package am.itspace.angularcrashcourseback.mapper;

import am.itspace.angularcrashcourseback.dto.ProductResponseDto;
import am.itspace.angularcrashcourseback.dto.ProductSaveDto;
import am.itspace.angularcrashcourseback.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Page<ProductResponseDto> map(Page<Product> products);

    ProductResponseDto map(Product product);

    Product map(ProductSaveDto productSaveDto);

}
