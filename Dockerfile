FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y build-essential \
                       git \
                       wget \
                       dpkg \
                       sudo \
                       vim

# java jdk11 (default in ubuntu20.04)
RUN apt-get install -y default-jre \
                       default-jdk

# scala
RUN wget https://downloads.lightbend.com/scala/2.13.4/scala-2.13.4.deb && \
    dpkg -i scala-2.13.4.deb && \
    rm scala-2.13.4.deb

# sbt
RUN echo "Set disable_coredump false" >> /etc/sudo.conf && \
    echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list && \
    sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823 && \
    sudo apt-get update && \
    apt-get install -y sbt

RUN apt-get clean && rm -rf /var/lib/apt/lists/*

COPY . /app
WORKDIR /app
