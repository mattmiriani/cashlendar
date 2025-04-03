import {Injectable, OnDestroy} from '@angular/core';
import {Subscription} from 'rxjs';

@Injectable()
export class Destroyer implements OnDestroy {
  protected unsubscribe$ = new Subscription();

  ngOnDestroy() {
    this.unsubscribe$.unsubscribe();
  }

}
