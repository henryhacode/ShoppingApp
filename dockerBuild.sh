#!/bin/sh

version=0.1
echo $version

cd AccountServices
docker rmi account:$version -f; docker build -t account:$version .
cd ../BankTransaction
docker rmi bank:$version -f; docker build -t bank:$version .
cd ../CreditTransaction
docker rmi credit:$version -f; docker build -t credit:$version .
cd ../NotificationServices
docker rmi notification:$version -f; docker build -t notification:$version .
cd ../Order
docker rmi order:$version -f; docker build -t order:$version .
cd ../Payment
docker rmi payment:$version -f; docker build -t payment:$version .
cd ../PaypalTransaction
docker rmi paypal:$version -f; docker build -t paypal:$version .
cd ../ProductServices
docker rmi product:$version -f; docker build -t product:$version .
cd ../Shipping
docker rmi shipping:$version -f; docker build -t shipping:$version .

docker images

