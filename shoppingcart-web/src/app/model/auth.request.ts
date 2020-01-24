export class AuthRequest {

  public constructor(init?: Partial<AuthRequest>) {
    Object.assign(this, init)
  }

  public username: string = ''
  public password: string = ''
}
