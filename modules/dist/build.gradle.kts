plugins {
    id("hq.shared")
    id("hq.shadow")
    id("xyz.jpenilla.resource-factory-bukkit-convention")
}

bukkitPluginYaml {
    main.set("com.softhub.softframework.BukkitFrameworkPlugin")
    name.set("${extra["projectName"]}")
    authors.add("minhyeok")
    depend.add("SoftFramework")
    apiVersion.set("1.17")

    libraries.add("org.jetbrains.kotlin:kotlin-stdlib:1.7.21")
    libraries.add("org.jetbrains.kotlin:kotlin-reflect:1.7.21")
    libraries.add("org.jetbrains.kotlin:kotlin-test:1.7.21")
}

dependencies {
    compileOnly(libs.spigot.api)
    compileOnly(framework.core)
    runtimeOnly(project(":modules:core"))
    runtimeOnly(project(":modules:api"))
}
