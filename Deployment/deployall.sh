kubectl apply -f CommonConfig.yml

services=(
"Accountdb"
"Account"
"Bankdb"
"Bank"
"Creditdb"
"Credit"
"Keycloak"
"Notification"
"Orderdb"
"Order"
"Paymentdb"
"Payment"
"Paypaldb"
"Paypal"
"Productdb"
"Product"
"Shippingdb"
"Shipping"
)

for svc in "${services[@]}"; do
    echo "$svc"
    cd $svc
    bash deploy.sh
    cd ..
done

