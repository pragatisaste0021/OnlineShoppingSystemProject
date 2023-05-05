import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  private productUrl = "http://localhost:8080/product/list";
  private saveUrl = "http://localhost:8080/product/save";
  private productUpdate = "http://localhost:8080/product/update";
  private productfind="http://localhost:8080/product/find";
  private productdelete = "http://localhost:8080/product/delete";

  constructor(private http : HttpClient) { }

  getAllProduct():Observable<any>{
    return this.http.get(this.productUrl);
  }

  saveProduct(product : Product) : Observable<any>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.http.post<Product>(this.saveUrl, product, httpOptions);
  }

  getProductByID(id:number):Observable<Product>
  {
    const productIDURl=this.productfind+"/"+id;
    return  this.http.get<Product>(productIDURl);
  }

  deleteProduct(productID : number){
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<Product>(this.productdelete+`/${productID}`,httpOptions);
  }

  updateUser(product:Product):Observable<Product>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.put<Product>(this.productUpdate+`/${product.pdt_Id}`,product,httpOptions);
  }


}
