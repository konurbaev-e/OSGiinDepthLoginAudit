# Interservice interaction with circular references

This module is just for testing purposes.

It tests interservice interaction with circular references.

It works but has exception during second service initialization:


g! felix:install file:dist/inter-services-1.0-SNAPSHOT.jar

Bundle ID: 27

g! start 27

ERROR: org.konurbaev.loginaudit.inter-services (27): [org.konurbaev.interservices.firstservice(0)] Circular reference detected, getService returning null

2016-01-16 14:41:59 DEBUG SecondService:31 - Activating SecondService

2016-01-16 14:41:59 DEBUG FirstService:28 - Activating FirstService

2016-01-16 14:41:59 DEBUG SecondService:26 - SecondService Hello


It is because of the bug: https://issues.apache.org/jira/browse/FELIX-4417

But this bug does not prevent both services to be initialized.

As workaround you can use API instead of declarative annotations where you will check if the target service is up and then to use it.