kubectl apply -f KeycloakService.yml
kubectl apply -f KeycloakDeployment.yml

#minikube start --mount-string="kc_data:/opt/keycloak/data/import" --mount
