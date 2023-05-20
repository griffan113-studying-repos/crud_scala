package repositories

import entities.IProduct

trait IProductRepository {
  def list(): Vector[IProduct]
  def create(name: String, description: String, price: Float): IProduct
  def findById(id: String): IProduct
  def delete(product: IProduct): Unit
  def update(id: String, productToUpdate: IProduct): IProduct
}
