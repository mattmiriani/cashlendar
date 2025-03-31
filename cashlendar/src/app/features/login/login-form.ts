import { inject, Injectable } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

export interface ILoginForm {
  username: FormControl<string | null>;
  password: FormControl<string | null>;
  token: FormControl<string | null>;
}

@Injectable(
  {providedIn: 'root'}
)
export class LoginForm {
  private _formBuilder = inject(FormBuilder);

  public createForm(): FormGroup<ILoginForm> {
    const username = new FormControl('', [Validators.required, Validators.email]);
    const password = new FormControl('', [Validators.required, Validators.minLength(6)]);
    const token = new FormControl('');

    return this._formBuilder.group({
      username,
      password,
      token,
    });
  }
}
