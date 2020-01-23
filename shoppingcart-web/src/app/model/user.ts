export class User {

    public constructor(init?: Partial<User>) {
        Object.assign(this, init);
    }

    public id: string = ''
    public name: string = ''
    public email: string = ''
    public password: string = ''

}
