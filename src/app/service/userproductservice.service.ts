import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { UserProduct } from '../common/user-product';

@Injectable({
  providedIn: 'root'
})
export class UserproductserviceService {

  private userproductUrl = "http://localhost:8080/userproduct/list";
  private saveUrl = "http://localhost:8080/userproduct/save";
  private userproductUpdate = "http://localhost:8080/userproduct/update";
  private userproductfind="http://localhost:8080/userproduct/find";
  private userproductdelete = "http://localhost:8080/userproduct/delete";

  constructor(private http : HttpClient) { }

  getAllUserProduct():Observable<any>{
    return this.http.get(this.userproductUrl);
  }

  saveUserProduct(userproduct : UserProduct) : Observable<any>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.http.post<UserProduct>(this.saveUrl, userproduct, httpOptions);
  }

  getUserProductByID(id:number):Observable<UserProduct>
  {
    const productIDURl=this.userproductfind+"/"+id;
    return  this.http.get<UserProduct>(productIDURl);
  }

  deleteUserProduct(productID : number){
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<UserProduct>(this.userproductdelete+`/${productID}`,httpOptions);
  }

  updateUser(userproduct:UserProduct):Observable<UserProduct>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.put<UserProduct>(this.userproductUpdate+`/${userproduct.userpdt_Id}`,userproduct,httpOptions);
  }


}
