package com.fastProject.fastProect.Vente;

import com.fastProject.fastProect.Achats.Achats;
import com.fastProject.fastProect.Article.Article;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VenteService {

    private  final VenteRepositry venteRepositry;

    public VenteService(VenteRepositry venteRepositry) {
        this.venteRepositry = venteRepositry;
    }

    public void  addVente(){
        Vente vente = new Vente();
    }

    // faire un reçu
    public  void MakeRecu(Vente vente){
        List<Achats> AchatsList =  vente.getAchats();
    }

    public void DeleteVente(Vente vente){
        venteRepositry.delete(vente);
    }

    public Optional<List<Vente>> VenteDurantPeriode(LocalDate dateDebut , LocalDate dateFin ){
        Optional<List<Vente>> venteOptinal   =   venteRepositry.findVenteBetween(dateDebut,dateFin);
        return  venteOptinal;
    }








}
