import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Orderdetail } from '../common/orderdetail';

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {
  private orderUrl = "http://localhost:8080/order/list";
  private saveUrl = "http://localhost:8080/order/save";
  private orderUpdate = "http://localhost:8080/order/update";
  private orderfind="http://localhost:8080/order/find";
  private orderdelete = "http://localhost:8080/order/delete";
  constructor(private http : HttpClient) { }

  getAllOrder():Observable<any>{
    return this.http.get(this.orderUrl);
  }

  saveOrder(order : Orderdetail) : Observable<any>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.http.post<Orderdetail>(this.saveUrl, order, httpOptions);
  }

  getOrderByID(id:number):Observable<Orderdetail>
  {
    const orderIDURl=this.orderfind+"/"+id;
    return  this.http.get<Orderdetail>(orderIDURl);
  }

  deleteOrder(orderID : number){
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<Orderdetail>(this.orderdelete+`/${orderID}`,httpOptions);
  }

  updateOrder(order:Orderdetail):Observable<Orderdetail>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.put<Orderdetail>(this.orderUpdate+`/${order.order_Id}`,order,httpOptions);
  }
}
