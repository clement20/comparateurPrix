import { Component, OnInit } from '@angular/core';
import { Produit } from './modele/produit.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  mesProduits!: Produit[];

  ngOnInit() {}
  
}
