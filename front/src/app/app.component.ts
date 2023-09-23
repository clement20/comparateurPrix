import { Component, OnInit } from '@angular/core';
import { Produit } from './modele/produit.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  mesProduits!: Produit[];

  ngOnInit() {
    this.mesProduits = [
      {
        nomProduit: 'Aubergine',
        prixMoyen: 10,
        enseigneMoinsChere:'La Cagette',
        typePrix:'Kg',
        dateMaj: new Date(),
        photo: 'aubergine.jpg'
      }
      ,      
      {
        nomProduit: 'Aubergine2',
        prixMoyen: 10,
        enseigneMoinsChere:'La Cagette',
        typePrix:'Kg',
        dateMaj: new Date(),
        photo: 'aubergine.jpg'
      }
    ]
  }
}
