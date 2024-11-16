plugins {
    id("hq.shared")
    id("hq.shadow")
    id("xyz.jpenilla.resource-factory-bukkit-convention")
}

bukkitPluginYaml {
    main.set("com.softhub.attacksound.core.AttackSoundPlugin")
    name.set("${extra["projectName"]}")
    authors.add("minhyeok")
    depend.add("SoftFramework")
    apiVersion.set("1.17")

    libraries.add("org.jetbrains.kotlin:kotlin-stdlib:1.7.21")
    libraries.add("org.jetbrains.kotlin:kotlin-reflect:1.7.21")
    libraries.add("org.jetbrains.kotlin:kotlin-test:1.7.21")
}

dependencies {
    compileOnly(libs.paper.api)
    compileOnly(libs.protocollib)
    compileOnly(framework.core)
    compileOnly(project(":modules:api"))
    runtimeOnly(project(":modules:api"))
}