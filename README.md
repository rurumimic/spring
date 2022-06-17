# Spring

- Java
- Kotlin
- Scala
- Clojure

## Documentations

- [quickstart](https://spring.io/quickstart) spring

### Java™ Development Kit. 

#### JDK 11

```bash
java -version

openjdk version "11.0.15.1" 2022-04-22 LTS
OpenJDK Runtime Environment (build 11.0.15.1+2-LTS)
OpenJDK 64-Bit Server VM (build 11.0.15.1+2-LTS, mixed mode)
```

#### Install JDK 11

- [jenv](https://github.com/jenv/jenv): Manage your Java environment
- [BellSoft Liberica JDK](https://bell-sw.com/pages/downloads/#/java-11-lts): version 8 or version 11

```bash
# JDK Path
/usr/libexec/java_home --verbose

# Add a version
jenv add /Library/Java/JavaVirtualMachines/liberica-jdk-11.jdk/Contents/Home
## (if 11 already present) Update JDK 11
### rm ~/.jenv/versions/11
### ln -s /Library/Java/JavaVirtualMachines/liberica-jdk-11.jdk/Contents/Home ~/.jenv/versions/11

# Set a project JDK
jenv local 11 # This will create a `.java-version` file
```

