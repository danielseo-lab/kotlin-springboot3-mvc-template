import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.getByName<BootJar>("bootJar") {
    enabled = true
}

tasks.getByName<Jar>("jar") {
    enabled = true
}
dependencies {
    implementation(project(":api:core"))
    implementation(project(":api:adapter"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")
//    implementation("org.flywaydb:flyway-core")
//    developmentOnly("org.springframework.boot:spring-boot-devtools")
    // 테스트에서만 사용하자
//    implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")

//    runtimeOnly("com.h2database:h2")
}