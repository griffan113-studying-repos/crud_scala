package providers

import scala.util.matching.Regex

trait IValidateEmailProvider {
  protected val regex: Regex = """^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$""".r

  def validate(email: String): Boolean
}
