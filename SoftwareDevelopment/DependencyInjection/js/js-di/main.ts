// main.ts
import "reflect-metadata";
import { container } from "./inversify.config";
import { TYPES } from "./types";
import { Warrior } from "./interfaces";

const ninja = container.get<Warrior>(TYPES.Warrior);
console.log(ninja.fight());  // Outputs: cut!
console.log(ninja.sneak());  // Outputs: hit!

