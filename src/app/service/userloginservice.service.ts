import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDetail } from '../common/user-detail';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class UserloginserviceService {

  private loginurl = "http://localhost:8080/userdetail/login";
  private userUrl="http://localhost:8080/userdetail/list";
  private newuserurl = "http://localhost:8080/userdetail/saveuser";
  constructor(private http : HttpClient) { }

  getlogin(userdetail: UserDetail): Observable<UserDetail> {
    console.log(userdetail);
    return this.http.post<UserDetail>(`${this.loginurl}`, userdetail);
  }

  getuserbyid(uid: number):Observable<UserDetail>  {
    const uidUrl = this.userUrl + "/" + uid;
    return this.http.get<UserDetail>(uidUrl);
  }


  
  
  updateUser(userdetail: UserDetail): Observable<UserDetail> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.put<UserDetail>(this.userUrl + `/${userdetail.user_id}`, userdetail, httpOptions);
  }

  
  ///user Maintainance

  saveUser(userdetail: UserDetail): Observable<UserDetail> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.post<UserDetail>(this.newuserurl, userdetail, httpOptions);
  }
}
