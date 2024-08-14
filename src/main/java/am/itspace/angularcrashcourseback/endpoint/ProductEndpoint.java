package am.itspace.angularcrashcourseback.endpoint;

import am.itspace.angularcrashcourseback.dto.ProductResponseDto;
import am.itspace.angularcrashcourseback.dto.ProductSaveDto;
import am.itspace.angularcrashcourseback.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "v1/products")
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> findAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable int id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> save(@RequestBody ProductSaveDto productSaveDto) {
        return ResponseEntity.ok(productService.save(productSaveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable int id,
                                                     @RequestBody ProductSaveDto productSaveDto) {
        return ResponseEntity.ok(productService.update(id, productSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
