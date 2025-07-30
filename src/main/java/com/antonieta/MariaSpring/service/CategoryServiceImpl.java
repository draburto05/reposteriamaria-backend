package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.module.Category;
import com.antonieta.MariaSpring.repository.CategoryRepository;
import com.antonieta.MariaSpring.repository.ClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }



    @Override
    public List<Category> getAllCategory() {
      return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("La categoria con el id " + id+ " no existe")

        );
    }

    @Override
    public Category deleteCategoryById(Long id) {
        Category tmp = null;
        //Usamos early return para evaluar si no existe el prodcuto
        //en caso de que no existe, terminamos la ejecucion de la funcion
        //en ese momennto
        if(!categoryRepository.existsById(id))return tmp;
        //si el producto existe, guardamos el producto en la variable temporal
        tmp= categoryRepository.findById(id).get();
        //eliminamos el producto
        categoryRepository.deleteById(id);
        //retornamos el producto eliminado
        return tmp;
    }

    @Override
    public Category addCategoryById(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category UpdateCategoryById(Long id, Category categoryUpdate) {


        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isEmpty())throw
                new IllegalArgumentException("El producto con el id " + id+ " no existe");
        Category originalcategory = optionalCategory.get();
        //Evaluar el producto que hara cambio evaluando propiedades y solo donde no esten vacias se aplican cambios
        if(categoryUpdate.getName() !=null) originalcategory.setName(categoryUpdate.getName());
        if(categoryUpdate.getDescription() !=null) originalcategory.setDescription(categoryUpdate.getDescription());

        return categoryRepository.save(originalcategory);

    }
}
