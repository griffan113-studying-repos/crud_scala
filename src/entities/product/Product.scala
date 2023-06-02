package entities.product

import java.time.LocalDateTime

class Product(var id: String, var name: String, var description: String, var price: Float, var created_at: LocalDateTime) extends IProduct {}
