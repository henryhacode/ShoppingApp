kubectl apply -f keycloakService.yml
kubectl apply -f keycloakDeployment.yml
kubectl apply -f keycloakConfig.yml

#minikube start --mount-string="kc_data:/opt/keycloak/data/import" --mount