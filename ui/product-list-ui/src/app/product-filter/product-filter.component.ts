import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ProductListServiceService } from 'src/service/product-list-service.service';

@Component({
  selector: 'app-product-filter',
  templateUrl: './product-filter.component.html',
  styleUrls: ['./product-filter.component.scss']
})
export class ProductFilterComponent implements OnInit {

  showFilterText: boolean = true;
  @Input() productList;
  @Output() filteredList = new EventEmitter();
  categories;
  catArr: any=[];
  constructor(private productService: ProductListServiceService) { }

  ngOnInit(): void {

    
    
  }

  openNav() {
    this.showFilterText = false;
    this.categories = this.productList.map(list => list.category);
    this.categories = [...new Set(this.categories)];
    console.log('categories::::', this.categories);
    document.getElementById("mySidebar").style.width = "200px";
    document.getElementById("main").style.marginLeft = "200px";
  }

  closeNav() {
    this.showFilterText = true;
  //  this.categoryFilter(null);
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";

  }

  categoryFilter(category) {
    console.log("selected category::::", category)
    let index = this.catArr?.indexOf(category);
    console.log("index::::", index);
    if (index > -1) {
      this.catArr?.splice(index, 1);
    } else {
      this.catArr?.push(category);
    }
    let cat = this.catArr?.toString()
    //console.log("category param::::", event);
     
      this.filteredList.emit(cat);
    
    
  }
}
