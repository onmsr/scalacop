package onmsr.scalacop.chapter23

import org.specs2.mutable.Specification

class MainSpec extends Specification {
  "MainSpec" should {
    "simple for test" in {
      val lara = Person("Lara", false)
      val bob = Person("Bob", true)
      val julie = Person("Julie", false, lara, bob)
      val persons = List(lara, bob, julie)

      val v1 = persons.filter(p => !p.isMale).flatMap(p => p.children.map(c => (p.name, c.name)))
      val v2 = persons.withFilter(p => !p.isMale).flatMap(p => p.children.map(c => (p.name, c.name)))
      val v3 = for(p <- persons; n = p.name; if (n.startsWith("La"))) yield n
      v1.length must_== 2
      v2.length must_== 2
      v3.length must_== 1
    }
  }
}

