// entities/ninja.ts
import { injectable, inject } from "inversify";
import { Warrior, Weapon, ThrowableWeapon } from "../interfaces";
import { TYPES } from "../types";

@injectable()
class Ninja implements Warrior {
  private _katana: Weapon;
  private _shuriken: ThrowableWeapon;

  public constructor(
    @inject(TYPES.Weapon) katana: Weapon,
    @inject(TYPES.ThrowableWeapon) shuriken: ThrowableWeapon
  ) {
    this._katana = katana;
    this._shuriken = shuriken;
  }

  public fight(): string {
    return this._katana.hit();
  }

  public sneak(): string {
    return this._shuriken.throw();
  }
}

export { Ninja };
