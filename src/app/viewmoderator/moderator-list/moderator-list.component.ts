import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Moderator } from 'src/app/common/moderator';
import { ModeratorserviceService } from 'src/app/service/moderatorservice.service';

@Component({
  selector: 'app-moderator-list',
  templateUrl: './moderator-list.component.html',
  styleUrls: ['./moderator-list.component.css']
})
export class ModeratorListComponent {
  moderator : Moderator[]
  constructor(public route : Router, private service : ModeratorserviceService, activateRoute : ActivatedRoute){
    
  }
  
  ngOnInit() : void{
    this.getAllModerators();
  }

  getAllModerators(){
    this.service.getAllModerator().subscribe(data =>{
      console.log(data);
      this.moderator = data;
    });
  }

  addModerator():void{
    this.route.navigateByUrl('/moderatorform');
  }

  updateModerator(id:number)
  {
    this.route.navigateByUrl("/updateModerator/"+id);
  }

  deleteModerator(id:number):void
  {
    console.log(id);
    if(confirm("Do you want to delete ?")){
      this.service.deleteModerator(id).subscribe(data=>{
        console.log(data);
        this.getAllModerators();
      })
    };
  }

}
