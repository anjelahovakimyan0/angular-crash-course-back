package am.itspace.angularcrashcourseback.repository;

import am.itspace.angularcrashcourseback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
