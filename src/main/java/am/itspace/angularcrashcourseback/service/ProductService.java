package am.itspace.angularcrashcourseback.service;

import am.itspace.angularcrashcourseback.dto.ProductResponseDto;
import am.itspace.angularcrashcourseback.dto.ProductSaveDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<ProductResponseDto> findAll(Pageable pageable);

    ProductResponseDto findById(int id);

    ProductResponseDto save(ProductSaveDto productSaveDto);

    ProductResponseDto update(int id, ProductSaveDto productSaveDto);

    void deleteById(int id);

}
