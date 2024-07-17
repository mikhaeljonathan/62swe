// entities/katana.ts
import { injectable } from "inversify";
import { Weapon } from "../interfaces";

@injectable()
class Katana implements Weapon {
  public hit(): string {
    return "cut!";
  }
}

export { Katana };
