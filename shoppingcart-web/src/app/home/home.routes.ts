import { Routes } from '@angular/router';
import { AppComponent } from '../app.component'
import { ItemsComponent } from './items/items.component';
import { CartComponent } from './cart/cart.component';
import { TemplateComponent } from './template/template.component';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';
import { UserFormComponent } from './user-form/user-form.component';
import { AuthGuard } from '../auth/auth.guard';

export const homeRoutes: Routes = [
  {
    path: 'app',
    component: TemplateComponent,
    children: [
      { path: '', redirectTo: '/app/items', pathMatch: 'full' },
      { path: 'home', redirectTo: 'items', pathMatch: 'full', canActivate: [AuthGuard] },
      { path: 'cart', component: CartComponent, canActivate: [AuthGuard] },
      { path: 'items', component: ItemsComponent, canActivate: [AuthGuard] },
      { path: 'user', component: UserFormComponent, canActivate: [AuthGuard] },
      { path: '**', component: PageNotFoundComponent }
    ]
  }
];
