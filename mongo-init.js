db.createUser(
        {
            user: "usr_log",
            pwd: "pass1234",
            roles: [
                {
                    role: "readWrite",
                    db: "db_log"
                }
            ]
        }
);