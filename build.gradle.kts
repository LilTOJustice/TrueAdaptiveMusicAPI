plugins {
    id("base")
    id("org.jreleaser") version "1.27.0"
}

subprojects {
    layout.buildDirectory.set(rootProject.layout.buildDirectory.dir(name))
    apply(plugin = "org.jreleaser")
}
