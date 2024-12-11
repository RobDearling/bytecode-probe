package org.bytecodeprobe

import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode

class ClassWrapper(val jar: JarWrapper, val classNode: ClassNode) {
    val name: String get() = classNode.name
    val superName: String get() = classNode.superName
    val superType = Type.getObjectType(classNode.superName)
    val abstract = (classNode.access and org.objectweb.asm.Opcodes.ACC_ABSTRACT) != 0
}