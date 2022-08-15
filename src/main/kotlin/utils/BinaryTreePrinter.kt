package utils

import trees.binary.Node
import kotlin.math.pow


internal object BinaryTreePrinter {
    fun <T : Comparable<*>?> printNode(root: Node<T>?) {
        val maxLevel = maxLevel(root)
        printNodeInternal(listOf(root), 1, maxLevel)
    }

    private fun <T : Comparable<*>?> printNodeInternal(nodes: List<Node<T>?>, level: Int, maxLevel: Int) {
        if (nodes.isEmpty() || isAllElementsNull<Node<T>?>(nodes)) return
        val floor = maxLevel - level
        val edgeLines = 2.0.pow((floor - 1).coerceAtLeast(0).toDouble()).toInt()
        val firstSpaces = 2.0.pow(floor.toDouble()).toInt() - 1
        val betweenSpaces = 2.0.pow((floor + 1).toDouble()).toInt() - 1
        printWhitespaces(firstSpaces)
        val newNodes: MutableList<Node<T>?> = ArrayList<Node<T>?>()
        for (node in nodes) {
            if (node != null) {
                print(node.data)
                newNodes.add(node.left)
                newNodes.add(node.right)
            } else {
                newNodes.add(null)
                newNodes.add(null)
                print(" ")
            }
            printWhitespaces(betweenSpaces)
        }
        println("")
        for (i in 1..edgeLines) {
            for (j in nodes.indices) {
                printWhitespaces(firstSpaces - i)
                if (nodes[j] == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1)
                    continue
                }
                if (nodes[j]?.left != null) print("/") else printWhitespaces(1)
                printWhitespaces(i + i - 1)
                if (nodes[j]?.right != null) print("\\") else printWhitespaces(1)
                printWhitespaces(edgeLines + edgeLines - i)
            }
            println("")
        }
        printNodeInternal<T>(newNodes, level + 1, maxLevel)
    }

    private fun printWhitespaces(count: Int) {
        for (i in 0 until count) print(" ")
    }

    private fun <T : Comparable<*>?> maxLevel(node: Node<T>?): Int {
        return if (node == null) 0 else maxLevel(node.left).coerceAtLeast(maxLevel(node.right)) + 1
    }

    private fun <T> isAllElementsNull(list: List<T>): Boolean {
        for (`object` in list) {
            if (`object` != null) return false
        }
        return true
    }
}