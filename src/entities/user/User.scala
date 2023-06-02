package entities.user

import java.time.LocalDateTime

class User(var id: String, var name: String, var email: String, var created_at: LocalDateTime) extends IUser {}
