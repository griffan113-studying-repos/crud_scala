package repositories.users

import entities.user.IUser

trait IUserRepository {
  def list(): Vector[IUser]

  def create(name: String, email: String): IUser

  def findById(id: String): IUser

  def delete(user: IUser): Unit

  def update(id: String, userToUpdate: IUser): IUser
}
