import {Injectable} from '@angular/core'
import {Observable, of} from 'rxjs'
import {catchError} from 'rxjs/operators'
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest,} from '@angular/common/http'
import {ToastrService} from '../services/toastr.service'
import {AuthenticationService} from '../services/authentication.service'

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private service: AuthenticationService,
              private toastr: ToastrService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let currentUser = this.service.currentUserValue
    if (currentUser && currentUser.token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${currentUser.token}`
        }
      })
    }

    return next.handle(request).pipe(
      catchError((error: any) => {
        this.toastr.error(error.error.message)
        return of(error)
      })
    )

  }
}
