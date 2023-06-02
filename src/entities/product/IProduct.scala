package entities.product

import java.time.LocalDateTime

trait IProduct {
  var id: String
  var name: String
  var description: String
  var price: Float
  var created_at: LocalDateTime
}
