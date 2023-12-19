package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.Entities.Produit;
import com.miniprojet.venteproduit.Repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



@AllArgsConstructor
@Service
public class ServiceProduit implements IServiceProduit {
    private ProduitRepository produitRepository;
    @Override
    public void saveProduit(Produit p, MultipartFile mf) throws IOException {
        if(!mf.isEmpty()){
            p.setPhoto(saveImage(mf));
        }
        produitRepository.save(p);

    }

    private String saveImage(MultipartFile mf) throws IOException {
        String nomPhoto=mf.getOriginalFilename();
        String tab[]=nomPhoto.split("\\.");
        String newName=tab[0]+System.currentTimeMillis()+"."+tab[1];
        File f =new ClassPathResource("static/photos").getFile();
        String chemin =f.getAbsolutePath();
        Path p = Paths.get(chemin,newName);
        Files.write(p,mf.getBytes());
        return newName;
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProductById(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        produitRepository.deleteById(id);

    }
}
