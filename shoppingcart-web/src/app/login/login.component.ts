import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';
import { AuthenticationService } from '../services/authentication.service';
import { User } from '../model/user';
import { AuthRequest } from '../model/auth.request';
import { Router } from '@angular/router';
import { ToastrService } from '../services/toastr.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent implements OnInit {

  userLoginForm: FormGroup
  userRegisterForm: FormGroup
  loginSubmitted = false
  registerSubmitted = false

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private userService: UserService,
    private authService: AuthenticationService,
    private toastr: ToastrService) { }


  ngOnInit() {
    this.userLoginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    })

    this.userRegisterForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    })
  }

  doLogin() {
    this.registerSubmitted = false
    this.loginSubmitted = true

    if (this.userLoginForm.invalid) {
      return;
    }
    this.authenticate(this.userLogin.username, this.userLogin.password)
  }

  doRegister() {
    this.loginSubmitted = false
    this.registerSubmitted = true
    if (this.userRegisterForm.invalid) {
      return;
    }

    this.userService.saveUser(this.userRegistration).subscribe((user) => {
      this.toastr.success(`Welcome ${user.name}!`)
      this.authenticate(this.userRegistration.email, this.userRegistration.password)
    })
  }

  authenticate(username: string, password: string) {
    this.authService.login(username, password)
    this.router.navigate(['/app'])
  }

  get loginControls() {
    return this.userLoginForm.controls;
  }

  get registerControls() {
    return this.userRegisterForm.controls
  }

  get userLogin(): AuthRequest {
    return new AuthRequest(this.userLoginForm.value)
  }

  get userRegistration(): User {
    return new User(this.userRegisterForm.value)
  }

}
