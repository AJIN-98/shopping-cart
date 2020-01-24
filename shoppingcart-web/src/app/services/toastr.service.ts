import {Injectable} from '@angular/core'
import {ToastrService as NgxToastr} from 'ngx-toastr'

@Injectable({
  providedIn: 'root'
})
export class ToastrService {

  constructor(private toastr: NgxToastr) { }

  configuration = {
    positionClass: 'toast-bottom-full-width',
    progressBar: true,
    timeOut: 2000,
    extendedTimeOut: 500,
    onActivateTick: true,
    enableHtml: false,
    easing: 'ease-in-out'
  }

  error(errorMessage: string, errorTitle: string = 'Ops!') {
    this.toastr.error(errorMessage, 'Ops!', this.configuration)
  }

  success(message: string, title: string = 'Oh Yes!!!') {
    this.toastr.success(message, title, this.configuration)
  }

  info(message: string) {
    this.toastr.info(message, null, this.configuration)
  }

}
