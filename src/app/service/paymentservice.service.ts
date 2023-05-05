import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Payment } from '../common/payment';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class PaymentserviceService {
  private saveUrl = "http://localhost:8080/payment/save";
  constructor(private http: HttpClient) { }

  savePayment(payment : Payment) : Observable<any>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.http.post<Payment>(this.saveUrl, payment, httpOptions);
  }
}
