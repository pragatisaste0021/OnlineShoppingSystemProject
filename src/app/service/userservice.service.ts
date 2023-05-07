import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Orderdetail } from '../common/orderdetail';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  private userUrl = "http://localhost:8080/user/list";
  private saveUrl = "http://localhost:8080/user/save";
  private userUpdate = "http://localhost:8080/user/update";
  private userfind="http://localhost:8080/user/list";
  private userdelete = "http://localhost:8080/user/delete";

  constructor(private http : HttpClient) { }

  getAllUser():Observable<any>{
    return this.http.get(this.userUrl);
  }

  saveUser(user : User) : Observable<any>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.http.post<User>(this.saveUrl, user, httpOptions);
  }

  getUserByID(id:number):Observable<User>
  {
    const userIDURl=this.userfind+"/"+id;
    return  this.http.get<User>(userIDURl);
  }

  deleteUser(userID : number){
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<User>(this.userdelete+`/${userID}`,httpOptions);
  }

  updateUser(user:User):Observable<User>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.put<User>(this.userUpdate+`/${user.user_Id}`,user,httpOptions);
  }

}
