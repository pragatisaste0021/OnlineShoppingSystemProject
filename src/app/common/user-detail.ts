export class UserDetail {

    constructor(
        public user_id: number,
        public first_name: string,
        public last_name: string,
        public username: string,
        public userpassword: string,
        public residentialAddress: string,
        public permanentAddress: string,
    ) { }
}
