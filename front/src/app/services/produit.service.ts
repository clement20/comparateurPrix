import { Injectable } from '@angular/core';
import { Produit } from '../modele/produit.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http:HttpClient) {}

   produits: Produit[] = [
        {
          nomProduit: 'Aubergine',
          prixMoyen: 5.35,
          enseigneMoinsChere:'Carrefour',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'aubergine.jpg'
        }
        ,      
        {
          nomProduit: 'Courgette',
          prixMoyen: 3.61,
          enseigneMoinsChere:'La Cagette',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'courgette.jpg'
        }
        ,      
        {
          nomProduit: 'Oignon jaune',
          prixMoyen: 2.59,
          enseigneMoinsChere:'La Cagette',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'oignon.jpg'
        }
        ,      
        {
          nomProduit: 'Ail',
          prixMoyen: 13.34,
          enseigneMoinsChere:'Auchan',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'ail.jpg'
        }
        ,      
        {
          nomProduit: 'Tomate cerise',
          prixMoyen: 8.96,
          enseigneMoinsChere:'La Cagette',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'tomate.jpg'
        }
        ,      
        {
          nomProduit: 'Carotte',
          prixMoyen: 2.04,
          enseigneMoinsChere:'La Cagette',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'carotte.jpg'
        }
        ,      
        {
          nomProduit: 'Concombre long',
          prixMoyen: 1.79,
          enseigneMoinsChere:'La Cagette',
          typePrix:'Unité',
          dateMaj: new Date(2023,8,19),
          photo: 'concombre.jpg'
        }
        ,      
        {
          nomProduit: 'Patate douce',
          prixMoyen: 5.39,
          enseigneMoinsChere:'La Cagette',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'patate_douce.jpg'
        }
        ,      
        {
          nomProduit: 'Poireau',
          prixMoyen: 4.51,
          enseigneMoinsChere:'La Cagette',
          typePrix:'Kg',
          dateMaj: new Date(2023,8,19),
          photo: 'poireau.jpg'
        }
      ];
      getAllProduits(): Observable<Produit[]> {
        return this.http.get<Produit[]>('http://localhost:8080/produits');
       // return this.produits;
    }
}