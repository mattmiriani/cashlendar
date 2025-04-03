import { Component, inject, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationServiceService } from '../../core/service/authentication/authentication-service.service';
import { CommonModule } from '@angular/common';
import { ILoginForm, LoginForm } from './login-form';
import { jwtDecode } from 'jwt-decode';
import { Destroyer } from '../../shared/destroyer';

@Component({
  imports: [ReactiveFormsModule, CommonModule],
  standalone: true,
  selector: 'app-login',
  styleUrls: ['./login.component.scss'],
  templateUrl: './login.component.html',
})
export class LoginComponent extends Destroyer implements OnInit {
  private authService = inject(AuthenticationServiceService);
  private loginFormBuilder = inject(LoginForm);
  private decodedToken: any;

  public form!: FormGroup<ILoginForm>;
  public errorMessage: string | null = null;

  ngOnInit() {
    this.form = this.loginFormBuilder.createForm();
  }

  onSubmit() {
    if (this.form.valid) {
      this.errorMessage = null;
      const { username, password } = this.form.value;

      this.unsubscribe$.add(
        this.authService.login({ username, password }).subscribe({
          next: (value) => {
            this.decodedToken = jwtDecode(value.token);
            localStorage.setItem('activeUser', this.decodedToken.sub);
          },
          error: (error) => {
            if (error.status === 401) {
              this.errorMessage = 'Credenciais inválidas. Por favor, tente novamente.';
            }

            if (error.status !== 401) {
              console.error('Erro ao fazer login', error);
              this.errorMessage = 'Ocorreu um erro ao tentar fazer login. Por favor, tente novamente mais tarde.';
            }
          }
        })
      );
    }
  }

  verifyControlUsername(): boolean {
    return this.form.controls['username']?.invalid && (this.form.controls['username']?.dirty || this.form.controls['username']?.touched);
  }

  verifyControlPassword(): boolean {
    return this.form.controls['password']?.invalid && (this.form.controls['password']?.dirty || this.form.controls['password']?.touched);
  }
}
