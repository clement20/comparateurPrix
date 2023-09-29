import { Component, OnInit } from '@angular/core';
import { Produit } from '../modele/produit.model';
import { ProduitService } from '../services/produit.service';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-liste-produits',
  templateUrl: './liste-produits.component.html',
  styleUrls: ['./liste-produits.component.scss']
})
export class ListeProduitsComponent implements OnInit{
  constructor(private produitService: ProduitService) { }
  produits$!: Observable<Produit[]>;
  ngOnInit(): void {
    //this.produits = this.produitService.getAllProduits();
    this.produits$=this.produitService.getAllProduits();
  }
}
