# Read Me First
Multiverse Project-2

* This application registers and stores a User's information to generate a credit card. 
  This application was created using Kotlin, Spring-Boot, Cassandra, Docker, and Kubernetes.
* This application can run in Docker or Kubernetes

# Getting Started

### Docker
1. To run in Docker, cd into root directory and run 'docker-compose up'
2. This command will create the spring boot app image and pull the cassandra latest image from docker hub.
- The value in CASSANDRA_BROADCAST_ADDRESS environment variable may need to be changed
  to run both the spring application and cassandra docker containers.

- To run only the cassandra docker container, 
  run 'docker-compose up' and stop the spring boot app 
  or comment out the spring boot app in [docker-compose.yaml](docker-compose.yml)

### Kubernetes
1. To run in Kubernetes, use [minikube](https://minikube.sigs.k8s.io/docs/start/) as your kubernetes cluster
   and run 'minikube start'.
2. Load 'cassandra:latest' image into minikube cluster by following this [tutorial.](https://levelup.gitconnected.com/two-easy-ways-to-use-local-docker-images-in-minikube-cd4dcb1a5379)
3. Run these commands in your terminal:
    ```
    kubectl create -f cassandra-service.yaml
    kubectl create -f local-volumes.yaml
    kubectl create -f cassandra-statefulset.yaml
    minikube dashboard
    kubectl exec -it cassandra-0 cqlsh
    create keyspace user_registration with replication = {'class':'SimpleStrategy', 'replication_factor':1};
    create table User(username VARCHAR, firstName VARCHAR, lastName VARCHAR, email VARCHAR, password VARCHAR, role VARCHAR, creditCard VARCHAR, primary key(username, email));
    SELECT * FROM USER;
    kubectl port-forward statefulset/cassandra 9042:9042

### Additional Links
These additional references should also help you:

* [Docker](https://www.docker.com/)
* [Kubernetes](https://kubernetes.io/)

