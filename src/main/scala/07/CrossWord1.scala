import scala.swing._
import scala.swing.event._

// SolverとUIで、ロジック部分とインターフェイス部分を分離する
class Solver {
  // ファイル読み込み
  // sbtのディレクトリ構造だと"words.txt"だとプロジェクトのホームディレクトリのファイルを読み込もうとする
  private val words = scala.io.Source.fromFile("data/words.txt").getLines().toSet

  // 文字列判定
  private def matches(pattern: String, word: String): Boolean = {
    if (word.length != pattern.length)
      return false
    for (i <- 0 until word.length) {
      val p = pattern(i)
      if (p != '?' && p != word(i)) {
        return false
      }
    }
    true
  }

  // varを使うのはイケてない
  def findWords(pattern: String): List[String] = {
    var w = List[String]()
    for (e <- words) {
      if (matches(pattern, e))
        w = e :: w
    }
    w
  }
}

class CrossWordUI(val solver: Solver) extends MainFrame {
  private def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  title = "Crossword Puzzle Helper"
  // 検索ボックス
  val searchField = new TextField { columns = 32 }
  val searchButton = new Button("Search")
  val searchLine = new BoxPanel(Orientation.Horizontal) {
    contents += searchField
    contents += Swing.HStrut(20)
    contents += searchButton
  }
  // 検索結果
  val resultField = new TextArea {
    rows = 10
    lineWrap = true
    wordWrap = true
    editable = false // readonly属性
  }

  // make sure that resizing only changes the resultField:
  restrictHeight(searchLine)

  // 実際にウィンドウにコンテンツをのせるのはココ
  contents = new BoxPanel(Orientation.Vertical) {
    contents += searchLine
    contents += Swing.VStrut(10)
    contents += new ScrollPane(resultField)
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }

  // クリックボタンを押すなどしたらイベントが発火する(searchNow呼び出し)
  listenTo(searchField)
  listenTo(searchButton)
  reactions += {
    case EditDone(`searchField`) => searchNow()
    case ButtonClicked(`searchButton`) => searchNow()
  }

  def searchNow() {
    val pattern = searchField.text.toLowerCase
    val words = solver.findWords(pattern)
    if (words.length == 0) {
      resultField.text = "\n\nSorry, no words found."
    } else {
      resultField.text = words.sorted mkString "\n"
      resultField.caret.position = 0
    }
  }
}

object CrossWord1 {
  def main(args: Array[String]) = {
    val solver = new Solver
    val ui = new CrossWordUI(solver)
    ui.visible = true
  }
}
