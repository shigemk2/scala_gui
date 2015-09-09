import scala.swing._

class SampleUI5 extends MainFrame {
  // ウィンドウサイズ制御
  def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  title = "GUI Program #5"

  // チェックボックス
  val nameField = new TextField { columns = 32 }
  val likeScala = new CheckBox("I like Scala")
  likeScala.selected = true
  // ラジオボタン
  val status1 = new RadioButton("bachelor")
  val status2 = new RadioButton("master")
  val status3 = new RadioButton("doctor")
  status3.selected = true
  // セレクトボタン
  val statusGroup = new ButtonGroup(status1, status2, status3)
  val gender = new ComboBox(List("don't know", "female", "male"))
  // テキストフィールド
  val commentField = new TextArea { rows = 8; lineWrap = true; wordWrap = true }
  // ボタン
  val pressMe = new ToggleButton("Press me!")
  pressMe.selected = true

  restrictHeight(nameField)
  restrictHeight(gender)

  // コンポーネントの配置
  contents = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("My name")
      contents += Swing.HStrut(5)
      contents += nameField
    }
    contents += Swing.VStrut(5)
    contents += likeScala
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += status1
      contents += Swing.VStrut(10)
      contents += status2
      contents += Swing.HStrut(10)
      contents += status3
    }
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Gender")
      contents += Swing.HStrut(20)
      contents += gender
    }
    contents += Swing.VStrut(5)
    contents += new Label("Comments")
    contents += Swing.VStrut(3)
    contents += new ScrollPane(commentField)
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal){
      contents += pressMe
      contents += Swing.HGlue
      contents += Button("Close") { reportAndClose() }
    }
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }

  // closeボタンを押したときに出る標準出力
  def reportAndClose() {
    println("Your name: " + nameField.text)
    println("You like Scala: " + likeScala.selected)
    println("Undergraduate: " + status1.selected)
    println("Graduate: " + status2.selected)
    println("Professor: " + status3.selected)
    println("Gender: " + gender.selection.item +
      " (Index: " + gender.selection.index + ")")
    println("Comments: " + commentField.text)
    println("'Press me' is pressed: " + pressMe.selected)
    sys.exit(0)
  }
}

object GuiProgram5 {
  def main(args: Array[String]) {
    val ui = new SampleUI5
    ui.visible = true
  }
}
