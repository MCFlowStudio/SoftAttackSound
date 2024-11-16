rootProject.name = getProperty("projectName")

pluginManagement {
    plugins {
        id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.2.0"
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.hqservice.kr/repository/maven-public")
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.dmulloy2.net/repository/public/")
    }

    versionCatalogs {
        create("libs") {
            library("spigot-api", "org.spigotmc:spigot-api:${getProperty("spigotVersion")}")
            library("paper-api", "io.papermc.paper:paper-api:${getProperty("spigotVersion")}")
            library("protocollib", "com.comphenix.protocol:ProtocolLib:${getProperty("protocolLibVersion")}")

        }
        create("framework") {
            library("core", "com.softhub:soft-framework:${getProperty("softFrameworkVersion")}")
        }
    }
}

file(rootProject.projectDir.path + "/credentials.gradle.kts").let {
    if (it.exists()) {
        apply(it.path)
    }
}

includeBuild("build-logic")
includeAll("modules")

fun includeAll(modulesDir: String) {
    file("${rootProject.projectDir.path}/${modulesDir.replace(":", "/")}/").listFiles()?.forEach { modulePath ->
        include("${modulesDir.replace("/", ":")}:${modulePath.name}")
    }
}

fun getProperty(key: String): String {
    return extra[key]?.toString() ?: throw IllegalArgumentException("property with $key not found")
}
