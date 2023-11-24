package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.Entities.Categorie;

import java.util.List;

public interface IServiceCategories {
    public List<Categorie> getAllCategories();
    public Categorie saveCategorie(Categorie C) ;
    public Categorie updateCategorie(Long id, Categorie updatedCategorie);
    public void deleteCategorie(Long id);
    public List<Categorie> getCategoriesById(Long idC);

}
