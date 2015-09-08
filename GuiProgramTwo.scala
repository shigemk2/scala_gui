import scala.swing._

class SampleUI extends MainFrame {
  title = "GUI Program #2"
  preferredSize = new Dimension(320, 240)
  // Buttonの中身はボタンがクリックされて初めて呼ばれる
  contents = Button("Press me, please") { println("Thank you") }
}

object GuiProgramTwo {
  def main(args: Array[String]) {
    val ui = new SampleUI
    // visibleメンバのデフォルトはfalseっぽい
    ui.visible = true
  }
}
