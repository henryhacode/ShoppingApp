kubectl delete -f CommonConfig.yml

kubectl delete -f Keycloak/KeycloakService.yml
kubectl delete -f Keycloak/KeycloakDeployment.yml
kubectl delete -f Keycloak/KeycloakConfig.yml

kubectl delete -f Account/AccountService.yml
kubectl delete -f Account/AccountDeployment.yml

kubectl delete -f Accountdb/AccountdbConfig.yml
kubectl delete -f Accountdb/AccountdbService.yml
kubectl delete -f Accountdb/AccountdbDeployment.yml

kubectl delete -f Product/ProductService.yml
kubectl delete -f Product/ProductDeployment.yml

kubectl delete -f Productdb/ProductdbConfig.yml
kubectl delete -f Productdb/ProductdbService.yml
kubectl delete -f Productdb/ProductdbDeployment.yml

kubectl delete -f Notification/NotificationService.yml
kubectl delete -f Notification/NotificationDeployment.yml
