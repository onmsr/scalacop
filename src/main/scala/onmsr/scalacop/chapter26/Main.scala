package onmsr.scalacop.chapter26

object EMail extends ((String, String) => String) {
  def apply(user: String, domain: String) = {
    s"${user}@${domain}"
  }
  def unapply(str: String): Option[(String, String)] = {
    val parts = str.split("@")
    parts match {
      case Array(user, domain) => Some((user, domain))
      case _ => None
    }
  }
}
