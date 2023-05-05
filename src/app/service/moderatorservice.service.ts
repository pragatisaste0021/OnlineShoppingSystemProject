import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Moderator } from '../common/moderator';

@Injectable({
  providedIn: 'root'
})
export class ModeratorserviceService {

  private moderatorUrl = "http://localhost:8080/moderator/list";
  private saveUrl = "http://localhost:8080/moderator/save";
  private moderatorUpdate = "http://localhost:8080/moderator/update";
  private moderatorfind="http://localhost:8080/moderator/find";
  private moderatordelete = "http://localhost:8080/moderator/delete";

  constructor(private http : HttpClient) { }

  getAllModerator():Observable<any>{
    return this.http.get(this.moderatorUrl);
  }

  saveModerator(moderator : Moderator) : Observable<any>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.http.post<Moderator>(this.saveUrl, moderator, httpOptions);
  }

  getModeratorByID(id:number):Observable<Moderator>
  {
    const moderatorIDURl=this.moderatorfind+"/"+id;
    return  this.http.get<Moderator>(moderatorIDURl);
  }

  deleteModerator(moderatorID : number){
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<Moderator>(this.moderatordelete+`/${moderatorID}`,httpOptions);
  }

  updateModerator(moderator:Moderator):Observable<Moderator>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.put<Moderator>(this.moderatorUpdate+`/${moderator.modID}`,moderator,httpOptions);
  }


}
