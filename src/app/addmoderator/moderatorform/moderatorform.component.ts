import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Moderator } from 'src/app/common/moderator';
import { ModeratorserviceService } from 'src/app/service/moderatorservice.service';

@Component({
  selector: 'app-moderatorform',
  templateUrl: './moderatorform.component.html',
  styleUrls: ['./moderatorform.component.css']
})
export class ModeratorformComponent {

  moderator : Moderator = new Moderator(0, "", "", 0, "", new Date(), "", 0);
  isEditable: boolean;

  constructor(private moderatorservice : ModeratorserviceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.moderator);
    this.activateRoute.paramMap.subscribe(()=>this.getModeratorById());
  }

  onSubmit(){
    console.log(this.moderator);
    if(this.isEditable){
      this.moderatorservice.updateModerator(this.moderator).subscribe(data=>
        this.router.navigateByUrl("/moderatorlist"));

    }
    else{
    this.moderatorservice.saveModerator( this.moderator).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/moderatorlist");
  }
}

getModeratorById(){
  const moderatorID  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));
  
console.log(moderatorID);
if(moderatorID> 0)
{
  this.isEditable = true;
  this.moderatorservice.getModeratorByID(moderatorID).subscribe(data=>{
    this.moderator = data;
    console.log(this.moderator)
  });
}

}
}
