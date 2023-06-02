package repositories.users

import entities.user.{IUser, User}
import providers.{IValidateEmailProvider, ValidateEmailProvider}

import java.time.LocalDateTime

class UserRepository extends IUserRepository {
  private var users: Vector[IUser] = Vector()
  private val validateEmailProvider: IValidateEmailProvider = new ValidateEmailProvider()

  override def list(): Vector[IUser] = this.users

  override def create(name: String, email: String): IUser = {
    def uuid = java.util.UUID.randomUUID.toString;

    val createdAt = LocalDateTime.now();

    val isEmailValid = validateEmailProvider.validate(email);

    if (!isEmailValid) {
      throw new Error("O email não é válido!")
    }

    val newUser = new User(uuid, name, email, createdAt);

    this.users = this.users :+ newUser

    println(s"Usuário criado: ${newUser.name} com o ID: ${newUser.id}")

    newUser
  }

  override def delete(user: IUser): Unit = {
    val userIndex = this.users.indexOf(user)

    if (userIndex == -1) {
      throw new Error("Usuário não encontrado")
    }

    this.users = this.users filterNot user.==
  }

  override def findById(id: String): IUser = {
    val product = this.users.find(_.id == id)

    if (product.isEmpty) {
      throw new Error("Esse usuário não existe")
    }

    product.get
  }

  override def update(id: String, userToUpdate: IUser): IUser = {
    val findUser = this.users.find(_.id == id)

    if (findUser.isEmpty) {
      throw new Error("Esse usuário não existe")
    }

    val userIndex = this.users.indexOf(findUser.get)

    this.users = this.users.updated(userIndex, userToUpdate)

    println(userToUpdate)

    userToUpdate
  }
}
