# BTE-webflux-info

### Requirement :

어제 만든 SayHello Server 에서 InfoService Server 로 내부 호출
InfoService 는 호출 파라미터로 찾은 데이터의 직업 응답

### (Spec) :
Heelo Server에서 WebClient로 Api호출 
해당 infoServer에서는 정보(Job)을 넘겨준다.

localhost에서 테스트하기 위해 port 설정
```yml
server:
  port: ${service_port:5555}
```

### (Request) :
```
GET localhost:8080/hello?name=$name
```
### (Response) :

```
application/json
{ “to”: “$name”, “job”: “”, “message”: “hello $name” }
```



