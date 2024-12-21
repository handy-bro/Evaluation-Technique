package com.handy.evaluation.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(String id, Product productDetails){
        Product product = getProductById(id).orElseThrow(() -> new RuntimeException("user not found"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setAmount(productDetails.getAmount());
        return productRepository.save(product);
    }
}
