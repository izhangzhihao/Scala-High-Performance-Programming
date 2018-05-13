package highperfscala.specialization

object tuple {

  case class Bar(value: Int) extends AnyVal

  def tuple2Boxed: (Int, Bar) = (1, Bar(2))

  case class IntBar(i: Int, b: Bar)

  def intBar: IntBar = IntBar(1, Bar(1))
}
