import { Injectable } from '@angular/core';
import { Produit } from '../modele/produit.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http:HttpClient) {}
      getAllProduits(): Observable<Produit[]> {
        return this.http.get<Produit[]>('http://localhost:8080/produits');
    }
}