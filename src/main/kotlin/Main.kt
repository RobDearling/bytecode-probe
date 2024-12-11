package org.bytecodeprobe

import java.nio.file.Path

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    val pathToJar = Path.of(args[0])
    val jar = JarWrapper(pathToJar)
    println(jar.classes.size)
}