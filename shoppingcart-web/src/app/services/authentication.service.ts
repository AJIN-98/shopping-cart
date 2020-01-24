import {Injectable} from '@angular/core'
import {BehaviorSubject, Observable} from 'rxjs'
import {LoggedUser} from '../model/logged-user'
import {HttpClient} from '@angular/common/http'
import {environment} from 'src/environments/environment'
import {Router} from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private CURRENT_USER = 'currentUser'
  private currentUserSubject: BehaviorSubject<LoggedUser>
  public currentUser: Observable<LoggedUser>

  constructor(private http: HttpClient, private router: Router) {
    this.currentUserSubject = new BehaviorSubject<LoggedUser>(JSON.parse(localStorage.getItem(this.CURRENT_USER)))
    this.currentUser = this.currentUserSubject.asObservable()
  }

  public get currentUserValue(): LoggedUser {
    return this.currentUserSubject.value
  }

  login(username: string, password: string) {
    return this.http.post<LoggedUser>(`${environment.apiUrl}auth/signin`, {'username': username, 'password': password})
      .subscribe(user => {
        localStorage.setItem(this.CURRENT_USER, JSON.stringify(user))
        this.currentUserSubject.next(user)
        this.router.navigate(['/app'])
        return user
      })
  }

  logout() {
    localStorage.clear()
    this.currentUserSubject.next(null)
    this.router.navigate(['/login'])
  }

}
