import {  Prix } from "./enseigne.model";

export class Produit {
    constructor(public nom: string,
        public prixMoyen: number,
        public prixMoinsChers: Array<Prix>,
        public prixPlusChers: Array<Prix>,
        public typePrix: string,
        public dateMajReleve: Date,
        public photo: string) {}
    
}