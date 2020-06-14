# k8s-practice
Practice and Demo for K8S

# Simple Tutorial
'echoserver' 파드 생성

`kubectl run echoserver --generator=run-pod/v1 --image="k8s.gcr.io/echoserver:1.10" --port=8080`

'echoserver' 서비스 생성

`kubectl expose po echoserver --type=NodePort`

pod, service 정보 확인

`kubectl get [pods, services]`

```bash
$ kubectl get pods
NAME         READY   STATUS    RESTARTS   AGE
echoserver   1/1     Running   0          95s

$ kubectl get services
NAME         TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
echoserver   NodePort    10.103.154.31   <none>        8080:32408/TCP   72s
kubernetes   ClusterIP   10.96.0.1       <none>        443/TCP          3d17h
```

# Todo know
- 서비스 타입
