import {NgModule} from '@angular/core'
import {CommonModule} from '@angular/common'
import {ProductListComponent} from './product-list/product-list.component'
import {ProductFormComponent} from './product-form/product-form.component'
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import {RouterModule} from '@angular/router'
import {productRoutes} from './product.routes'
import {NgxCurrencyModule} from 'ngx-currency'
import {PipeModule} from 'src/app/pipe/pipe.module'

@NgModule({
  declarations: [ProductListComponent, ProductFormComponent],
    imports: [
        CommonModule,
        FormsModule,
        NgxCurrencyModule,
        PipeModule,
        RouterModule.forChild(productRoutes),
        ReactiveFormsModule
    ]
})
export class ProductModule {
}
