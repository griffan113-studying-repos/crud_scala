package providers

class ValidateEmailProvider extends IValidateEmailProvider {
  override def validate(email: String): Boolean = {
    this.regex.matches(email)
  }
}
