package org.bytecodeprobe

import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode
import java.nio.file.Path
import java.util.jar.JarFile

class JarWrapper(private val pathToJar: Path) {
    val classes = readJar(pathToJar).map { ClassWrapper(this, it) }

    private fun readJar(path: Path, classReaderFlags: Int = 0): Collection<ClassNode> {
        return JarFile(path.toFile()).use { jarFile ->
            jarFile.stream().iterator().asSequence()
                .filter { it.name.endsWith(".class") }
                .map {
                    ClassNode().apply {
                        ClassReader(jarFile.getInputStream(it)).accept(this, classReaderFlags)
                    }
                }.toList()
        }
    }
}