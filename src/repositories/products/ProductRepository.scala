package repositories.products

import entities.product.{IProduct, Product}

import java.time.LocalDateTime

class ProductRepository extends IProductRepository {
  private var products: Vector[IProduct] = Vector()

  override def list(): Vector[IProduct] = this.products

  override def create(name: String, description: String, price: Float): IProduct = {
    def uuid = java.util.UUID.randomUUID.toString;

    val createdAt = LocalDateTime.now();

    val newProduct = new Product(uuid, name, description, price, createdAt);

    this.products = this.products :+ newProduct

    println(s"Produto criado: ${newProduct.name} com o ID: ${newProduct.id}")

    newProduct
  }

  override def delete(product: IProduct): Unit = {
    val productIndex = this.products.indexOf(product)

    if (productIndex == -1) {
      throw new Error("não tem esse produto, burro")
    }

    println(s"Produto delete ${product.name}")

    this.products = this.products filterNot product.==
  }

  override def findById(id: String): IProduct = {
    val product = this.products.find(_.id == id)

    if (product.isEmpty) {
      throw new Error("esse produto não existe")
    }

    product.get
  }

  override def update(id: String, productToUpdate: IProduct): IProduct = {
    val findProduct = this.products.find(_.id == id)

    if (findProduct.isEmpty) {
      throw new Error("esse produto não existe")
    }

    val productIndex = this.products.indexOf(findProduct.get)

    this.products = this.products.updated(productIndex, productToUpdate)

    println(productToUpdate)

    productToUpdate
  }
}
