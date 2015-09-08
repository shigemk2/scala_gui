import scala.swing._

class SampleUI3 extends MainFrame {
  title = "GUI Program #3"
  // 複数のコンポーネントをウィンドウに入れたい場合は、
  // scala.swing.BoxPanelを使う
  // Orientation.Horizonalを使うと、コンポーネントを横並びに出来る
  // preferredSize = new Dimension(800, 600)
  contents = new BoxPanel(Orientation.Vertical) {
  // contents = new BoxPanel(Orientation.Horizontal) {
    contents += new Label("Look at me!")
    contents += Button("Press me, please") { println("Thank you") }
    contents += Button("Close") { sys.exit(0) }
    // margin
    // border = Swing.EmptyBorder(10, 10, 10, 10)
    // 線を入れる
    // border = Swing.BeveledBorder(Swing.Lowered)
    // 線を入れる
    // border = Swing.BeveledBorder(Swing.Raised)
    // 線を入れる
    border = Swing.MatteBorder(10, 10, 10, 10, java.awt.Color.GREEN)
  }


  // 代わりにこのように書くことも出来る
  // val box = new BoxPanel(Orientation.Vertical)
  // box.contents += new Label("Look at me!")
  // box.contents += Button("Press me, please") { println("Thank you") }
  // box.contents += Button("Close") { sys.exit(0) }
  // contents = box
}

object GuiProgramThree {
  def main(args: Array[String]) {
    val ui = new SampleUI3
    ui.visible = true
  }
}
