package entities.user

import java.time.LocalDateTime

trait IUser {
  var id: String
  var name: String
  var email: String
  var created_at: LocalDateTime
}
