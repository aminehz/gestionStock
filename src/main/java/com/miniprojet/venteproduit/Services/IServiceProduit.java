package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.Entities.Produit;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceProduit {
    public void saveProduit(Produit p, MultipartFile mf) throws IOException;
    public List<Produit> getAllProducts();
    public Produit getProductById(Long id);
    public void deleteProduct(Long id);

}
