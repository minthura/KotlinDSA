package utils

import trees.general.Node

internal object GeneralTreePrinter {
    fun <T : Comparable<*>?> printNode(root: Node<T>?) {
        val buffer = StringBuffer(50)
        print(root, buffer, "", "")
        println(buffer.toString())
    }

    private fun <T : Comparable<*>?> print(root: Node<T>?, buffer: StringBuffer, prefix: String, childrenPrefix: String) {
        buffer.append(prefix)
        buffer.append(root?.data)
        buffer.append('\n')
        root?.children?.iterator()?.let {
            while (it.hasNext()){
                val node = it.next()
                if (it.hasNext()) {
                    print(node, buffer, "$childrenPrefix├── ", "$childrenPrefix│   ");
                } else {
                    print(node, buffer, "$childrenPrefix└── ", "$childrenPrefix    ");
                }
            }
        }
    }
}