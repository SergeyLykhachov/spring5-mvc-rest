package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CategoryListDTO;
import guru.springfamework.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories/";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //@GetMapping
    //public ResponseEntity<CategoryListDTO> getAllCategories(){

    //    return new ResponseEntity<>(
    //            new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    //}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
    }


    //@GetMapping("{name}")
    //public ResponseEntity<CategoryDTO> getCategoryByName( @PathVariable String name){
    //    return new ResponseEntity<>(
    //            categoryService.getCategoryByName(name), HttpStatus.OK
    //    );
    //}

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
}
