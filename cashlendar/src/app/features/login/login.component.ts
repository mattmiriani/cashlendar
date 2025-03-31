import { Component, inject, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationServiceService } from '../../core/service/authentication/authentication-service.service';
import { CommonModule } from '@angular/common';
import { LoginForm, ILoginForm } from './login-form';

import {jwtDecode } from 'jwt-decode';

@Component({
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  standalone: true,
  selector: 'app-login',
  styleUrls: ['./login.component.scss'],
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  private _authenticationService = inject(AuthenticationServiceService);
  private _loginForm = inject(LoginForm);

  decodedToken: any

  public form!: FormGroup<ILoginForm>;

  ngOnInit() {
    this.form = this._loginForm.createForm();
  }

  onSubmit() {
    if (this.form.valid) {
      const username = this.form.get('username')?.value;
      const password = this.form.get('password')?.value;

      this._authenticationService.login({ username, password }).subscribe({

        next: (value) => {
          this.decodedToken = jwtDecode(value.token);
          console.log(this.decodedToken.sub);
          localStorage.setItem('active user', this.decodedToken.sub);
        },
        error: (error) => {
          console.error('Erro ao fazer login', error);
        }
      });
    } else {
      console.log('Formulário inválido');
    }
  }
}
