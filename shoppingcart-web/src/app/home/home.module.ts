import { NgModule, Pipe } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ItemsComponent } from './items/items.component';
import { homeRoutes } from './home.routes';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CartComponent } from './cart/cart.component';
import { TemplateComponent } from './template/template.component';
import { UserFormComponent } from './user-form/user-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductModule } from './product/product.module';
import { BrowserModule } from '@angular/platform-browser';
import { SearchPipe } from '../pipe/search.pipe';
import { PipeModule } from '../pipe/pipe.module';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    ProductModule,
    PipeModule,
    RouterModule.forChild(homeRoutes)
  ],
  providers: [
  ],
  declarations: [
    ItemsComponent,
    CartComponent,
    TemplateComponent,
    HeaderComponent,
    FooterComponent,
    TemplateComponent,
    UserFormComponent
  ]
})
export class HomeModule { }
