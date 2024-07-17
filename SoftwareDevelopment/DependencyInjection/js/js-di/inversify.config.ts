// inversify.config.ts
import { Container } from "inversify";
import { TYPES } from "./types";
import { Warrior, Weapon, ThrowableWeapon } from "./interfaces";
import { Ninja } from "./entities/ninja";
import { Katana } from "./entities/katana";
import { Shuriken } from "./entities/shuriken";

const container = new Container();
container.bind<Warrior>(TYPES.Warrior).to(Ninja);
container.bind<Weapon>(TYPES.Weapon).to(Katana);
container.bind<ThrowableWeapon>(TYPES.ThrowableWeapon).to(Shuriken);

export { container };

