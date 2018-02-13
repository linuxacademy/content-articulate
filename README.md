
# Articulate

A sample application built with [Spring Boot](http://projects.spring.io/spring-boot/) that demonstrates capabilities of Cloud Foundry.


## To run the application locally

```
$ ./mvnw spring-boot:run
```

Then go to the http://localhost:8080 in your browser.  The application uses an embedded H2 database when running in this mode.

## To run on Cloud Foundry

```
$ ./mvnw package
$ cf push
```

When a MySQL database is bound to this application, the application will use the MySQL database instead of the embedded H2 database.

## Credits and contributions

This is all based on work from the following:
* Andrew Ripka's [cf-workshop-spring-boot github repo](https://github.com/pivotal-cf-workshop/cf-workshop-spring-boot)
* Marcelo Borges [pcf-ers-demo](https://github.com/Pivotal-Field-Engineering/pcf-ers-demo)

## Courses using this application.

`Note`: When updating this application please make sure the corresponding instructions are updated within the following dependent courses. The instructions for these labs may not change but please review before pushing application to production with this [pipeline](http://concourse.enablement.pivotal.io/pipelines/articulate-jar).

- [pivotal-cloud-foundry-developer](https://github.com/pivotal-education/pivotal-cloud-foundry-developer):
- [pivotal-cloud-foundry-administrator](https://github.com/pivotal-education/pivotal-cloud-foundry-administrator)
