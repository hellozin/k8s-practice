# k8s-practice
Practice and Demo for K8S

# Mini kube
mini kube 상태 확인

`minikube status`

mini kube 시작/종료

`minikube start/stop`

mini kube context 사용

`kubectl config use-context minikube`

# Simple Tutorial

## ReplicaSet으로 파드 관리하기

**이미지 docker hub에 push**
```bash
docker tag demo hellozin/demo
docker push hellozin/demo
```

**ReplicaSet descriptor 생성**
```yaml
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: demo-rs
spec:
  replicas: 3
  selector:
    matchLabels:
      foo: bar
  template:
    metadata:
      labels:
        foo: bar
    spec:
      containers:
      - name: demo
        image: hellozin/demo
```

descriptor 적용
```shell
kubectl apply -f path/to/replica-set.yaml
```

**파드 생성 확인**
```bash
$ kubectl get pods
NAME                    READY   STATUS    RESTARTS   AGE
demo-rs-bz62h   1/1     Running   0          6m42s
demo-rs-nnkv9   1/1     Running   0          6m42s
demo-rs-z4486   1/1     Running   0          6m42s
```