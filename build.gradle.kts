import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.1.0"
    id("io.ktor.plugin") version "2.3.12"
    application
}

group = "com.dergruenkohl"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.hypixel.net/repository/Hypixel/")
    maven("https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.github.discord-jda:JDA:5.2.3")
    implementation("club.minnced:jda-ktx:0.12.0")
    implementation("ch.qos.logback:logback-classic:1.5.16")
    implementation("net.hypixel:hypixel-api-transport-reactor:4.4")
    implementation("io.projectreactor.netty:reactor-netty-core:1.1.18")
    implementation("io.projectreactor.netty:reactor-netty-http:1.1.18")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
tasks.withType<ShadowJar> {
    archiveFileName.set("EternalPrison.jar")
}

kotlin{
    jvmToolchain(18)
}

application {
    mainClass.set("com.dergruenkohl.MainKt")
    applicationDefaultJvmArgs = listOf(
        "-XX:+UseG1GC",
        "-XX:+UnlockExperimentalVMOptions",
        "-XX:+DisableExplicitGC",
        "-XX:G1NewSizePercent=20",
        "-XX:G1ReservePercent=20",
        "-XX:MaxGCPauseMillis=50",
        "-XX:G1HeapRegionSize=32M",
        "-XX:+ParallelRefProcEnabled",
        "-XX:+PerfDisableSharedMem",
        "-XX:+AlwaysPreTouch",
        "-Xmx256M",
    )
}