package org.bytecodeprobe

import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode
import java.util.jar.JarFile

fun parseJar(jar: JarFile): HashMap<String, ClassNode> {
    val classes = hashMapOf<String, ClassNode>()
    try {
        val entries = jar.entries()
        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            if (entry.name.endsWith(".class")) {
                val classReader = ClassReader(jar.getInputStream(entry))
                val classNode = ClassNode()
                classReader.accept(classNode, ClassReader.SKIP_DEBUG)
                classes.put(classNode.name, classNode)
            }
        }

        jar.close()
        return classes
    } catch (e: Exception) {
        println("Error parsing jar: ${e.message}")
        return classes
    }
}