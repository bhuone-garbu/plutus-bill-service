# Intro

Plutus-service will be the core backend for project: *plutus* re-written in Java, using SprintBoot. Previously, it was built using Python Django where everything was merged into a single monolithic architecture as a proof of concept.
Services are now going to be split. This will primarily focus on serving the core data and handling the databases where relational constraints are needed. Event/Activities related data will be handled by a different stack, and won't be part of this service.

# Tech stack

* SprintBoot
* Postgresql
* Flywaydb
* Native Hibernate for ORM
* Docker
