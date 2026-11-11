SpinHit - Fabric 1.21.11

Build (needs JDK 21 and internet):
  1. Easiest: generate a fresh template at https://fabricmc.net/develop (1.21.11),
     then copy src/ from this folder over its src/.
     OR use this project as is: run `gradle wrapper` once, then:
  2. ./gradlew build        (Windows: gradlew.bat build)
  3. Jar appears in build/libs/spinhit-1.0.0.jar (not the -sources one)
  4. Put it in .minecraft/mods with Fabric API installed.

If a version in gradle.properties fails to resolve, update it from fabricmc.net/develop.
