package onmsr.scalacop.chapter23


case class Person(name: String, isMale: Boolean, children: Person*)

/**23章まとめ
 * forルール
 * - map: 1個のジェネレーターで定義されるfor式が利用可能
 * - map+flatMap: 複数のジェネレーターで定義されるfor式が利用可能
 * - foreach: forループが利用可能
 * - withFilter: ifフィルターのはいったfor式が利用可能
 *
 */


