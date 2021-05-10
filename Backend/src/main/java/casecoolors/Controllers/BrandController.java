package casecoolors.Controllers;

import casecoolors.Repositories.BrandRepository;
import casecoolors.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BrandController {
    @Autowired
    public BrandRepository brandRepository;

    @GetMapping("/brand")
    public List<Brand> brand() {
        return brandRepository.findAll();
    }

    @GetMapping("/brand/{id}")
    public Brand findById(@PathVariable int id) {
        if(!brandRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Brand id: " + id + " does not exist."));
        }
        return brandRepository.findById(id).get();
    }

    @DeleteMapping("/brand/{id}")
    public String removeBrand(@PathVariable int id) {
        if(!brandRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Brand id: " + id + " does not exist."));
        }
        brandRepository.deleteById(id);
        return "Product id: " + id + " remove success";
    }

    @PostMapping("/brand")
    public String addBrand(@RequestBody Brand newBrand){
        if(brandRepository.existsById(newBrand.getBrandid())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Brand id: " + newBrand.getBrandid() + " is exist."));
        }
        brandRepository.save(newBrand);
        return "Brand id: " + newBrand.getBrandid() + " add success";
    }

    @PutMapping("/brand/{id}")
    public Brand update(@PathVariable int id, @RequestBody Brand newEditBrand) {
        if(!brandRepository.existsById(id) == brandRepository.existsById(newEditBrand.getBrandid())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Brand id: " + newEditBrand.getBrandid() + " does not exist."));
        }
        newEditBrand.setBrandid(id);
        brandRepository.save(newEditBrand);
        return newEditBrand;
    }
}
