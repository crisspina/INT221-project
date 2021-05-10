package casecoolors.Controllers;

import casecoolors.Exception.ExistImageException;
import casecoolors.Repositories.ProductRepository;
import casecoolors.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

//import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public ImageController imageController;

    private final Path path = Paths.get("image");

    @GetMapping("/stock")
    public List<Product> product() {
        return productRepository.findAll();
    }

    @DeleteMapping("/stock")
    public String deleteAllProduct() {
        productRepository.deleteAll();
        return "delete success";
    }

    @GetMapping("/stock/{id}")
    public Product findById(@PathVariable int id) {
        try{
            return productRepository.findById(id).get();
        }catch(NoSuchElementException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + id + " does not exist."));
        }

    }

    @PostMapping("/stock/add")
    public ResponseEntity<Object> addProductWithPicture(@RequestParam("imageFile")MultipartFile file, @RequestPart Product stock)throws IOException {
        List<Product> stocks = productRepository.findAll();
        Product[] products = new Product[stocks.size()];
        stocks.toArray(products);
        for (Product product : products) {
            if (product.getCasename().equals(stock.getCasename())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product name is already exists"));
            }

            Path file1 = path.resolve(file.getOriginalFilename());
            Resource resource = new UrlResource(file1.toUri());
            File picFile = new File(resource.getURI());
            if (picFile.exists()) {
                throw new ExistImageException(file.getOriginalFilename());
            }
        }
        stock.setImage(imageController.uploadFile(file));
        if(productRepository.lastedProductId() == null){
            stock.setProductid(1);
        }else{
            int newId = productRepository.lastedProductId() + 1;
            stock.setProductid(newId);
        }
        productRepository.save(stock);

        return new ResponseEntity<Object>("The Product Successfully", HttpStatus.OK);
    }

    @PutMapping("/stock/add/{id}")
    public Product editProductWithPicture(@RequestParam("imageFile")MultipartFile file,@RequestPart Product stock,
                                         @PathVariable int id){
        stock.setImage(imageController.uploadFile(file)); 
        stock.setProductid(id);
        return productRepository.save(stock);
    }

    @DeleteMapping("/stock/{id}")
    public String removeProduct(@PathVariable int id) {
        if(!productRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + id + " does not exist."));
        }
        productRepository.deleteById(id);
        return "Product id: " + id + " remove success";
    }

    @PutMapping("/stock/edit/{id}")
    public Product update(@PathVariable int id, @RequestPart Product stock) {
        if(!productRepository.existsById(id) == productRepository.existsById(stock.getProductid())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + stock.getProductid() + " does not exist."));
        }
        stock.setProductid(id);
        productRepository.save(stock);
        return stock;
    }

    @PostMapping("/stock")
    public String addProduct(@RequestBody Product newProduct){
        if(productRepository.existsById(newProduct.getProductid())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + newProduct.getProductid() + " is exist."));
        }

        if(productRepository.lastedProductId() == null){
            newProduct.setProductid(1);
        }else{
            int newId = productRepository.lastedProductId() + 1;
            newProduct.setProductid(newId);
        }
        productRepository.save(newProduct);

        return "Product id: " + newProduct.getProductid() + " add success";
    }
}
