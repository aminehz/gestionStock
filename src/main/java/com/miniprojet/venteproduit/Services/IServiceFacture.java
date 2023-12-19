package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.Entities.Facture;
import com.miniprojet.venteproduit.Entities.Produit;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceFacture {
    public void saveFacture(Facture p);
    public List<Facture> getFacture();
    public Facture getFactureById(Long id);
    public void deleteFacture(Long id);
}
