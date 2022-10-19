#!/bin/sh

version=0.1
echo $version
username=thiepha
echo $username

docker tag account:$version $username/account:$version
docker tag bank:$version $username/bank:$version
docker tag credit:$version $username/credit:$version
docker tag notification:$version $username/notification:$version
docker tag order:$version $username/order:$version
docker tag payment:$version $username/payment:$version
docker tag paypal:$version $username/paypal:$version
docker tag product:$version $username/product:$version
docker tag shipping:$version $username/shipping:$version

docker images

echo "Going to push..."
docker push $username/account:$version
docker push $username/bank:$version
docker push $username/credit:$version
docker push $username/notification:$version
docker push $username/order:$version
docker push $username/payment:$version
docker push $username/paypal:$version
docker push $username/product:$version
docker push $username/shipping:$version
echo "Done"
