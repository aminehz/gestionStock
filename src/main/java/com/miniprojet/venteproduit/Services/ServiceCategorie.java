package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.DAO.CategorieRepository;
import com.miniprojet.venteproduit.Entities.Categorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategories{
    CategorieRepository categorieRepository;
    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll() ;
    }

    @Override
    public Categorie saveCategorie(Categorie C) {
        categorieRepository.save(C);
        return C;
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie updatedCategorie) {
        Optional<Categorie> existingCategorieOptional=categorieRepository.findById(id);
        if(existingCategorieOptional.isPresent()){
            Categorie existingCategorie=existingCategorieOptional.get();
            existingCategorie.setNom(updatedCategorie.getNom());
            existingCategorie.setDescription(updatedCategorie.getDescription());
            existingCategorie.setNom(updatedCategorie.getNom());
        }
        return updatedCategorie;
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public List<Categorie>getCategoriesById(Long idC) {
        return categorieRepository.getCategorieById(idC);
    }
}
