import { Component, OnInit } from '@angular/core';
import { ProductListServiceService } from 'src/service/product-list-service.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  productList;
  filteredList;
  categoryParam;
  produnctNameParam;
  nameParam;
  isFilter: boolean = false;
  constructor(private productService: ProductListServiceService) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.getProductList();
    }, 500)
    
  }

  getProductList() {

    this.productService.getProducts(this.produnctNameParam, this.categoryParam).subscribe(response => {
      this.productList = response;
      this.filteredList = response;
      console.log("list:::::", this.productList);
    });
  }
  applyCategoryFilter(categoryParam) {
    this.categoryParam = categoryParam;
    this.productService.getProducts(this.produnctNameParam, this.categoryParam).subscribe(response => {
      this.productList = response;
      console.log("list:::::", this.productList);
    });
    console.log("category param list:::::", this.categoryParam)
  }

  nameFilter(searchParam) {
    this.produnctNameParam = searchParam.value;
    this.productService.getProducts(this.produnctNameParam, this.categoryParam).subscribe(response => {
      this.productList = response;
      console.log("list:::::", this.productList);
    });
  }
  
}
