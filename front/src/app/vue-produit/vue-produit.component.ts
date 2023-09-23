import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vue-produit',
  templateUrl: './vue-produit.component.html',
  styleUrls: ['./vue-produit.component.scss']
})
export class VueProduitComponent implements OnInit {
  nomProduit!: string;
  prixMoyen!: number;
  enseigneMoinsChere!: string;
  typePrix!: string;
  dateMaj!: Date;
  photo!: string;

  ngOnInit(): void {
    this.nomProduit='Aubergine';
    this.prixMoyen=10;
    this.enseigneMoinsChere='La cagette';
    this.typePrix='Kg';
    this.photo = 'aubergine.jpg'
    this.dateMaj=new Date();
  }
}
