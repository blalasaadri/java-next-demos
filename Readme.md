# "Java next" examples

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/blalasaadri/java-next-demos)

This repository is intended as a basis for presenting changes in Java 10, 11, 12, 13 and 14 (compared to earlier versions).
It is optimized for being used in [Gitpod](https://gitpod.io/#https://github.com/blalasaadri/java-next-demos), but can also be used in any other evironment.

## Running the examples locally with Docker

If you have Docker installed, you can run the container locally using which

```shell
docker build -f .gitpod.dockerfile -t blalasaadri/java-8-to-14 .
docker run -it \
           -v "$PWD/java-10-examples:/home/gitpod/java-10-examples" \
           -v "$PWD/java-11-examples:/home/gitpod/java-11-examples" \
           -v "$PWD/java-12-examples:/home/gitpod/java-12-examples" \
           -v "$PWD/java-13-ea-examples:/home/gitpod/java-13-ea-examples" \
           -v "$PWD/java-14-ea-examples:/home/gitpod/java-14-ea-examples" \
           blalasaadri/java-8-to-14:latest bash
```

## Java versions

The individual Java versions are installed via [SDKMAN!](https://sdkman.io/) and then handled by [jEnv](https://www.jenv.be/).
If you should choose to install these versions locally, make sure that the jenv plugins `export` and `maven` are enabled by running:

```shell
eval "$(jenv init -)"
jenv enable-plugin export
jenv enable-plugin maven
```

(These can be added to the settings of your shell, e.g. in `~/.bashrc`.)
