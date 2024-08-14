package am.itspace.angularcrashcourseback.service.impl;

import am.itspace.angularcrashcourseback.dto.ProductResponseDto;
import am.itspace.angularcrashcourseback.dto.ProductSaveDto;
import am.itspace.angularcrashcourseback.entity.Product;
import am.itspace.angularcrashcourseback.mapper.ProductMapper;
import am.itspace.angularcrashcourseback.repository.ProductRepository;
import am.itspace.angularcrashcourseback.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponseDto> findAll(Pageable pageable) {
        return productMapper.map(productRepository.findAll(pageable));
    }

    @Override
    public ProductResponseDto findById(int id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product does not exists!");
        }
        return productMapper.map(productRepository.findById(id).get());
    }

    @Override
    public ProductResponseDto save(ProductSaveDto productSaveDto) {
        return productMapper.map(productRepository.save(productMapper.map(productSaveDto)));
    }

    @Override
    public ProductResponseDto update(int id, ProductSaveDto productSaveDto) {
        Product product = productMapper.map(productSaveDto);
        product.setId(id);

        return productMapper.map(productRepository.save(product));
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
