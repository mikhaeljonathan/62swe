// entities/shuriken.ts
import { injectable } from "inversify";
import { ThrowableWeapon } from "../interfaces";

@injectable()
class Shuriken implements ThrowableWeapon {
  public throw(): string {
    return "hit!";
  }
}

export { Shuriken };
