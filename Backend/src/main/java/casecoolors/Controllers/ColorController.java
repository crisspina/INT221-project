package casecoolors.Controllers;

import casecoolors.Repositories.ColorRepository;
import casecoolors.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ColorController {

    @Autowired
    public ColorRepository colorRepository;

    @GetMapping("/colors")
    public List<Color> product() {
        return colorRepository.findAll();
    }

    @GetMapping("/colors/{id}")
    public Color findById(@PathVariable int id) {
        if(!colorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + id + " does not exist."));
        }
        return colorRepository.findById(id).get();
    }

    @DeleteMapping("/colors/{id}")
    public String removeProduct(@PathVariable int id) {
        if(!colorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + id + " does not exist."));
        }
        colorRepository.deleteById(id);
        return "Product id: " + id + " remove success";
    }

    @PostMapping("/colors")
    public String addProduct(@RequestBody Color newProduct){
        if(colorRepository.existsById(newProduct.getColorId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + newProduct.getColorId() + " is exist."));
        }

        colorRepository.save(newProduct);
        return "Product id: " + newProduct.getColorId() + " add success";
    }

    @PutMapping("/colors/{id}")
    public Color update(@PathVariable int id, @RequestBody Color newEditProduct) {
        if(!colorRepository.existsById(id) == colorRepository.existsById(newEditProduct.getColorId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Product id: " + newEditProduct.getColorId() + " does not exist."));
        }
        newEditProduct.setColorId(id);
        colorRepository.save(newEditProduct);
        return newEditProduct;
    }

}
