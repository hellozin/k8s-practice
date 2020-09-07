# k8s-practice
Practice and Demo for K8S

# Mini kube
mini kube 상태 확인

`$ minikube status`

mini kube 시작/종료

`$ minikube start/stop`

mini kube context 사용

`$ kubectl config use-context minikube`

# Simple Tutorial

## ReplicaSet으로 파드 관리하기

**이미지 docker hub에 push**

```bash
$ docker tag demo hellozin/demo
$ docker push hellozin/demo
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

**descriptor 적용**

```bash
$ kubectl apply -f path/to/replica-set.yaml
```

**파드 생성 확인**

```bash
$ kubectl get pods
NAME                    READY   STATUS    RESTARTS   AGE
demo-rs-bz62h   1/1     Running   0          6m42s
demo-rs-nnkv9   1/1     Running   0          6m42s
demo-rs-z4486   1/1     Running   0          6m42s
```

## 서비스 적용하기

```yaml
apiVersion: v1
kind: Service
metadata:
  name: demo-service
spec:
  ports:
  - port: 80
    targetPort: 8080
  selector:
    foo: bar
```

**descriptor 적용**

```bash
$ kubectl create -f path/to/service.yaml
```

## 인그레스 적용하기

```yaml
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: demo-ingress
spec:
  rules:
    - host: hellozin.me
      http:
        paths:
        - path: /
          backend:
            serviceName: demo-service
            servicePort: 80
```

minikube를 사용할 경우 아래 명령어를 통해 ingress 활성화

```bash
ingress addon 활성화 확인
$ minikube addons list

ingress addon 활성화
$ minikube addons enable ingress
```

**descriptor 적용**

```bash
$ kubectl create -f path/to/ingress.yaml
```

로컬 테스트를 위해 `/etc/hosts`에 ingress ip 추가

```bash
$ kubectl get ingresses
NAME           CLASS    HOSTS         ADDRESS        PORTS   AGE
demo-ingress   <none>   hellozin.me   <ingress ip>   80      9m42s

$ cat /etc/hosts
...
# Kubernetes ingress demo
<ingress ip> hellozin.me

$ curl http://hellozin.me
Hi, there.
```