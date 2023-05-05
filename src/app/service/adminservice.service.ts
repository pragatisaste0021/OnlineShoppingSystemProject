import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  administratorURL: string="http://localhost:8080/admin1/list";


  constructor(private http:HttpClient) { }

  getAllAdmin():Observable<any>{
    return this.http.get(this.administratorURL);
  }
}
