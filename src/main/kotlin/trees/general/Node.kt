package trees.general

class Node<T : Comparable<*>?>(var data: T, var children: List<Node<T>>? = null)