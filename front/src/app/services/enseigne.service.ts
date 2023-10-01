import { Injectable } from '@angular/core';
import { Produit } from '../modele/produit.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Enseigne } from '../modele/enseigne.model';

@Injectable({
  providedIn: 'root'
})
export class EnseigneService {
  constructor(private http:HttpClient) {}
      getAllEnseignes(): Observable<Enseigne[]> {
        return this.http.get<Enseigne[]>('http://localhost:8080/enseignes');
    }
}