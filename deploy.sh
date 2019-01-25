#! /bin/bash
# oc import-image amq-broker-7/amq-broker-72-openshift --all --from=registry.access.redhat.com/amq-broker-7/amq-broker-72-openshift --confirm -n openshift
# oc replace --force -f https://raw.githubusercontent.com/jboss-container-images/jboss-amq-7-broker-openshift-image/72-1.1.GA/templates/amq-broker-72-basic.yaml -n openshift

# Start the message broker
oc new-app --template=amq-broker-72-basic -e AMQ_PROTOCOL=openwire,amqp,stomp,mqtt,hornetq -e AMQ_QUEUES=demoQueue -e AMQ_USER=user -e AMQ_PASSWORD=pass123

# Start Mysql
oc new-app --template=mysql-persistent -p MYSQL_DATABASE=demodb -p MYSQL_USER=dbuser -p MYSQL_PASSWORD=dbpass123 -p MYSQL_ROOT_PASSWORD=rootpass123

# Start Middleware App

# Start Frontend
oc new-app https://github.com/codequester/nodeos.git --name=nodeos


