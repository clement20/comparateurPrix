import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { VueProduitComponent } from './vue-produit/vue-produit.component';
import { ListeProduitsComponent } from './liste-produits/liste-produits.component';
import { HeaderComponent } from './header/header.component';
import { AppRoutingModule } from './app-routing.module';

import { MatGridListModule } from '@angular/material/grid-list';
import { ListeEnseignesComponent } from './liste-enseignes/liste-enseignes.component';
import { VueEnseigneComponent } from './vue-enseigne/vue-enseigne.component';

@NgModule({
  declarations: [
    AppComponent,
    VueProduitComponent,
    ListeProduitsComponent,
    HeaderComponent,
    ListeEnseignesComponent,
    VueEnseigneComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,MatGridListModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
