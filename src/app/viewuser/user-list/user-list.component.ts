import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { UserserviceService } from 'src/app/service/userservice.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {

  user : User[]
  constructor(public route : Router, private service : UserserviceService, activateRoute : ActivatedRoute){
    
  }
  ngOnInit() : void{
    this.getAllUsers();
  }

  getAllUsers(){
    this.service.getAllUser().subscribe(data =>{
      console.log(data);
      this.user = data;
    });
  }

  addUser():void{
    this.route.navigateByUrl('/userform');
  }

  updateUser(id:number)
  {
    this.route.navigateByUrl("/updateUser/"+id);
  }

  deleteUser(id:number):void
  {
    console.log(id);
    if(confirm("Do you want to delete ?")){
      this.service.deleteUser(id).subscribe(data=>{
        console.log(data);
        this.getAllUsers();
      })
    };
  }
}
