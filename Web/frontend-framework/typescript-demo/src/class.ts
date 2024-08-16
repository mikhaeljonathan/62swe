class Animal {
    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    public move(distanceInMeters: number = 0) {
        console.log(`${this.name} moved ${distanceInMeters}m.`);
    }
}

let dog = new Animal('Dog');
dog.move(10);
