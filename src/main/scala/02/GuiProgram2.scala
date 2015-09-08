import scala.swing._

class SampleUI2 extends MainFrame {
  title = "GUI Program #2"
  preferredSize = new Dimension(320, 240)
  // Buttonの中身はボタンがクリックされて初めて呼ばれる
  contents = Button("Press me, please") { println("Thank you") }
}

object GuiProgram2 {
  def main(args: Array[String]) {
    val ui = new SampleUI2
    // visibleメンバのデフォルトはfalseっぽい
    ui.visible = true
  }
}
