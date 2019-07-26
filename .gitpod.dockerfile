# Heavily inspired by the gitpod/workspace-full Dockerfile (https://github.com/gitpod-io/workspace-images/blob/master/full/Dockerfile)
FROM buildpack-deps:cosmic

### base ###
RUN yes | unminimize \
    && apt-get install -yq \
        asciidoctor \
        bash-completion \
        build-essential \
        htop \
        jq \
        less \
        locales \
        man-db \
        nano \
        software-properties-common \
        sudo \
        vim \
        multitail \
    && locale-gen en_US.UTF-8 \
    && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/*
ENV LANG=en_US.UTF-8

### Gitpod user ###
# '-l': see https://docs.docker.com/develop/develop-images/dockerfile_best-practices/#user
RUN useradd -l -u 33333 -G sudo -md /home/gitpod -s /bin/bash -p gitpod gitpod \
    # passwordless sudo for users in the 'sudo' group
    && sed -i.bkp -e 's/%sudo\s\+ALL=(ALL\(:ALL\)\?)\s\+ALL/%sudo ALL=NOPASSWD:ALL/g' /etc/sudoers
ENV HOME=/home/gitpod
WORKDIR $HOME
# custom Bash prompt
RUN { echo && echo "PS1='\[\e]0;\u \w\a\]\[\033[01;32m\]\u\[\033[00m\] \[\033[01;34m\]\w\[\033[00m\] \\\$ '" ; } >> .bashrc

### Gitpod user (2) ###
USER gitpod
# use sudo so that user does not get sudo usage info on (the first) login
RUN sudo echo "Running 'sudo' for Gitpod: success"

### Java ###
## Setup jEnv
RUN git clone https://github.com/jenv/jenv.git ~/.jenv
ENV PATH="$HOME/.jenv/bin:$PATH"
RUN bash -c "echo 'export PATH=\"$HOME/.jenv/bin:$PATH\"' >> ~/.bash_profile \
             && echo 'eval \"\$(jenv init -)\"' >> ~/.bash_profile \
             && echo \"source ~/.bash_profile\" >> ~/.bashrc"
## Place 'm2-repository' in /workspace because (1) that's a fast volume, (2) it survives workspace-restarts and (3) it can be warmed-up by pre-builds.
RUN curl -s "https://get.sdkman.io" | bash \
 && bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install maven \
             && mkdir /home/gitpod/.m2 \
             && printf '<settings>\n  <localRepository>/workspace/m2-repository/</localRepository>\n</settings>\n' > /home/gitpod/.m2/settings.xml"
## Setup Java versions
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 8.0.222.hs-adpt"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 9.0.4-open"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 10.0.2-open \
             && sdk default java 10.0.2-open"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 11.0.2-open"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 12.0.2-open"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 13.ea.30-open"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 14.ea.6-open"
## Remove SDKMAN from the path, so it's not in the way of jEnv
RUN cp ~/.bashrc ~/.bashrc.bak
RUN bash -c "head -n -4 ~/.bashrc > ~/.bashrc"
## Add Java versions to Jenv
RUN bash -c "eval \"\$(jenv init -)\" \
             && jenv add /home/gitpod/.sdkman/candidates/java/8.0.222.hs-adpt \
             && jenv add /home/gitpod/.sdkman/candidates/java/9.0.4-open \
             && jenv add /home/gitpod/.sdkman/candidates/java/10.0.2-open \
             && jenv add /home/gitpod/.sdkman/candidates/java/11.0.2-open \
             && jenv add /home/gitpod/.sdkman/candidates/java/12.0.2-open \
             && jenv add /home/gitpod/.sdkman/candidates/java/13.ea.30-open \
             && jenv add /home/gitpod/.sdkman/candidates/java/14.ea.6-open \
             "

RUN jenv rehash
RUN bash -c "jenv sh-enable-plugin export \
             && jenv sh-enable-plugin maven"
RUN jenv global 10.0

COPY .gitpod.bash_profile .
RUN bash -c "cat .gitpod.bash_profile >> ~/.bash_profile \
             && rm .gitpod.bash_profile"

### checks ###
# no root-owned files in the home directory
RUN notOwnedFile=$(find . -not "(" -user gitpod -and -group gitpod ")" -print -quit) \
    && { [ -z "$notOwnedFile" ] \
        || { echo "Error: not all files/dirs in $HOME are owned by 'gitpod' user & group"; exit 1; } }
