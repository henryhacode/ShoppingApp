kubectl apply -f CommonConfig.yml

kubectl apply -f Keycloak/KeycloakService.yml
kubectl apply -f Keycloak/KeycloakDeployment.yml

kubectl apply -f Accountdb/AccountdbConfig.yml
kubectl apply -f Accountdb/AccountdbService.yml
kubectl apply -f Accountdb/AccountdbDeployment.yml

kubectl apply -f Account/AccountService.yml
kubectl apply -f Account/AccountDeployment.yml

kubectl apply -f Productdb/ProductdbConfig.yml
kubectl apply -f Productdb/ProductdbService.yml
kubectl apply -f Productdb/ProductdbDeployment.yml

kubectl apply -f Product/ProductService.yml
kubectl apply -f Product/ProductDeployment.yml

kubectl apply -f Notification/NotificationService.yml
kubectl apply -f Notification/NotificationDeployment.yml
