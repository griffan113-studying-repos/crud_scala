// Eliel Michelmann Gaspar R.A 740294
// Niccolas Cente R.A 740266

import repositories.ProductRepository

object Main extends App {
  val productRepository = new ProductRepository()

  val product = productRepository.create("oreo", "bolacha muito boa", 14)

  val findProduct = productRepository.findById(product.id)

  findProduct.name = "Bolacha Óreo"

  productRepository.update(findProduct.id, findProduct)
}