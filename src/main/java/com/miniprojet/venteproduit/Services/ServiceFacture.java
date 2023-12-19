package com.miniprojet.venteproduit.Services;

import com.miniprojet.venteproduit.Entities.Facture;
import com.miniprojet.venteproduit.Repository.FactureRepositroy;
import com.miniprojet.venteproduit.Repository.ProduitRepository;

import java.util.List;

public class ServiceFacture implements IServiceFacture{
    private FactureRepositroy factureRepositroy;
    @Override
    public void saveFacture(Facture p) {
        factureRepositroy.save(p);
    }

    @Override
    public List<Facture> getFacture() {
        return factureRepositroy.findAll();
    }

    @Override
    public Facture getFactureById(Long id) {
        return factureRepositroy.findById(id).orElse(null);
    }

    @Override
    public void deleteFacture(Long id) {
        factureRepositroy.deleteById(id);
    }
}
