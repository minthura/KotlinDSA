package trees.binary

class Node<T : Comparable<*>?>(var data: T, var left: Node<T>? = null, var right: Node<T>? = null)