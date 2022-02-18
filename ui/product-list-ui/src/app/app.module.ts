import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from  '@angular/common/http';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductFilterComponent } from './product-filter/product-filter.component';
import { ProductListServiceService } from 'src/service/product-list-service.service';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductFilterComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ProductListServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
