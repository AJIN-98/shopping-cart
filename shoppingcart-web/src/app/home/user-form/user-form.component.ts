import {Component, OnInit} from '@angular/core'
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms'
import {UserService} from 'src/app/services/user.service'
import {ActivatedRoute} from '@angular/router'
import {User} from '../../model/user'
import {ToastrService} from '../../services/toastr.service'

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  userForm: FormGroup
  submitted = false

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private service: UserService,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      email: new FormControl({value: '', disabled: true}, [Validators.required, Validators.email]),
      password: ['', Validators.required]

    })
    this.service.getUser(JSON.parse(localStorage.getItem('currentUser')).idUser).subscribe((user) => {
      this.userForm.patchValue(user)
      this.userForm.patchValue({password: ''})

    })
  }

  get userFormControls() {
    return this.userForm.controls
  }

  save() {
    this.submitted = true
    if (this.userForm.invalid) {
      return
    }
    this.service.saveUser(new User(this.userForm.value)).subscribe((user) => {
      this.userForm.patchValue(user)
      this.toastr.success('User updated!')
    })
  }

}
