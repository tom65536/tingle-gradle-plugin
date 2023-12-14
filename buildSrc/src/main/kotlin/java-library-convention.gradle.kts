
plugins {
  `java-library`
  checkstyle
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

checkstyle {
    maxWarnings = 0
}

tasks.withType<JavaCompile> {
    options.isWarnings = true
}


dependencies {
  // constraints {
  //   implementation("org.apache.commons:commons-text:1.10.0")
  // }

  testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")

  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}
