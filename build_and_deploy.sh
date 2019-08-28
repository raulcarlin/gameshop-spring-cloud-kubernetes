# Build jars
./gradlew bootJar

# Create containers
cd api-carts
docker build -t api-carts .
cd ..

cd api-users
docker build -t api-users .
cd ..

# Using Microk8s cluster locally, we need to import the image to the
# local registry and avoid pulls to Docker Hub
docker save api-users > ./k8s/api-users-image.tar
docker save api-carts > ./k8s/api-carts-image.tar

microk8s.ctr -n k8s.io image import ./k8s/api-users-image.tar
microk8s.ctr -n k8s.io image import ./k8s/api-carts-image.tar

# Configs
kubectl apply -f ./k8s/configmap-api-carts.yaml
kubectl apply -f ./k8s/configmap-api-users.yaml

# Deployment
kubectl apply -f ./k8s/deployment-api-carts.yaml
kubectl apply -f ./k8s/deployment-api-users.yaml

# Check
kubectl get pods
# kubectl logs --follow XXXX