package org.bytecodeprobe

import java.nio.file.Path

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Error: Please provide a path to the JAR file as an argument")
        return
    }

    try {
        val pathToJar = Path.of(args[0])
        if (!pathToJar.toFile().exists()) {
            println("Error: The specified file does not exist: ${args[0]}")
            return
        }
        if (!args[0].endsWith(".jar")) {
            println("Warning: The specified file does not have a .jar extension")
        }
        
        val jar = JarWrapper(pathToJar)
        println(jar.classes.size)
    } catch (e: java.nio.file.InvalidPathException) {
        println("Error: Invalid path format: ${args[0]}")
        return
    }
}