import { Routes } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { PageNotFoundComponent } from 'src/app/page-not-found/page-not-found.component';
import { TemplateComponent } from '../template/template.component';
import { AuthGuard } from 'src/app/auth/auth.guard';

export const productRoutes: Routes = [
    {
        path: 'app/products',
        component: TemplateComponent,
        children: [
            { path: '', redirectTo: 'list', pathMatch: 'full' },
            { path: 'list', component: ProductListComponent, canActivate: [AuthGuard] },
            { path: 'form', component: ProductFormComponent, canActivate: [AuthGuard] },
            { path: 'form/:id', component: ProductFormComponent, canActivate: [AuthGuard] },
            { path: '**', component: PageNotFoundComponent, canActivate: [AuthGuard] }
        ]
    }
]