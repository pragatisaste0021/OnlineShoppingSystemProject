import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { UserserviceService } from 'src/app/service/userservice.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent {
  user : User = new User(0,"", "", 0, "", new Date(), "", 0, "", 0, 0);
  isEditable: boolean;
  constructor(private userservice : UserserviceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.user);
    this.activateRoute.paramMap.subscribe(()=>this.getUserById());
  }

  onSubmit(){
    console.log(this.user);
    if(this.isEditable){
      this.userservice.updateUser(this.user).subscribe(data=>
        this.router.navigateByUrl("/userlist"));

    }
    else{
    this.userservice.saveUser( this.user).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/userlist");
  }
}
getUserById(){
  const userID  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));
  
console.log(userID);
if(userID> 0)
{
  this.isEditable = true;
  this.userservice.getUserByID(userID).subscribe(data=>{
    this.user = data;
    console.log(this.user)
  });
}

}
}
