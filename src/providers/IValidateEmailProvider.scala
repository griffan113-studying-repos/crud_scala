package providers

trait IValidateEmailProvider {
  protected val regex = """^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$""".r

  def validate(email: String): Boolean
}
