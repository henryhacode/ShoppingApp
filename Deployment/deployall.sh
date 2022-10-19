kubectl apply -f CommonConfig.yml

for dir in */ ; do
    echo "$dir"
    cd $dir
    bash deploy.sh
    cd ..
done
