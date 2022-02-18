import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductListServiceService {
  private url = "http://localhost:8080";
  constructor(private http: HttpClient) { }


  getProducts(name: string, category: string) {
    if(!name && !category){
      return this.http.get(this.url+"/getProducts");
    }

    if(name && !category){
      return this.http.get(this.url+"/getProducts?productName="+name);
    }

    if(category && !name){
      return this.http.get(this.url+"/getProducts?category="+category);
    }

    if(category && name){
      return this.http.get(this.url+"/getProducts?productName="+name+"&category="+category);
    }
   
  }
  

}
