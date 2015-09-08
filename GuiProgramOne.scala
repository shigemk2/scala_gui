// GUIプログラミングのおまじない
import scala.swing._

class UI extends MainFrame {
  // タイトル
  title = "GUI Program #1"

  preferredSize = new Dimension(320, 240)
  contents = new Label("Here is the contents!")
}

object GuiProgramOne {
  def main(args: Array[String]) {
    val ui = new UI
    // ウィンドウを表示させるかどうかを決めるメンバ
    ui.visible = true
    // ログっぽいやつ これが出ても終了しない
    println("End of main function")
  }
}
