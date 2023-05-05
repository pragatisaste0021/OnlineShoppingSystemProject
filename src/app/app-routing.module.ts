import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderListComponent } from './vieworder/order-list/order-list.component';
import { OrderformComponent } from './addorder/orderform/orderform.component';
import { UserListComponent } from './viewuser/user-list/user-list.component';
import { UserformComponent } from './adduser/userform/userform.component';
import { WelcomeComponent } from './adminhome/welcome/welcome.component';
import { ModeratorformComponent } from './addmoderator/moderatorform/moderatorform.component';
import { ModeratorListComponent } from './viewmoderator/moderator-list/moderator-list.component';
import { ProductformComponent } from './addproduct/productform/productform.component';
import { Product } from './common/product';
import { ProductListComponent } from './viewproduct/product-list/product-list.component';
import { AdminloginComponent } from './adminLogin/adminlogin/adminlogin.component';
import { ModeratorloginComponent } from './moderatorLogin/moderatorlogin/moderatorlogin.component';
import { ModeratorwelcomeComponent } from './moderatorhome/moderatorwelcome/moderatorwelcome.component';
import { UserproductformComponent } from './adduserproduct/userproductform/userproductform.component';
import { PaymentformComponent } from './addpayment/paymentform/paymentform.component';
import { UserwelcomeComponent } from './userhome/userwelcome/userwelcome.component';
import { UserloginComponent } from './userlogin/userlogin/userlogin.component';
import { UserproductlistComponent } from './viewuserproduct/userproductlist/userproductlist.component';
import { RegistrationformComponent } from './userregister/registrationform/registrationform.component';

const routes: Routes = [{path : 'orderlist', component : OrderListComponent}, {path : 'orderform', component : OrderformComponent},{path:'updateOrder/:id',component:OrderformComponent},
{path : 'userlist', component : UserListComponent}, {path : 'userform', component : UserformComponent}, {path : 'updateUser/:id', component : UserformComponent},
{path : 'welcome', component : WelcomeComponent}, {path : 'moderatorform', component : ModeratorformComponent}, {path : 'updateModerator/:id', component : ModeratorformComponent},
{path : 'moderatorlist', component : ModeratorListComponent}, {path : 'productform', component : ProductformComponent}, 
{path : 'updateProduct/:id', component : ProductformComponent}, {path : 'productlist', component : ProductListComponent},
{path : 'adminlogin', component : AdminloginComponent}, {path : 'moderatorlogin', component : ModeratorloginComponent},
{path : 'moderatorwelcome', component : ModeratorwelcomeComponent}, {path : 'adduserproduct', component : UserproductformComponent},
{path : 'payment', component : PaymentformComponent}, {path : 'userlogin', component : UserloginComponent},
{path : 'userwelcome', component : UserwelcomeComponent}, {path : 'userproductlist', component : UserproductlistComponent},
{path : 'register', component : RegistrationformComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
