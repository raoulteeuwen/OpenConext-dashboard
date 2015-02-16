# SURFconext SelfService

## About OpenConext

OpenConext is an OpenSource technology stack for creating and running Collaboration platforms. It uses technologies from Federated Identity Management, as is available in Research and Educational Access Federations, Group management and OpenSocial Social Networking Technology. The aim of the software is to provide a middleware platform that can combine generic and specialized collaboration tools and services, within Research and Education, and beyond, and make these available for collaboration over institutional and national borders. The features section describes the current and planned features for the platform.

OpenConext was developed by SURFnet as part of the SURFworks programme. SURFnet runs an instance of the platform for research and education in The Netherlands as SURFconext


OpenConext: [http://www.openconext.org](http://www.openconext.org)

SURFconext: [http://www.surfconext.nl](http://www.surfconext.nl)


## Getting started

### System Requirements

- Java 8
- Maven 3
- MySQL 5.5
- Gruntjs

### Building and running

#### The Server

    cd coin-selfservice-war

To build:

    mvn clean install

To run locally:

    mvn jetty:run

#### The client

    cd coin-selfservice-standalone

Initial setup:

    brew install npm
    gem install sass
    gem install sass-globbing
    gem install compass
    npm install -g grunt-cli
    npm install

When new grunt dependencies are added:

    npm install

To build:

    grunt watch

To run locally:

    grunt server

When you browse to the [application homepage](http://localhost:8001/) you will be prompted for a login.

A list of available log-ins can be found in the mocked [`Users` enum here](coin-selfservice-war/src/main/java/nl/surfnet/coin/selfservice/util/OpenConextOAuthClientMock.java).
