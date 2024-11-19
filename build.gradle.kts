plugins {
    kotlin("jvm") version "1.9.0" // Plugin do Kotlin
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.6.2") // Para rodar os testes com JUnit5
    testImplementation("io.kotest:kotest-assertions-core:5.6.2") // Para usar os matchers do Kotest
    testImplementation("io.kotest:kotest-framework-engine:5.6.2") // Necessário para o motor do Kotest
    testImplementation("io.mockk:mockk:1.13.4") //Para usar o mockk
}

tasks.test {
    useJUnitPlatform()
    reports {
        html.required.set(true)  // Gera relatório em HTML
        junitXml.required.set(true)  // Gera relatório em formato XML
    }
}
