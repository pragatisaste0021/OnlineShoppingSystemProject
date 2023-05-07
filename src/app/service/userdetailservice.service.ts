import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserdetailserviceService {


  private loginurl = "http://localhost:8080/controll/login";
  private userUrl="http://localhost:8080/controll/list";
  private newuserurl = "http://localhost:8080/controll/saveuser";
  constructor() { }
}
