import { Component, Input, OnInit } from '@angular/core';
import { Produit } from '../modele/produit.model';

@Component({
  selector: 'app-vue-produit',
  templateUrl: './vue-produit.component.html',
  styleUrls: ['./vue-produit.component.scss']
})
export class VueProduitComponent implements OnInit {
   @Input() produit!: Produit;

  ngOnInit(): void {
   
  }
}
