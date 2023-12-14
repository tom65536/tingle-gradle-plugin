
plugins {
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.10.0")
        }

        val functionalTest by registering(JvmTestSuite::class) {
            dependencies {
                implementation(project())
            }

            targets {
                all {
                    testTask.configure { shouldRunAfter(test) } 
                }
            }
        }
    }
}

gradlePlugin {
    val greeting by plugins.creating {
        id = "io.github.tom65536.tingle"
        implementationClass = "io.github.tom65536.tingle.TingleGradlePlugin"
    }
}

gradlePlugin.testSourceSets.add(sourceSets["functionalTest"])

tasks.named<Task>("check") {
    dependsOn(testing.suites.named("functionalTest"))
}
