import utils.BinaryTreePrinter
import trees.binary.Node
import utils.GeneralTreePrinter

fun main(){
    val root = Node(1)
    root.left = Node(2, Node(4), Node(5))
    root.right = Node(3)
    BinaryTreePrinter.printNode(root)
    val treeRoot = trees.general.Node(8)
    treeRoot.children = listOf(1,2,3).map {
        trees.general.Node(it, listOf(6,7,8).map { n -> trees.general.Node(n) })
    }
    GeneralTreePrinter.printNode(treeRoot)
}