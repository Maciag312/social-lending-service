This is regular application created via spring.io. Have a look at:
* `Jenkinsfile` you'll find here how to build, push and deploy you application.
* `kubernetes.yaml` check IngressRoute to find out how publish your application with DNS name over HTTPS
* expose management port in you app and set readiness and liveness probes
* remember to push docker images to appropriate registry
* to keep registry easy-to-read, prefix your docker image with project name (ie. `metis-team/metis-social-lending-service`)
* in kubernetes steps use `fintech/kubernetes-agent` agent which contains git, kubectl, helm
* you don't have to specify kubernetes namespace - it's limited to project in which you build (ie. Training apps will be deployed to training namespace only)
* there are two kuberentes configurations available `kubeconfig-sit` and `kubeconfig-sit` (check Jenkinsfile)
* because of using tag `latest` you need to execute `kubectl rollout restart deployment metis-social-lending-service`
* use project as a DNS subdomain, to keep it clear (ie. `metis-social-lending-service.metis-team.fintechchallenge.pl`)
* protect your ingress with basic auth credentials (using Traefik middleware)
* in order to deploy application to production - use dedicated Jenkins job

Application is available here: (username: example, password: example)
* SIT - https://metis-social-lending-service.metis-team.sit.fintechchallenge.pl/
* UAT - https://metis-social-lending-service.metis-team.uat.fintechchallenge.pl/
* PROD - https://metis-social-lending-service.metis-team.fintechchallenge.pl/# social-lending-service
