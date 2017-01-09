package onmsr.scalacop.chapter21

import java.awt.event.{ ActionEvent, ActionListener }
import javax.swing.JButton
import org.specs2.mutable.Specification

class MainSpec extends Specification {
  "MainSpec" should {

    "implicit parameter test" in {
      implicit val (a, b, c) = (Dollar(0), Euro(0), En(0))
      val v = Main.test2()
      v._1 must_== a
    }

    "implicit class test" in {
      import Rectangle.RectangleMaker
      val s = (10 x 100).menseki
      s must_== 1000
    }

    "button" in {
      skipped
      val button = new JButton
      button.addActionListener(
        new ActionListener {
          def actionPerformed(event: ActionEvent) = {
            println("pressed!")
          }
        }
      )
      true
    }

    "button test with implicit conversion." in {
      skipped
      implicit def function2ActionListener(f: ActionEvent => Unit) = {
        new ActionListener {
          def actionPerformed(event: ActionEvent) = f(event)
        }
      }
      val button = new JButton
      button.addActionListener { event: ActionEvent =>
        println("pressed!")
      }
      true
    }
  }
}


