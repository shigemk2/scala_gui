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
    contents += Swing.VStrut(10)
    contents += Swing.Glue
    contents += Button("Press me, please") { println("Thank you") }
    contents += Swing.VStrut(10)
    contents += Button("Close") { sys.exit(0) }
    // margin
    border = Swing.EmptyBorder(10, 10, 10, 10)
    // 線を入れる
    // border = Swing.BeveledBorder(Swing.Lowered)
    // 線を入れる
    // border = Swing.BeveledBorder(Swing.Raised)
    // 線を入れる
    // border = Swing.MatteBorder(10, 10, 10, 10, java.awt.Color.GREEN)
    // 線を入れる
    // border = Swing.TitledBorder(Swing.LineBorder(java.awt.Color.RED), "Fun")
    // 線を入れる
    // border = Swing.TitledBorder(Swing.EtchedBorder(Swing.Lowered), "Hoge")
    // 線を入れる
    // border = Swing.CompoundBorder(Swing.BeveledBorder(Swing.Lowered),
    //   Swing.EmptyBorder(10, 10, 10, 10))
  }


  // 代わりにこのように書くことも出来る
  // val box = new BoxPanel(Orientation.Vertical)
  // box.contents += new Label("Look at me!")
  // box.contents += Button("Press me, please") { println("Thank you") }
  // box.contents += Button("Close") { sys.exit(0) }
  // contents = box
}

object GuiProgram3 {
  def main(args: Array[String]) {
    val ui = new SampleUI3
    ui.visible = true
  }
}
