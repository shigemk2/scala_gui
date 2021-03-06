// ウィンドウを作成する
// GUIプログラミングのおまじない
import scala.swing._

// MainFrameを継承してメンバーを変更しているので、
// クラス名は何でもいい
class SampleUI1 extends MainFrame {
  // タイトル
  title = "GUI Program #1"

  // ウィンドウサイズ
  preferredSize = new Dimension(320, 240)
  // ウィンドウの中身
  contents = new Label("Here is the contents!")
}

object GuiProgram1 {
  def main(args: Array[String]) {
    val ui = new SampleUI1
    // ウィンドウを表示させるかどうかを決めるメンバ
    ui.visible = true
    // ログっぽいやつ これが出ても終了しない
    println("End of main function")
  }
}
