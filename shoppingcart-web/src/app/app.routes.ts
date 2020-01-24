import {NgModule} from '@angular/core'
import {RouterModule, Routes} from '@angular/router'
import {LoginComponent} from './login/login.component'


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  // otherwise redirect to home
  {path: '', redirectTo: 'app', pathMatch: 'full'}
]

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
